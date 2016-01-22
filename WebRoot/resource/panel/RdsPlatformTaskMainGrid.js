/**
 * 主任务管理
 */
Ext.define("Rds.panel.RdsPlatformTaskMainGrid",{
	extend:'Ext.grid.Panel',
//	title:'培训管理',
	config:{
		ischeck:true
	},
	initComponent:function(){
		var me = this;
        var tasktitle = Ext.create("Ext.form.field.Text",{
        	name : 'tasktitle',
			labelWidth : 60,
			width : 200,
			fieldLabel : '任务标题'
        });
        
        var taskmark = Ext.create("Ext.form.field.Text",{
        	name : 'taskmark',
			labelWidth : 60,
			width : 200,
			fieldLabel : '任务内容'
        }); 
        
        var completetime = Ext.create("Ext.form.field.Date",{
        	name : 'completetime',
			labelWidth : 60,
			format : 'Y-m-d',
			width : 200,
			fieldLabel : '完成时间'
        }); 
		
		me.store = Ext.create('Ext.data.Store',{
			fields:['id','tasktitle','taskmark','completetime','pressing','issure','status','createtime','substatus','checketime','checkidea','creater'],
			proxy: {
                type: 'ajax',
                actionMethods:{read:'POST'},
				url: basepath+'platform/task/queryplatformmaintaskspage.do',
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
	        			'tasktitle':tasktitle.getValue(),
	        			'taskmark':taskmark.getValue(),
	        			'completetime':Ext.util.Format.date(completetime.getValue(),'Y-m-d')
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
				grid.pid = id;
				store.load();
			}	
		};
		
		me.store.load();
        me.columns = [
                      Ext.create("Ext.grid.RowNumberer",{text: '序号',width:39,align:'center'}),
                        {text: "任务标题",  dataIndex: 'tasktitle',width:120},
	      				{text: "完成时间", dataIndex: 'completetime',width:160},
	      				{text: "任务内容", dataIndex: 'taskmark',width:160},
                        {text: "紧急程度",  dataIndex: 'pressing',width:120},
                        {text: "创建时间",  dataIndex: 'createtime',width:120},
                        {text: "审批时间",  dataIndex: 'checketime',width:120},
                        {text: "审批意见",  dataIndex: 'checkidea',width:120},
                        {text: "状态",  dataIndex: 'status',width:160,
                        	renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
                        		var result = "";
                        		if(value=='-1'){
                        			result = "不通过";
                        		}else if(value==0){
                        			result = "已登记";
                        		}else if(value==1){
                        			result = "审核通过";
                        		}
                        		return result;
                        	}
                        },
                        {text: "状态",  dataIndex: 'issure',width:160,
                        	renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
                        		var result = "";
                        		if(value=='0'){
                        			result = "未确认";
                        		}else if(value==1){
                        			result = "已确认";
                        		}
                        		return result;
                        	}
                        },
                        {text: "完成情况",  dataIndex: 'substatus',width:160},
                        {text: "创建者",  dataIndex: 'creater',width:120}];
        me.selModel = Ext.create('Ext.selection.CheckboxModel',{
			listeners:{
				'selectionchange':function( model, record, index, eOpts ){
					var selects = me.getView().getSelectionModel().getSelection().length;
					var tbar = me.down("toolbar");
					
					var btn_edit = tbar.down("button[name=edit]");
					var btn_upload = tbar.down("button[name=upload]");
					var btn_delete = tbar.down("button[name=delete]");
					var btn_sure = tbar.down("button[name=sure]");
					
					if(selects==1){
						btn_edit.setDisabled(false);
						btn_upload.setDisabled(false);
						btn_delete.setDisabled(false);
						btn_sure.setDisabled(false);
					}else if(selects>1){
						btn_edit.setDisabled(true);
						btn_edit.setDisabled(true);
						btn_delete.setDisabled(false);
						btn_sure.setDisabled(false);
					}else if(selects<1){
						btn_edit.setDisabled(true);
						btn_upload.setDisabled(true);
						btn_delete.setDisabled(true);
						btn_sure.setDisabled(true);
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
                		var me = this.up("gridpanel");
                		var form = me.getTrainForm();
                		var window = me.getWindow();
                		window.add(form);
                		window.show();
                		window.setTitle("新增任务");
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
                		window.setTitle("修改任务");
                		form.down("htmleditor[name=taskmark]").setValue(record.get("taskmark"));
                		
                    }
                },
                scope: me
            },{
            	xtype:'button',
            	text:'删除',
            	disabled:true,
            	hidden:!me.ischeck,
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
                    	       url: basepath+"platform/task/deletemaintask.do",  
                    	       method: "POST",
                    	       params: { 
                    	    	   "ids":codes
                    	       },

                    	       success: function (response, option) {  
     	               	    	response = Ext.JSON.decode(response.responseText);  
     	                        if (response.code == '10000') {  
     	                        	Ext.Msg.alert("提示", "删除成功");
     	                        	me.getStore().reload();
     	                        	
     	                        	var center = me.up("panel[name=task]").down("gridpanel[region=center]");
     	                        	center.getStore().reload();
     	                        	
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
            	text:'审核',
            	hidden:me.ischeck,
            	iconCls:'Applicationformedit',
//            	disabled:true,
            	name:'check',
            	listeners: {
                    click: function(){
                    	var me = this.up("gridpanel");
                		var selects = me.getView().getSelectionModel().getSelection();
                		var record = selects[0];
                		var status = record.get("status");
                		if(status!=0){
                			Ext.Msg.alert('提示', "只能审核提交的申请，不能审核已经审核过的申请!"); 
                			return;
                		}
                		
                		var form = me.getTrainForm();
                		var window = me.getCheckWindow();
                		
                		form.loadRecord(record);
                		window.add(form);
                		window.show();
                		window.setTitle("审批");
                		form.down("htmleditor[name=taskmark]").setValue(record.get("taskmark"));
                		
                    }
                },
                scope: me
            },{
            	xtype:'button',
            	text:'上传附件',
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
                                width : 200,
//                                msgTarget: 'side',  
                                allowBlank: false,  
                                labelAlign:'right',
                                anchor: '80%',  
                                buttonText: '选择'  
                            },{
                            	xtype: 'textfield',
                            	name : 'filename',
                    			labelWidth : 60,
                    			width : 200,
                    			labelAlign:'right',
                    			anchor: '80%', 
                    			fieldLabel : '文件名'
                            },{
                            	xtype: 'textfield',
                            	name : 'tid',
                    			labelWidth : 60,
                    			labelAlign:'right',
                    			value:record.get("tid"),
                    			width : 200,
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
            	text:'确认',
            	disabled:true,
            	hidden:!me.ischeck,
            	iconCls:'Applicationformdelete',
            	name:'sure',
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
                    	       url: basepath+"platform/task/updatesure.do",  
                    	       method: "POST",
                    	       params: { 
                    	    	   "ids":codes
                    	       },

                    	       success: function (response, option) {  
     	               	    	response = Ext.JSON.decode(response.responseText);  
     	                        if (response.code == '10000') {  
     	                        	Ext.Msg.alert("提示", "确认成功");
     	                        	me.getStore().reload();
     	                        	
     	                        	var center = me.up("panel[name=task]").down("gridpanel[region=center]");
     	                        	center.getStore().reload();
     	                        	
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
                items: [tasktitle,taskmark,completetime,{
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
	
	/**
	 * 表单内容
	 */
	getTrainForm:function(){
		var me = this;
		var form = Ext.create("Ext.form.Panel",{
			region:'center',
			style : 'margin-left:5px;margin-right:5px;margin-top:5px;margin-bottom:5px;',
            labelAlign:"right",
            autoScroll:true,
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
        			width : 200,
        			labelAlign:'right',
        			fieldLabel : 'id'
                },{
                	xtype:'textfield',
                	name : 'tasktitle',
        			labelWidth : 80,
        			allowBlank:false,
        			width : 200,
        			labelAlign:'right',
        			readOnly:!me.ischeck,
        			fieldLabel : '任务标题'
                },{
                	xtype:'datefield',
                	name : 'completetime',
//                	value:new Date(),
        			labelWidth : 80,
        			allowBlank:false,
        			format:'Y-m-d',
        			readOnly:!me.ischeck,
        			width : 200,
        			labelAlign:'right',
        			fieldLabel : '完成时间'
                },{
                	xtype:'textfield',
                	name : 'pressing',
        			labelWidth : 80,
        			allowBlank:false,
        			readOnly:!me.ischeck,
        			width : 200,
        			labelAlign:'right',
        			fieldLabel : '紧急程度'
                },{
                	xtype:'textfield',
                	name : 'creater',
                	value:username,
                	allowBlank:false,
        			labelWidth : 80,
        			readOnly:!me.ischeck,
        			hidden:true,
        			labelAlign:'right',
        			width : 200,
        			fieldLabel : '创建人'
                },{
                	xtype:'htmleditor',
                	name : 'taskmark',
                	allowBlank:false,
        			labelWidth : 80,
        			readOnly:!me.ischeck,
        			width : 200,
        			height:250,
        			labelAlign:'right',
        			fieldLabel : '内容描述'
                },{
                	xtype:'htmleditor',
                	name : 'checkidea',
        			labelWidth : 80,
        			allowBlank:false,
        			readOnly:me.ischeck,
        			hidden:me.ischeck,
        			width : 200,
        			labelAlign:'right',
        			height:250,
        			fieldLabel : '审核意见'
                }]
            }]
		});
		
		return form;
	},
	
	getCheckWindow:function(){
		var me = this;
		var win = Ext.create("Ext.window.Window",{
			title:'title',
			width:475,
			height:550,
			layout:'border',
			buttons:[{
				text:'审核通过',
				handler:function(){
					var form = win.down("form");
					var checkidea = form.down("htmleditor[name=checkidea]").getValue();
					var id = form.down("textfield[name=id]").getValue();
					
					Ext.Ajax.request({
				          method:'POST',//提交的方式,如Get，post等
				          url : basepath+"platform/task/updatemaintaskapproval.do",
				          params:{
				        	  checkidea:checkidea,
				        	  status:1,
				        	  id:id
				          },
				         success:function(reps,option){
				        	 var result = Ext.JSON.decode(reps.responseText);// 就可以取出来。如果是数组，那么很简单  
				        	 if(result.code=='10000'){
				        		 Ext.Msg.alert('提示', "保存成功！！！"); 
				        		 me.getStore().load();
				        		 win.close();
				        	 }
				        },//成功的回调函数    
				        failure:function(res){
				      
				        }//失败的情况

				    });
				}
			},{
				text:'审核不通过',
				handler:function(){
					var form = win.down("form");
					var checkidea = form.down("htmleditor[name=checkidea]").getValue();
					var id = form.down("textfield[name=id]").getValue();
					
					Ext.Ajax.request({
				          method:'POST',//提交的方式,如Get，post等
				          url : basepath+"platform/task/updatemaintaskapproval.do",
				          params:{
				        	  checkidea:checkidea,
				        	  status:-1,
				        	  id:id
				          },
				         success:function(reps,option){
				        	 var result = Ext.JSON.decode(reps.responseText);// 就可以取出来。如果是数组，那么很简单  
				        	 if(result.code=='10000'){
				        		 Ext.Msg.alert('提示', "保存成功！！！"); 
				        		 me.getStore().load();
				        		 win.close();
				        	 }
				        },//成功的回调函数    
				        failure:function(res){
				      
				        }//失败的情况

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
					    url : basepath+"platform/task/updatemaintask.do",  
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