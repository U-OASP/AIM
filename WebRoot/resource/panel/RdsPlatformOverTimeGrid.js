/**
 * 加班管理
 */
Ext.define("Rds.panel.RdsPlatformOverTimeGrid",{
	extend:'Ext.grid.Panel',
	title:'外出登记',
	requires:['Rds.ux.DateTimeField'],
	initComponent:function(){
		var me = this;
        var otdsc = Ext.create("Ext.form.field.Text",{
        	name : 'otdsc',
			labelWidth : 60,
			width : 200,
			fieldLabel : '计划说明'
        });
        
        var applytime = Ext.create("Ext.form.field.Date",{
        	name : 'applytime',
			labelWidth : 60,
			width : 200,
			format:'Y-m-d',
			fieldLabel : '申请时间'
        }); 
        
		me.store = Ext.create('Ext.data.Store',{
			fields:['id','applyer','otdsc','otstarttime','otendtime','predictendtime','applytime','status','checktime','checkidea'],
			proxy: {
                type: 'ajax',
                actionMethods:{read:'POST'},
				url: basepath+'platform/overtime/queryplatformovertimespage.do',
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
	        			'otdsc':otdsc.getValue(),
	        			'applytime':Ext.util.Format.date(applytime.getValue(),'Y-m-d')
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
                      {text: "申请人", dataIndex: 'applyer',width:80},
                      {text: "计划说明", dataIndex: 'otdsc',width:200},
	      			  {text: "起始时间", dataIndex: 'otstarttime',width:120},
                      {text: "预计结束时间",  dataIndex: 'predictendtime',width:120},
                      {text: "实际结束时间",  dataIndex: 'otendtime',width:120},
                      {text: "申请时间",  dataIndex: 'applytime',width:80},
                      {text: "审核时间",  dataIndex: 'checktime',width:120},
                      {text: "审批意见",  dataIndex: 'checkidea',width:200},
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
                      }];
        me.selModel = Ext.create('Ext.selection.CheckboxModel',{
			listeners:{
				'selectionchange':function( model, record, index, eOpts ){
					var selects = me.getView().getSelectionModel().getSelection().length;
					var tbar = me.down("toolbar");
					
					var btn_edit = tbar.down("button[name=edit]");
					var btn_delete = tbar.down("button[name=delete]");
					var btn_sure = tbar.down("button[name=sure]");
					
					if(selects==1){
						btn_edit.setDisabled(false);
						btn_delete.setDisabled(false);
						btn_sure.setDisabled(false);
					}else if(selects>1){
						btn_edit.setDisabled(true);
						btn_delete.setDisabled(false);
						btn_sure.setDisabled(true);
					}else if(selects<1){
						btn_edit.setDisabled(true);
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
                		form.down("htmleditor[name=otdsc]").setValue(record.get("otdsc"));
                		
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
                    	       url: basepath+"platform/overtime/delete.do",  
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
            	text:'确认时间',
            	disabled:true,
            	iconCls:'Applicationformdelete',
            	name:'sure',
            	listeners: {
                    click: function(){
                    	var selections = me.getView().getSelectionModel().getSelection();
                    	var record = selections[0];
                    	
                    	if(record.get("otendtime")!=null||record.get("otendtime")!=""){
                    		Ext.Msg.alert('提示', "时间确认,不能再次修改!"); 
                    		return;
                    	}
                    	
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
                            	xtype:'textfield',
                            	name : 'id',
                            	labelWidth : 80,
//                    			hidden:true,
                    			readOnly:true,
                    			width : 200,
                    			value:record.get("id"),
                    			fieldLabel : 'id'
                            },{
                            	xtype:'datetimefield',
                            	name : 'otendtime',
                            	value:new Date(),
                    			labelWidth : 80,
                    			format: 'Y-m-d H:i:s',
                    			width : 200,
                    			fieldLabel : '起始时间'
                            }]
                		});
                    	
                    	var win = Ext.create("Ext.window.Window",{
                			title:'确认时间',
                			width:400,
                			height:170,
                			layout:'border',
                			buttons:[{
                				text:'保存',
                				handler:function(){
                					var form = win.down("form");
                					form.submit({  
                					    url : basepath+"platform/overtime/updateendtime.do",  
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
                    	win.add(form);
                    	win.show();
//                    	Ext.create("Ext.form.field.Text",{
//                    		name : 'otendtime',
//                			labelWidth : 60,
//                			width : 200,
//                			fieldLabel : '计划说明
//                    	});
                    	/*
                		Ext.Ajax.request({  
                    	       url: basepath+"platform/overtime/delete.do",  
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
                      	});*/
                    		
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
                items: [otdsc,applytime,{
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
                	labelWidth : 80,
        			hidden:true,
        			readOnly:true,
        			width : 200,
        			labelAlign:'right',
        			fieldLabel : 'id'
                },{
                	xtype:'htmleditor',
                	name : 'otdsc',
                	allowBlank:false,
        			labelWidth : 80,
        			width : 200,
        			height:150,
        			labelAlign:'right',
        			fieldLabel : '计划说明'
                },{
                	xtype:'datetimefield',
                	name : 'otstarttime',
                	value:new Date(),
        			labelWidth : 80,
        			allowBlank:false,
        			format: 'Y-m-d H:i:s',
        			width : 200,
        			labelAlign:'right',
        			fieldLabel : '起始时间'
                },{
                	xtype:'datetimefield',
                	name : 'predictendtime',
                	value:new Date(),
        			labelWidth : 80,
        			allowBlank:false,
        			labelAlign:'right',
        			format: 'Y-m-d H:i:s',
        			width : 200,
        			fieldLabel : '预计结束时间'
                },{
                	xtype:'textfield',
                	name : 'applyer',
        			labelWidth : 80,
        			width : 200,
        			hidden:true,
        			allowBlank:false,
        			labelAlign:'right',
        			value:username,
        			fieldLabel : '登记人员'
                },{
                	xtype:'textfield',
                	name : 'status',
        			labelWidth : 80,
        			width : 200,
        			allowBlank:false,
        			hidden:true,
        			labelAlign:'right',
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
			width:550,
			height:380,
			layout:'border',
			buttons:[{
				text:'保存',
				handler:function(){
					var form = win.down("form");
					form.submit({  
					    url : basepath+"platform/overtime/update.do",  
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