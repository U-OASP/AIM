/**
 * 任务处理
 */
Ext.define("Rds.panel.RdsPlatformTaskHandleGrid",{
	extend:'Ext.grid.Panel',
	pid:null,
	config:{
		ischeck:true
	},
	initComponent:function(){
		var me = this;

		me.store = Ext.create('Ext.data.Store',{
			fields:['id','tasktitle','taskmark','completetime','pressing','status','createtime','substatus','checketime','checkidea','creater'],
			proxy: {
                type: 'ajax',
                actionMethods:{read:'POST'},
				url: basepath+'platform/task/queryplatformgsubsbyuser.do',
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
	        			'pid':me.pid,
	        			userid:userid
	        		});
	        	},
	        	load:function(){
	        		me.selModel.deselectAll();
	        	}
            }
		});
		
		me.listeners={
			'itemclick':function( grid, record, item, index, e, eOpts ){
				
				var id = record.get("id");
				var grid = me.up("panel").down("gridpanel[region=center]");
				var store = grid.getStore();
				grid.taskid = id;
				store.load();
			}	
		};
		me.store.load();
        me.columns = [Ext.create("Ext.grid.RowNumberer",{text: '序号',width:39,align:'center'}),
                      {text: "任务标题",  dataIndex: 'tasktitle',width:120},
	      			  {text: "完成时间", dataIndex: 'completetime',width:160},
	      			  {text: "任务内容", dataIndex: 'taskmark',width:160},
                      {text: "紧急程度",  dataIndex: 'pressing',width:120},
                      {text: "创建时间",  dataIndex: 'createtime',width:120},
                      {text: "状态",  dataIndex: 'status',width:80,
                      	renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
                      		var result = "";
                      		if(value==0){
                      			result = "等待完成";
                      		}else if(value==1){
                      			result = "已完成";
                      		}
                      		return result;
                      	}
                      }];
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
            	text:'反馈',
            	hidden:!me.ischeck,
            	iconCls:'Applicationformedit',
            	disabled:true,
            	name:'edit',
            	listeners: {
                    click: function(){
                    	var me = this.up("gridpanel");
                		var selects = me.getView().getSelectionModel().getSelection();
                		var form = me.getTrainForm();
                		var window = me.getWindow();
                		var record = selects[0];
//                		form.loadRecord(record);
                		var taskid = form.down("textfield[name=taskid]");
                		taskid.setValue(record.get("id"));
                		window.add(form);
                		window.show();
                		window.setTitle("任务反馈");
                		
                    }
                },
                scope: me
            },{
            	xtype:'button',
            	text:'确认完成',
            	hidden:!me.ischeck,
            	disabled:true,
            	iconCls:'Applicationformdelete',
            	name:'delete',
            	listeners: {
                    click: function(){
                    	var selections = me.getView().getSelectionModel().getSelection();
                    	if(selections[0].get("status")=='1'){
                    		Ext.Msg.alert("提示","此单已完成");
                    		return;
                    	}
                    	Ext.Msg.confirm("提示","确认完成吗？确认后将无法恢复!",function(btn){
                    		if(btn=='yes'){
                    			
                            	var codes = '';
                            	for(var i=0;i<selections.length;i++){
                        			var item = selections[i];
                        			codes = codes +'\''+item.get("id")+'\'';
                        			if(i!=(selections.length-1)){
                        				codes = codes+",";
                        			}
                        		}
                        		Ext.Ajax.request({  
                            	       url: basepath+"platform/task/updatesubscomplete.do",  
                            	       method: "POST",
                            	       params: { 
                            	    	   "ids":codes,
                            	    	   userid:userid
                            	       },

                            	       success: function (response, option) {  
             	               	    	response = Ext.JSON.decode(response.responseText);  
             	                        if (response.code == '10000') {  
             	                        	Ext.Msg.alert("提示", "设置成功");
             	                        	me.getStore().reload();
             	                        }else if(response.code == '10001') { 
             	                       	   Ext.MessageBox.alert("错误信息", "没有删除记录!");
             	                        } 
                            	       },  
                            	       failure: function () { Ext.Msg.alert("提示", "保存失败<br>没有捕获到异常"); }  
                              	});						
                    	    }
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
		}];
        
//        me.bbar = new Ext.PagingToolbar({
//			pageSize : 25,  // 一页显示25行
//			store : me.store,  // 前面定义的store
//       	 	displayInfo : true, // 是否显示总体信息
//       	 	displayMsg : "第 {0} - {1} 条  共 {2} 条",
//       	 	emptyMsg : "没有符合条件的记录"
//		});
		me.callParent(arguments);
	},
	
	onSearch:function(){
		var me = this.up("gridpanel");
		me.getStore().currentPage = 1;
		var store = me.getStore();
    	store.reload();
	},
	
	/**
	 * 表单内容
	 */
	getTrainForm:function(){
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
                title: '任务反馈',
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
        			labelWidth : 80,
        			hidden:true,
        			readOnly:true,
        			labelAlign:'right',
        			width : 200,
        			fieldLabel : 'id'
                },{
                	xtype:'htmleditor',
                	name : 'fbmark',
        			labelWidth : 80,
        			allowBlank:false,
        			width : 200,
        			labelAlign:'right',
        			height:250,
        			fieldLabel : '反馈内容'
                },{
                	xtype:'textfield',
                	name : 'taskid',
        			labelWidth : 80,
        			labelAlign:'right',
        			allowBlank:false,
        			width : 200,
//        			hidden:true,
        			fieldLabel : 'taskid'
                },{  
                    xtype: 'filefield',  
                    name: 'file',  
                    fieldLabel: '上传文件',  
                    allowBlank:false,
                    labelWidth: 80,  
                    width : 200,
                    labelAlign:'right',
//                    allowBlank: false,  
                    anchor: '80%',  
                    buttonText: '选择'  
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
					    url : basepath+"platform/task/upload.do",  
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
					        	win.close();
								var grid = me.up("panel").down("gridpanel[region=center]");
								var store = grid.getStore();
								store.reload();
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