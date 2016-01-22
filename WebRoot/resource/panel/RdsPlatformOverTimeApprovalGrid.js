/**
 * 加班审批
 */
Ext.define("Rds.panel.RdsPlatformOverTimeApprovalGrid",{
	extend:'Ext.grid.Panel',
	title:'入驻登记',
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
			fields:['id','applyer','otdsc','otstarttime','otendtime','predictendtime','applytime','issure','status','checktime','checkidea'],
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
                        }];
        me.selModel = Ext.create('Ext.selection.CheckboxModel',{
			listeners:{
				'selectionchange':function( model, record, index, eOpts ){
					var selects = me.getView().getSelectionModel().getSelection().length;
					var tbar = me.down("toolbar");
					
					var btn_edit = tbar.down("button[name=edit]");
					var btn_sure = tbar.down("button[name=sure]");
					
					if(selects==1){
						btn_edit.setDisabled(false);
						btn_sure.setDisabled(false);
					}else if(selects>1){
						btn_edit.setDisabled(true);
						btn_sure.setDisabled(false);
					}else if(selects<1){
						btn_edit.setDisabled(true);
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
            	text:'审批',
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
                		window.setTitle("审批");
                		form.down("htmleditor[name=otdsc]").setValue(record.get("otdsc"));
                		
                    }
                },
                scope: me
            },{
            	xtype:'button',
            	text:'确认',
            	iconCls:'Applicationformedit',
            	disabled:true,
            	name:'sure',
            	listeners: {
                    click: function(){
                    	var selections = me.getView().getSelectionModel().getSelection();
                    	var record = selections[0];
                    	
                    	var form = me.getNoticeForm();
                    	var win = Ext.create("Ext.window.Window",{
                			title:'确认',
                			width:800,
                			height:500,
                			layout:'border',
                			buttons:[{
                				text:'确认',
                				handler:function(){
                					Ext.Ajax.request({
              				          method:'POST',//提交的方式,如Get，post等
              				          url : basepath+"platform/overtime/updatesure.do",
              				          params:{
              				        	  issure:1,
              				        	  id:record.get("id")
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
                    	win.add(form);
                    	win.show();
                    	form.down("htmleditor[name=otdsc]").setValue(record.get("otdsc"));
                    	form.down("htmleditor[name=checkidea]").setValue(record.get("checkidea"));
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
        			labelWidth : 80,
        			readOnly:true,
        			width : 200,
        			height:150,
        			labelAlign:'right',
        			fieldLabel : '计划说明'
                },{
                	xtype:'datetimefield',
                	name : 'otstarttime',
                	value:new Date(),
        			labelWidth : 80,
        			readOnly:true,
        			labelAlign:'right',
        			format: 'Y-m-d H:i:s',
        			width : 200,
        			fieldLabel : '起始时间'
                },{
                	xtype:'datetimefield',
                	name : 'predictendtime',
                	value:new Date(),
                	readOnly:true,
                	labelAlign:'right',
        			labelWidth : 80,
        			format: 'Y-m-d H:i:s',
        			width : 200,
        			fieldLabel : '预计结束时间'
                },{
                	xtype:'textfield',
                	name : 'applyer',
        			labelWidth : 80,
        			readOnly:true,
        			labelAlign:'right',
        			width : 200,
        			hidden:true,
        			value:username,
        			fieldLabel : '登记人员'
                },{
                	xtype:'textfield',
                	name : 'status',
        			labelWidth : 80,
        			readOnly:true,
        			width : 200,
        			hidden:true,
        			value:'1',
        			fieldLabel : '状态'
                },{
                	xtype:'htmleditor',
                	name : 'checkidea',
        			labelWidth : 80,
        			labelAlign:'right',
        			width : 200,
        			height:250,
        			fieldLabel : '审核意见'
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
				text:'审核通过',
				handler:function(){
					var form = win.down("form");
					var checkidea = form.down("htmleditor[name=checkidea]").getValue();
					var id = form.down("textfield[name=id]").getValue();
					
					Ext.Ajax.request({
				          method:'POST',//提交的方式,如Get，post等
				          url : basepath+"platform/overtime/updateapproval.do",
				          params:{
				        	  checkidea:checkidea,
				        	  status:2,
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
				          url : basepath+"platform/overtime/updateapproval.do",
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
	}
});