/**
 * 时间更新
 */
Ext.define("Rds.panel.RdsPlatformCheckingUpdateGrid",{
	extend:'Ext.grid.Panel',
	title:'考勤 设置',
	requires:['Rds.panel.RdsPlatformNoticeHomeGrid','Rds.ux.TreeCombo','Rds.ux.DateTimeField'],
	plugins:[  
             Ext.create('Ext.grid.plugin.CellEditing',{  
                 clicksToEdit:1 //设置单击单元格编辑  
             })  
    ],
	initComponent:function(){
		var me = this;
		
        var users = Ext.create("Ext.form.field.ComboBox",{
        	name:'userid', 
            width: 180, 
            fieldLabel: '人员', 
            labelWidth: 60, 
            emptyText: '请选择', 
            queryMode:'local',  //这个需要加上。。
            store: new Ext.data.Store({ 
                singleton : true, 
                proxy: { 
                        type: 'ajax', 
                        url : basepath+'platform/userinfos/queryplatformuserinfosbydepartment.do', 
                        actionMethods : 'post', 
                        reader: { 
                            type: 'json', 
                            totalProperty: 'ChannelCount', 
                            root: 'root' 
                        } 
                }, 
                fields:['userid', 'username','loginname']//, //不管有没有model，这个fields都必须写，而且只能写在这里，
            }), 
            loadingText:'正在加载数据，请稍侯……', 
            triggerAction:'all', 
            valueField:'userid', 
            displayField:'loginname'
        });
        
        var depts = Ext.create("Ext.form.field.ComboBox",{
        	name:'userid', 
            width: 180, 
            fieldLabel: '部门', 
            labelWidth: 60, 
            emptyText: '请选择', 
            queryMode:'local',  //这个需要加上。。
            store: new Ext.data.Store({ 
                singleton : true, 
                proxy: { 
                        type: 'ajax', 
                        url : basepath+'platform/userinfos/queryplatformalldepartments.do', 
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
            displayField:'loginname', 
            listeners:{
            	'select':function(combo, records, eOpts){
            		var record = records[0];
            		var userid = record.get("userid");
            		var store_users = users.getStore();
            		store_users.load({params:{
            			userid:userid
            		}});
            	}
            }
        });
        
        var month = Ext.create("Rds.ux.Month",{
        	name : 'month',
			labelWidth : 60,
			format : 'Y-m',
			value:new Date(),
			width : 200,
			fieldLabel : '月份'
        });
		
		me.store = Ext.create('Ext.data.Store',{
			fields:['id','userid','username','classname','total','starttime','endtime'],
			proxy: {
                type: 'ajax',
                actionMethods:{read:'POST'},
				url: basepath+'platform/checking/queryplatformcheckingtotaldetial.do',
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
	        			'userid':users.getValue(),
	        			'month':Ext.util.Format.date(month.getValue(),'Y-m')
	        		});
	        	},
	        	load:function(){
	        		me.selModel.deselectAll();
	        	}
            }
		});
		
		/*me.listeners={
			'itemdblclick':function( grid, record, item, index, e, eOpts ){
				var userid = record.get("userid");
				var mh = Ext.util.Format.date(month.getValue(),'Y-m');//record.get("month");
				if(mh==null||mh==""){
					Ext.Msg.alert('提示', "请填写月份"); 
					return;
				}
				var win = Ext.create("Ext.window.Window",{
					title:'考勤明细',
					layout:'border',
					width:900,
					height:500,
					buttons:[{
						text:'关闭',
						handler:function(){
							win.close();
						}
					}]
				});
				
				win.show();
				win.add(Ext.create("Rds.panel.RdsPlatformCheckingDetailsGrid",{
					region:'center',
					userid:userid,
					month:mh
				}));
				
			}	
		};*/

		me.store.load();
		me.columns = [{text: "人员名称",  dataIndex: 'username',width:120},
		              {text: "上班时间", dataIndex: 'starttime',width:150,
							renderer:function(v,metaData,record){ 
				    	  		record.set("starttime",Ext.util.Format.date(v, 'Y-m-d H:i:s'))
				    	  		return Ext.util.Format.date(v, 'Y-m-d H:i:s');
				    	  	},
							editor:{
						        xtype: 'datetimefield',
						        format: 'Y-m-d H:i:s',
						        anchor: '100%',
						        width:150
						    }
		              },
		              {text: "下班时间", dataIndex: 'endtime',width:150,
		            	  	renderer:function(v,metaData,record){ 
		            	  		record.set("endtime",Ext.util.Format.date(v, 'Y-m-d H:i:s'))
		            	  		return Ext.util.Format.date(v, 'Y-m-d H:i:s');
		            	  	},
							editor:{
						        xtype: 'datetimefield',
						        format: 'Y-m-d H:i:s',
						        anchor: '100%',
						        width:150
						    }
		              }];
        
        me.dockedItems = [{
			xtype : 'toolbar',
			name : 'menu',
			dock : 'top',
			items : [{
            	xtype:'button',
            	text:'保存',
            	iconCls:'Applicationformadd',
            	name:'add',
            	listeners: {
                    click:function(){
                    	var store = me.getStore();
        				var json = Ext.pluck(store.data.items, 'data')
        				Ext.Ajax.request({  
        					url:basepath+'platform/checking/updateplatformcheckingvalues.do', 
                 	       	method: "POST",
                 	       	params: { 
                 	       		list:JSON.stringify(json)
                 	       	},
                 	       	success: function (response, option) {  
  	               	    	response = Ext.JSON.decode(response.responseText);  
  	                        if (response.code == '10000') {  
  	                        	Ext.Msg.alert("提示", "更新成功");
  	                        	me.getStore().reload();
  	                        }else if(response.code == '10001') { 
  	                       	   	Ext.MessageBox.alert("错误信息", "没有更新记录!");
  	                        }
  	                        },  
  	                        failure: function () { Ext.Msg.alert("提示", "保存失败<br>没有捕获到异常"); }  
        				});
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
                items: [depts,users,month,{
					xtype : 'button',
					text:'查询',
					iconCls : 'Find',
					handler:me.onSearch
				}]
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
	
	getNoticeForm:function(){
		var storeMenu = Ext.create('Ext.data.TreeStore', {
		    root: {
		        expanded: true,
		        children: null
		    }
		});
		
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
		    margin:10,
		    labelWidth : 60,
			width : 200,
			fieldLabel : '视图范围',
		    treeWidth: 240,
		    store : store
		})
		
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
                title: '公告录入',
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
        			width : 200,
        			fieldLabel : 'id'
                },{
                	xtype:'textfield',
                	name : 'title',
        			labelWidth : 60,
        			width : 200,
        			fieldLabel : '公告标题'
                },{
                	xtype:'textfield',
                	name : 'publisher',
        			labelWidth : 60,
        			width : 200,
        			fieldLabel : '发布者'
                },{
                	xtype:'datefield',
                	name : 'publishtime',
                	value:new Date(),
        			labelWidth : 60,
        			format:'Y-m-d',
        			width : 200,
        			fieldLabel : '发布时间'
                },{
                	xtype:'datefield',
                	name : 'starttime',
//                	value:new Date(),
        			labelWidth : 60,
        			format:'Y-m-d',
        			width : 200,
        			fieldLabel : '起效时间'
                },{
                	xtype:'datefield',
                	name : 'endtime',
//                	value:new Date(),
        			labelWidth : 60,
        			format:'Y-m-d',
        			width : 200,
        			fieldLabel : '失效时间'
                },{
                	xtype:'htmleditor',
                	name : 'content',
        			labelWidth : 60,
        			width : 200,
        			height:250,
        			fieldLabel : '发布内容'
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
					    url : basepath+"platform/notice/update.do",  
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