/**
 * 业务公开
 */
Ext.define("Rds.panel.RdsPlatformBusinessGrid",{
	extend:'Ext.grid.Panel',
	title:'业务公开',
	requires:['Rds.panel.RdsPlatformBusinessHomeGrid'],
	initComponent:function(){
		var me = this;
		
		var title = Ext.create("Ext.form.field.Text",{
        	name : 'title',
			labelWidth : 60,
			width : 200,
			fieldLabel : '信息标题'
        });
        
        var content = Ext.create("Ext.form.field.Text",{
        	name : 'content',
			labelWidth : 60,
			width : 200,
			fieldLabel : '内容'
        }); 
        
        var createtime = Ext.create("Ext.form.field.Date",{
        	name : 'createtime',
			labelWidth : 60,
			format : 'Y-m-d',
			value:new Date(),
			width : 200,
			fieldLabel : '创建时间'
        }); 
		
		me.store = Ext.create('Ext.data.Store',{
			fields:['id','title','createtime','creater','content'],
			proxy: {
                type: 'ajax',
                actionMethods:{read:'POST'},
				url: basepath+'platform/business/queryplatformbusinesspage.do',
                params:{
                },
                reader: {
                    type: 'json',
                    root:'data',
                    totalProperty:'total'
                }
            },
            listeners:{
            	beforeload:function( store, operation, eOpts ){
	        		Ext.apply(store.proxy.extraParams, {
	        			'title':title.getValue(),
	        			'content':content.getValue(),
	        			'createtime':Ext.util.Format.date(createtime.getValue(),'Y-m-d')
	        		});
	        	},
	        	load:function(){
	        		me.selModel.deselectAll();
	        	}
            }
		});
		
		me.listeners={
				'itemdblclick':function( grid, record, item, index, e, eOpts ){
					Rds.panel.RdsPlatformBusinessHomeGrid.showDetails(record).show();
				}	
			};

		me.store.load();
        me.columns = [
               				Ext.create("Ext.grid.RowNumberer",{text: '序号',width:39,align:'center'}),
            				{text: "信息标题", dataIndex: 'title',width:260},
            				{
    	      					xtype:'actioncolumn',
    	      			        header:'操作',
    	      			        width:100,
    	      			        items: [{
    	      			            //icon: 'nacCore/nacCoreApp/nacApp/images/mainmenu/db_restore.png', 
    	      			            tooltip: '查看详细',
    	      			            text:'查看详细',
    	      			            title:'查看详细',
    	      			            iconCls: 'Applicationviewdetail' ,
    	      			            handler:function(view,rowIndex,colIndex,item,record){
    	      			            	var id = view.getStore().getAt(rowIndex).get("id");
    	      			            	me.openWindow(id);
    	      			            }
    	      			        }],
    	      			        width:80
    	      			    }
            			];
        me.selModel = Ext.create('Ext.selection.CheckboxModel',{
			listeners:{
				'selectionchange':function( model, record, index, eOpts ){
					var selects = me.getView().getSelectionModel().getSelection().length;
					var tbar = me.down("toolbar");
					
					var btn_edit = tbar.down("button[name=edit]");
					var btn_delete = tbar.down("button[name=delete]");
					
					if(selects==1){
						btn_edit.setDisabled(false);
						btn_delete.setDisabled(false);
					}else if(selects>1){
						btn_edit.setDisabled(true);
						btn_delete.setDisabled(false);
					}else if(selects<1){
						btn_edit.setDisabled(true);
						btn_delete.setDisabled(true);
					}
				}
			}
		});
        
        me.dockedItems = [{
			xtype : 'toolbar',
			name : 'menu',
			dock : 'top',
			items : [{
            	xtype:'button',
            	text:'添加',
            	iconCls:'Applicationformadd',
            	name:'add',
            	listeners: {
                    click:function(){
                		var me = this.up("gridpanel");
                		var form = me.getNoticeForm();
                		var window = me.getWindow();
                		window.add(form);
                		window.show();
                		window.setTitle("创建业务公开");
                    }
                },
                scope: me
            },{
            	xtype:'button',
            	text:'修改',
            	iconCls:'Applicationformedit',
            	disabled:true,
            	name:'edit',
            	listeners: {
                    click: function(){
                    	var me = this.up("gridpanel");
                		var selects = me.getView().getSelectionModel().getSelection();
                		var form = me.getNoticeForm();
                		var window = me.getWindow();
                		var record = selects[0];
                		form.loadRecord(record);
                		window.add(form);
                		window.show();
                		window.setTitle("修改业务公开");
                		form.down("htmleditor[name=content]").setValue(record.get("content"));
                		
                    }
                },
                scope: me
            },{
            	xtype:'button',
            	text:'删除',
            	disabled:true,
            	iconCls:'Applicationformdelete',
            	name:'delete',
            	listeners: {
                    click: function(){
                    	var selections = me.getView().getSelectionModel().getSelection();
                    	var codes = '';
                    	for(var i=0;i<selections.length;i++){
                			var item = selections[i];
                			codes = codes +'\''+item.get("id")+'\'';
                			if(i!=(selections.length-1)){
                				codes = codes+",";
                			}
                		}
                		Ext.Ajax.request({  
                    	       url: basepath+"platform/business/delete.do",  
                    	       method: "POST",
                    	       params: { 
                    	    	   "ids":codes
                    	       },

                    	       success: function (response, option) {  
     	               	    	response = Ext.JSON.decode(response.responseText);  
     	                        if (response.code == '10000') {  
     	                        	Ext.Msg.alert("提示", "删除成功");
     	                        	me.getStore().reload();
     	                        }else if(response.code == '10001') { 
     	                       	   Ext.MessageBox.alert("错误信息", "没有删除记录!");
     	                        } 
                    	       },  
                    	       failure: function () { Ext.Msg.alert("提示", "保存失败<br>没有捕获到异常"); }  
                      	});
                    		
                    }
                },
                scope: me
            },{
            	xtype:'button',
            	text:'刷新',
            	iconCls:'Arrowrotateclockwise',
            	name:'refresh',
            	listeners: {
                    click: function() {

                    	var store = me.getStore();
                    	store.reload();
                    }
                },
                scope: me
            }]
		},{
			xtype : 'toolbar',
			name : 'search',
			dock : 'top',
			items : [{  
                xtype: 'buttongroup',  
                columns: 6,   
                floatable:true,  
                defaults: {  
                    scale: 'small'  
                },  
                items: [title,content,createtime,{
					xtype : 'button',
					text:'查询',
					iconCls : 'Find',
					handler:me.onSearch
				}]
			}]
		}];
        
        me.bbar = new Ext.PagingToolbar({
			pageSize : 25,  // 一页显示25行
			store : me.store,  // 前面定义的store
       	 	displayInfo : true, // 是否显示总体信息
       	 	displayMsg : "第 {0} - {1} 条  共 {2} 条",
       	 	emptyMsg : "没有符合条件的记录"
		});

		me.callParent(arguments);
	},
	
	onSearch:function(){
		var me = this.up("gridpanel");
		me.getStore().currentPage = 1;
		var store = me.getStore();
    	store.reload();
	},
	
	getNoticeForm:function(){
		
		var store = Ext.create('Ext.data.TreeStore',   {    
			proxy : {      
				type :   'ajax',     
				url :   basepath+'platform/userinfos/queryplatformuserinfos.do'   
			},     
			root:   {      
				expanded: true  
			},     
			autoLoad:true   
		}); 
		
		var combotree = Ext.create('Rds.ux.TreeCombo', {
//		    margin:10,
		    labelWidth : 60,
			width : 200,
			fieldLabel : '视图范围',
		    treeWidth: 400,
		    name:'permission',
		    store : store
		});
		
		var form = Ext.create("Ext.form.Panel",{
			region:'center',
			style : 'margin-left:5px;margin-right:5px;margin-top:5px;margin-bottom:5px;',
            labelAlign:"right",
            bodyPadding: 10,
            defaults: {
                anchor: '100%',
                labelWidth: 100
            },
            border:false,
            items: [{
                xtype: 'fieldset',
                title: '业务公开录入',
                //collapsible: true,
                defaults: {
                    labelWidth: 89,
                    anchor: '100%',
                    layout: {
                        type: 'hbox',
                        defaultMargins: {top: 5, right: 5, bottom: 0, left: 0}
                    }
                },
                items: [combotree,{
                	xtype:'textfield',
                	name : 'id',
        			labelWidth : 60,
        			hidden:true,
        			readOnly:true,
        			labelAlign:'right',
        			width : 200,
        			fieldLabel : 'id'
                },{
                	xtype:'textfield',
                	name : 'title',
        			labelWidth : 60,
        			width : 200,
        			labelAlign:'right',
        			fieldLabel : '信息标题'
                },{
                	xtype:'textfield',
                	name : 'creater',
        			labelWidth : 60,
        			width : 200,
        			labelAlign:'right',
        			fieldLabel : '创建者'
                },{
                	xtype:'datefield',
                	name : 'createtime',
                	value:new Date(),
        			labelWidth : 60,
        			format:'Y-m-d',
        			width : 200,
        			labelAlign:'right',
        			fieldLabel : '创建时间'
                },{
                	xtype:'htmleditor',
                	name : 'content',
        			labelWidth : 60,
        			width : 200,
        			height:300,
        			labelAlign:'right',
        			fieldLabel : '内容'
                }]
            }]
		});
		
		return form;
	},
	
	getWindow:function(){
		var me = this;
		var win = Ext.create("Ext.window.Window",{
			title:'title',
			width:475,
			height:550,
			layout:'border',
			buttons:[{
				text:'保存',
				handler:function(){
					var form = win.down("form");
					form.submit({  
					    url : basepath+"platform/business/update.do",  
					    baseParams : { 
					    },  
					    waitMsg : '正在提交数据',  
					    waitTitle : '提示',  
					    method : "POST",  
					    success : function(form, action) {  
					        // 得到数据  
					        var result = Ext.JSON.decode(action.response.responseText);// 就可以取出来。如果是数组，那么很简单  
					        if(result.code=='10000'){
					        	Ext.Msg.alert('提示', "保存成功！！！"); 
					        	me.getStore().load();
					        	win.close();
					        }
					    },  
					    failure : function(form, action) {  
					        Ext.Msg.alert('提示', "操作失败：输入非法字符！！！");  
					    }  
					});  
				}
			},{
				text:'取消',
				handler:function(){
					win.close();
				}
			}]
		
		});
		return win;
	}
});