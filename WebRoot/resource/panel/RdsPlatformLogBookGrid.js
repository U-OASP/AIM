/**
 * 值班日志
 */
Ext.define("Rds.panel.RdsPlatformLogBookGrid",{
	extend:'Ext.grid.Panel',
	title:'值班日志',
	requires:['Rds.panel.RdsPlatformNoticeHomeGrid'],
	initComponent:function(){
		var me = this;
        var loguser = Ext.create("Ext.form.field.Text",{
        	name : 'loguser',
			labelWidth : 60,
			width : 200,
			fieldLabel : '值班人员'
        });
        
        var classes = Ext.create("Ext.form.field.Text",{
        	name : 'classes',
			labelWidth : 60,
			width : 200,
			fieldLabel : '班次'
        }); 
        
        var createtime = Ext.create("Ext.form.field.Date",{
        	name : 'createtime',
			labelWidth : 60,
			format : 'Y-m-d',
			value:new Date(),
			width : 200,
			fieldLabel : '填报时间'
        }); 
		
		me.store = Ext.create('Ext.data.Store',{
			fields:['id','loguser','classes','createtime','iserror','mark'],
			proxy: {
                type: 'ajax',
                actionMethods:{read:'POST'},
				url: basepath+'platform/logbook/queryplatformlogbookspage.do',
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
	        			'loguser':loguser.getValue(),
	        			'classes':classes.getValue(),
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
				Rds.panel.RdsPlatformNoticeHomeGrid.showDetails(record).show();
			}	
		};

		me.store.load();
        me.columns = [
                      Ext.create("Ext.grid.RowNumberer",{text: '序号',width:39,align:'center'}),
	      				{text: "值班人员", dataIndex: 'loguser',width:120},
                        {text: "班次",  dataIndex: 'classes',width:120},
                        {text: "填报时间",  dataIndex: 'createtime',width:120},
                        {text: "发现问题",  dataIndex: 'iserror',width:120},
	      				{text: "描述", dataIndex: 'mark',width:300}];
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
                		window.setTitle("发布公告");
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
                		window.setTitle("修改公告");
                		form.down("htmleditor[name=mark]").setValue(record.get("mark"));
                		
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
                    	       url: basepath+"platform/notice/delete.do",  
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
                items: [loguser,classes,createtime,{
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
		
		Ext.define('State', {  
	        extend: 'Ext.data.Model',  
	        fields: [ 
	            { type: 'string', name: 'name' },  
	            { type: 'string', name: 'value' }  
	        ]  
	    });  
	    // The data for all states  
	    var states = [  
	        { "name": "是", "value": "是" },  
	        { "name": "否", "value": "否" } 
	        ];  
	  
	    // The data store holding the states; shared by each of the ComboBox examples below  
	    var store = Ext.create('Ext.data.Store', {  
	        model: 'State',  
	        data: states  
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
                title: '值班日志录入',
                defaults: {
                    labelWidth: 89,
                    anchor: '100%',
                    layout: {
                        type: 'hbox',
                        defaultMargins: {top: 5, right: 5, bottom: 0, left: 0}
                    }
                },
                items: [{
                	xtype:'textfield',
                	name : 'id',
        			labelWidth : 60,
        			hidden:true,
        			readOnly:true,
        			width : 200,
        			labelAlign:'right',
        			fieldLabel : 'id'
                },{
                	xtype:'textfield',
                	name : 'loguser',
        			labelWidth : 60,
        			width : 200,
        			labelAlign:'right',
        			allowBlank:false,
        			value:username,
        			fieldLabel : '值班人员'
                },{
                	xtype:'textfield',
                	name : 'classes',
        			labelWidth : 60,
        			width : 200,
        			labelAlign:'right',
        			allowBlank:false,
        			fieldLabel : '班次'
                },{
                	xtype:'datefield',
                	name : 'createtime',
                	value:new Date(),
        			labelWidth : 60,
        			format:'Y-m-d',
        			allowBlank:false,
        			width : 200,
        			labelAlign:'right',
        			fieldLabel : '填报时间'
                },{
                	xtype:'combo',
                	fieldLabel: '发现问题',  
                    name : 'iserror',
                    displayField: 'value', 
                    valueField:'name',
                    width: 200,  
                    labelWidth: 60,  
                    allowBlank:false,
                    labelAlign:'right',
                    store: store,  
                    queryMode: 'local',  
                    typeAhead: true,
                    value:'否'
                },{
                	xtype:'htmleditor',
                	name : 'mark',
                	labelAlign:'right',
        			labelWidth : 60,
        			allowBlank:false,
        			width : 200,
        			height:250,
        			fieldLabel : '描述'
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
					    url : basepath+"platform/logbook/update.do",  
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