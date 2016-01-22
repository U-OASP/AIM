/**
 * 外出登记
 */
Ext.define("Rds.panel.RdsPlatformGoOutGrid",{
	extend:'Ext.grid.Panel',
	title:'外出登记',
	requires:['Rds.ux.DateTimeField'],
	initComponent:function(){
		var me = this;
        var title = Ext.create("Ext.form.field.Text",{
        	name : 'title',
			labelWidth : 60,
			width : 200,
			fieldLabel : '外出标题'
        });
        
        var content = Ext.create("Ext.form.field.Text",{
        	name : 'content',
			labelWidth : 60,
			width : 200,
			fieldLabel : '外出内容'
        }); 
        
        var goouter = Ext.create("Ext.form.field.Text",{
        	name : 'goouter',
			labelWidth : 60,
			width : 200,
			fieldLabel : '外出人员'
        }); 
		
		me.store = Ext.create('Ext.data.Store',{
			fields:['id','title','content','starttime','endtime','reguser','regtime','status','goouter','approval','approvaltime'],
			proxy: {
                type: 'ajax',
                actionMethods:{read:'POST'},
				url: basepath+'platform/goout/queryplatformgooutspage.do',
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
	        			'goouter':goouter.getValue()
	        		});
	        	},
	        	load:function(){
	        		me.selModel.deselectAll();
	        	}
            }
		});
		
		me.listeners={
			'itemdblclick':function( grid, record, item, index, e, eOpts ){
//				Rds.panel.RdsPlatformNoticeHomeGrid.showDetails(record).show();
			}	
		};

		me.store.load();
        me.columns = [
                      Ext.create("Ext.grid.RowNumberer",{text: '序号',width:39,align:'center'}),
                      {text: "外出标题", dataIndex: 'title',width:200},
                    	{text: "外出人员", dataIndex: 'goouter',width:100},
	      				{text: "外出内容", dataIndex: 'content',width:250},
                      {text: "起始时间",  dataIndex: 'starttime',width:120},
                      {text: "结束时间",  dataIndex: 'endtime',width:120},
//                      {text: "登记人员",  dataIndex: 'reguser',width:80},
                      {text: "登记时间",  dataIndex: 'regtime',width:200},
                      {text: "状态",  dataIndex: 'status',width:160,
                      	renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
                      		var result = "";
                      		if(value=='-1'){
                      			result = "不通过";
                      		}else if(value==1){
                      			result = "审核中";
                      		}else if(value==2){
                      			result = "审核通过";
                      		}
                      		return result;
                      	}
                      },
                      {text: "审批理由",  dataIndex: 'approval',width:160},
                      {text: "审批时间",  dataIndex: 'approvaltime',width:100}];
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
                		window.setTitle("申请登记");
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
                		var record = selects[0];
                		var status = record.get("status");
                		if(status!=1){
                			Ext.Msg.alert('提示', "不能修改已经审核过的申请!"); 
                			return;
                		}
                		var form = me.getNoticeForm();
                		var window = me.getWindow();
                		form.loadRecord(record);
                		window.add(form);
                		window.show();
                		window.setTitle("修改申请");
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
                    		var status = item.get("status");
                    		if(status!=1){
                    			Ext.Msg.alert('提示', "不能删除已经审核过的申请!"); 
                    			return;
                    		}
                			codes = codes +'\''+item.get("id")+'\'';
                			if(i!=(selections.length-1)){
                				codes = codes+",";
                			}
                		}
                		Ext.Ajax.request({  
                    	       url: basepath+"platform/goout/delete.do",  
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
                items: [title,content,goouter,{
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
                title: '申请登记',
                //collapsible: true,
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
                	name : 'goouter',
        			labelWidth : 60,
        			width : 200,
        			labelAlign:'right',
        			readOnly:true,
        			allowBlank:false,
        			value:username,
        			fieldLabel : '外出人员'
                },{
                	xtype:'textfield',
                	name : 'title',
        			labelWidth : 60,
        			width : 200,
        			allowBlank:false,
        			labelAlign:'right',
        			fieldLabel : '外出标题'
                },{
                	xtype:'datetimefield',
                	name : 'starttime',
                	value:new Date(),
        			labelWidth : 60,
        			allowBlank:false,
        			format: 'Y-m-d H:i:s',
        			width : 200,
        			labelAlign:'right',
        			fieldLabel : '起始时间'
                },{
                	xtype:'datetimefield',
                	name : 'endtime',
                	value:new Date(),
        			labelWidth : 60,
        			allowBlank:false,
        			format: 'Y-m-d H:i:s',
        			width : 200,
        			labelAlign:'right',
        			fieldLabel : '结束时间'
                },{
                	xtype:'htmleditor',
                	allowBlank:false,
                	name : 'content',
        			labelWidth : 60,
        			width : 200,
        			height:250,
        			labelAlign:'right',
        			fieldLabel : '外出内容'
                },{
                	xtype:'textfield',
                	name : 'reguser',
        			labelWidth : 60,
        			hidden:true,
        			allowBlank:false,
        			value:username,
        			width : 200,
        			labelAlign:'right',
        			fieldLabel : '登记人员'
                },{
                	xtype:'textfield',
                	name : 'status',
        			labelWidth : 60,
        			width : 200,
        			allowBlank:false,
        			labelAlign:'right',
        			hidden:true,
        			value:'1',
        			fieldLabel : '状态'
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
					    url : basepath+"platform/goout/update.do",  
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