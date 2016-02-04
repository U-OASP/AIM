/**
 * 子任务管理
 */
Ext.define("Rds.panel.RdsPlatformTaskSubGrid",{
	extend:'Ext.grid.Panel',
	title:'子任务管理',
	pid:null,
	config:{
		ischeck:true
	},
	initComponent:function(){
		var me = this;
		
		me.store = Ext.create('Ext.data.Store',{
			fields:['id','tasktitle','userid','taskmark','completetime','pressing','status','createtime','substatus','checketime','checkidea','creater'],
			proxy: {
                type: 'ajax',
                actionMethods:{read:'POST'},
				url: basepath+'platform/task/queryplatformgsubs.do',
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
	        			'pid':me.pid
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
				var panel = me.up("panel").down("panel[region=east]");
				panel.setItems(id);
			}	
		};
//		me.store.load();
        me.columns = [Ext.create("Ext.grid.RowNumberer",{text: '序号',width:39,align:'center'}),
                      {text: "任务标题",  dataIndex: 'tasktitle',width:120},
	      			  {text: "完成时间", dataIndex: 'completetime',width:160},
	      			  {text: "任务内容", dataIndex: 'taskmark',width:160},
                      {text: "紧急程度",  dataIndex: 'pressing',width:120},
                      {text: "创建时间",  dataIndex: 'createtime',width:120},
                      {text: "状态",  dataIndex: 'status',width:80,
                      	renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
                      		return (value*100)+"%";
                      	}
                      }];
        me.selModel = Ext.create('Ext.selection.CheckboxModel',{
			listeners:{
				'selectionchange':function( model, record, index, eOpts ){
					var selects = me.getView().getSelectionModel().getSelection().length;
					var tbar = me.down("toolbar");
					
					var btn_edit = tbar.down("button[name=edit]");
					var btn_upload = tbar.down("button[name=upload]");
					var btn_delete = tbar.down("button[name=delete]");
					
					if(selects==1){
						btn_edit.setDisabled(false);
						btn_upload.setDisabled(false);
						btn_delete.setDisabled(false);
					}else if(selects>1){
						btn_edit.setDisabled(true);
						btn_edit.setDisabled(true);
						btn_delete.setDisabled(false);
					}else if(selects<1){
						btn_edit.setDisabled(true);
						btn_upload.setDisabled(true);
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
            	hidden:!me.ischeck,
            	iconCls:'Applicationformadd',
            	name:'add',
            	listeners: {
                    click:function(){
                    	var north = this.up("panel[name=task]").down("gridpanel[region=north]");
                    	var selects = north.getView().getSelectionModel().getSelection();
                    	
                    	if(selects.length<=0){
                    		Ext.MessageBox.alert("提示", "请选择主任务!");
                    		return;
                    	}
                    	
                		var me = this.up("gridpanel");
                		var form = me.getTrainForm();
                		var window = me.getWindow();
                		window.add(form);
                		window.show();
                		window.setTitle("添加子任务");
                		
                		var f_north = form.down("textfield[name=pid]");
                		f_north.setValue(selects[0].get("id"));                    
                	}
                },
                scope: me
            },{
            	xtype:'button',
            	text:'修改',
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
                		form.loadRecord(record);
                		window.add(form);
                		window.show();
                		window.setTitle("修改子任务");
                		form.down("htmleditor[name=taskmark]").setValue(record.get("taskmark"));
                		var userid = record.get("userid");
                		form.down("combo[name=userid]").select(userid.split(","));//([10005,999,309,10002]);
                		
                    }
                },
                scope: me
            },{
            	xtype:'button',
            	text:'删除',
            	hidden:!me.ischeck,
            	disabled:true,
            	hidden:true,
            	iconCls:'Applicationformdelete',
            	name:'delete',
            	listeners: {
                    click: function(){
                    	var selections = me.getView().getSelectionModel().getSelection();
                    	var codes = '';
                    	for(var i=0;i<selections.length;i++){
                			var item = selections[i];
                			codes = codes +'\''+item.get("tid")+'\'';
                			if(i!=(selections.length-1)){
                				codes = codes+",";
                			}
                		}
                		Ext.Ajax.request({  
                    	       url: basepath+"platform/train/delete.do",  
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
            	text:'上传附件',
            	hidden:!me.ischeck,
            	hidden:true,
            	iconCls:'Applicationformedit',
            	disabled:true,
            	name:'upload',
            	listeners: {
                    click: function(){
                    	var selections = me.getView().getSelectionModel().getSelection();
                    	var record = selections[0];
                    	
                    	var win = Ext.create("Ext.window.Window",{
                    		title:'上传文件',
                    		layout:'border',
                    		width:400,
                    		height:150
                    	});
                    	
                    	var form = Ext.create('Ext.form.Panel', {  
//                            title: 'File Uploader', 
                            region:'center',
//                            width: 400,  
                            bodyPadding: 20,  
                            frame: true,  
//                            renderTo: 'fi-form',  
                            items: [{  
                                xtype: 'filefield',  
                                name: 'file',  
                                fieldLabel: '文件',  
                                labelWidth: 60,  
                                allowBlank:false,
                                width : 200,
//                                msgTarget: 'side',  
                                allowBlank: false,  
                                anchor: '80%',  
                                labelAlign:'right',
                                buttonText: '选择'  
                            },{
                            	xtype: 'textfield',
                            	name : 'filename',
                    			labelWidth : 60,
                    			allowBlank:false,
                    			width : 200,
                    			anchor: '80%', 
                    			labelAlign:'right',
                    			fieldLabel : '文件名'
                            },{
                            	xtype: 'textfield',
                            	name : 'tid',
                            	allowBlank:false,
                    			labelWidth : 60,
                    			value:record.get("tid"),
                    			width : 200,
                    			labelAlign:'right',
                    			anchor: '80%', 
                    			fieldLabel : 'tid'
                            }],  
                       
                            buttons: [{  
                                text: '上传',  
                                handler: function() {  
                                    var form = this.up('form').getForm();  
                                    if(form.isValid()){  
                                        form.submit({  
                                            url: basepath+"platform/train/upload.do", 
                                            waitMsg: '正在上传文件...',  
                                            success: function(fp, o) {  
                                            	win.close();
                                                Ext.Msg.alert('提示', '上传文件成功.');  
                                            }  
                                        });  
                                    }  
                                }  
                            }]  
                        }); 
                    	
                    	win.add(form);
                    	win.show();
                		
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
		var users = Ext.create("Ext.form.field.ComboBox",{
        	name:'userid', 
//            value:'310', 
        	multiSelect:true, 
            width: 200, 
            fieldLabel: '人员', 
            allowBlank:false,
            labelWidth: 80, 
            labelAlign:'right',
            emptyText: '请选择', 
            queryMode:'local',  //这个需要加上。。
            store: new Ext.data.Store({ 
                singleton : true, 
                proxy: { 
                        type: 'ajax', 
                        url : basepath+'platform/userinfos/queryplatformalluserinfos.do', 
                        actionMethods : 'post', 
                        reader: { 
                            type: 'json', 
                            totalProperty: 'ChannelCount', 
                            root: 'root' 
                        } 
                }, 
                fields:['userid', 'username','loginname'], //不管有没有model，这个fields都必须写，而且只能写在这里，
                autoLoad:true 

            }), 
            loadingText:'正在加载数据，请稍侯……', 
            triggerAction:'all', 
            valueField:'userid', 
            displayField:'loginname'
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
                title: '任务登记管理',
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
                	xtype:'textfield',
                	name : 'tasktitle',
        			labelWidth : 80,
        			allowBlank:false,
        			width : 200,
        			labelAlign:'right',
        			fieldLabel : '任务标题'
                },users,{
                	xtype:'datefield',
                	name : 'completetime',
//                	value:new Date(),
        			labelWidth : 80,
        			format:'Y-m-d',
        			allowBlank:false,
        			width : 200,
        			labelAlign:'right',
        			fieldLabel : '完成时间'
                },{
                	xtype:'textfield',
                	name : 'pressing',
        			labelWidth : 80,
        			width : 200,
        			labelAlign:'right',
        			allowBlank:false,
        			fieldLabel : '紧急程度'
                },{
                	xtype:'textfield',
                	name : 'creater',
                	value:username,
        			labelWidth : 80,
        			hidden:true,
        			width : 200,
        			allowBlank:false,
        			labelAlign:'right',
        			fieldLabel : '创建人'
                },{
                	xtype:'htmleditor',
                	name : 'taskmark',
        			labelWidth : 80,
        			width : 200,
        			height:250,
        			allowBlank:false,
        			labelAlign:'right',
        			fieldLabel : '内容描述'
                },{
                	xtype:'textfield',
                	name : 'pid',
        			labelWidth : 80,
        			width : 200,
        			allowBlank:false,
        			hidden:true,
        			labelAlign:'right',
        			fieldLabel : 'pid'
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
					    url : basepath+"platform/task/updatesubtask.do",  
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