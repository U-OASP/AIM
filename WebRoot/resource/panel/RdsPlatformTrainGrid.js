/**
 * 培训管理
 */
Ext.define("Rds.panel.RdsPlatformTrainGrid",{
	extend:'Ext.grid.Panel',
	title:'培训管理',
	initComponent:function(){
		var me = this;
        var ttitle = Ext.create("Ext.form.field.Text",{
        	name : 'ttitle',
			labelWidth : 60,
			width : 200,
			fieldLabel : '培训标题'
        });
        
        var tcontent = Ext.create("Ext.form.field.Text",{
        	name : 'tcontent',
			labelWidth : 60,
			width : 200,
			fieldLabel : '培训内容'
        }); 
        
        var tdate = Ext.create("Ext.form.field.Date",{
        	name : 'tdate',
			labelWidth : 60,
			format : 'Y-m-d',
			value:new Date(),
			width : 200,
			fieldLabel : '培训时间'
        }); 
		
		me.store = Ext.create('Ext.data.Store',{
			fields:['tid','ttitle','tcontent','tuser','tdate'],
			proxy: {
                type: 'ajax',
                actionMethods:{read:'POST'},
				url: basepath+'platform/train/queryplatformtrainspage.do',
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
	        			'ttitle':ttitle.getValue(),
	        			'tcontent':tcontent.getValue(),
	        			'tdate':Ext.util.Format.date(tdate.getValue(),'Y-m-d')
	        		});
	        	},
	        	load:function(){
	        		me.selModel.deselectAll();
	        	}
            }
		});
		
		me.listeners={
			'itemclick':function( grid, record, item, index, e, eOpts ){
				var tid = record.get("tid");
				var grid = me.up("panel").down("gridpanel[region=east]");
				var store = grid.getStore();
				grid.tid = tid;
				store.load();
			}	
		};
		
		me.store.load();
        me.columns = [
                      Ext.create("Ext.grid.RowNumberer",{text: '序号',width:39,align:'center'}),
                        {text: "培训时间",  dataIndex: 'tdate',width:120},
	      				{text: "培训标题", dataIndex: 'ttitle',width:200},
                        {text: "培训资料提交人",  dataIndex: 'tuser',width:120},
	      				{text: "培训内容", dataIndex: 'tcontent',width:200}];
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
            	iconCls:'Applicationformadd',
            	name:'add',
            	listeners: {
                    click:function(){
                		var me = this.up("gridpanel");
                		var form = me.getTrainForm();
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
                		var form = me.getTrainForm();
                		var window = me.getWindow();
                		var record = selects[0];
                		form.loadRecord(record);
                		window.add(form);
                		window.show();
                		window.setTitle("修改公告");
                		form.down("htmleditor[name=tcontent]").setValue(record.get("tcontent"));
                		
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
                                allowBlank:false,
                                labelAlign:'right',
//                                msgTarget: 'side',  
                                allowBlank: false,  
                                anchor: '80%',  
                                buttonText: '选择'  
                            },{
                            	xtype: 'textfield',
                            	name : 'filename',
                    			labelWidth : 60,
                    			width : 200,
                    			anchor: '80%', 
                    			labelAlign:'right',
                    			allowBlank:false,
                    			fieldLabel : '文件名'
                            },{
                            	xtype: 'textfield',
                            	name : 'tid',
                    			labelWidth : 60,
                    			value:record.get("tid"),
                    			width : 200,
                    			allowBlank:false,
                    			anchor: '80%', 
                    			labelAlign:'right',
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
                items: [ttitle,tcontent,tdate,{
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
                title: '培训管理',
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
                	name : 'tid',
        			labelWidth : 80,
        			hidden:true,
        			readOnly:true,
        			width : 200,
        			labelAlign:'right',
        			fieldLabel : 'tid'
                },{
                	xtype:'textfield',
                	name : 'ttitle',
        			labelWidth : 80,
        			labelAlign:'right',
        			allowBlank:false,
        			width : 200,
        			fieldLabel : '培训标题'
                },{
                	xtype:'datefield',
                	name : 'tdate',
                	value:new Date(),
        			labelWidth : 80,
        			labelAlign:'right',
        			allowBlank:false,
        			format:'Y-m-d',
        			width : 200,
        			fieldLabel : '培训时间'
                },{
                	xtype:'textfield',
                	name : 'tuser',
        			labelWidth : 80,
        			labelAlign:'right',
        			allowBlank:false,
        			width : 200,
        			fieldLabel : '培训参加人员'
                },{
                	xtype:'htmleditor',
                	name : 'tcontent',
        			labelWidth : 80,
        			width : 200,
        			allowBlank:false,
        			labelAlign:'right',
        			height:250,
        			fieldLabel : '培训内容'
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
					    url : basepath+"platform/train/update.do",  
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