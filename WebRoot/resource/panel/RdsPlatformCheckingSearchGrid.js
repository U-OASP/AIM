/**
 * 考勤统计
 */
Ext.define("Rds.panel.RdsPlatformCheckingSearchGrid",{
	extend:'Ext.grid.Panel',
	title:'公告',
	requires:['Rds.panel.RdsPlatformNoticeHomeGrid','Rds.ux.TreeCombo'],
	initComponent:function(){
		var me = this;
		
        var users = Ext.create("Ext.form.field.ComboBox",{
        	name:'userid', 
//            value:'310', 
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
//                autoLoad:true 

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
		              {text: "班次", dataIndex: 'classname',width:100},
		              {text: "上班时间", dataIndex: 'starttime',width:150},
		              {text: "下班时间", dataIndex: 'endtime',width:150}];
        
        me.dockedItems = [{
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
	}
});