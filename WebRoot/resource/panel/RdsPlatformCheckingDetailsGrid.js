/**
 * 考勤统计明细
 */
Ext.define("Rds.panel.RdsPlatformCheckingDetailsGrid",{
	extend:'Ext.grid.Panel',
//	title:'考勤明细',
	config:{
		userid:null,
		month:null
	},
	requires:['Rds.panel.RdsPlatformNoticeHomeGrid','Rds.ux.TreeCombo'],
	initComponent:function(){
		var me = this;
		
		me.store = Ext.create('Ext.data.Store',{
			fields:['userid','username','classname','total','starttime','endtime'],
			proxy: {
                type: 'ajax',
                actionMethods:{read:'POST'},
				url: basepath+'platform/checking/queryplatformcheckingtotaldetial.do',
                params:{
                	userid:me.userid,
                	month:me.month
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
	        			userid:me.userid,
	                	month:me.month
	        		});
	        	}
            }
		});
		
		me.store.load();
        me.columns = [
                        {text: "人员名称",  dataIndex: 'username',width:120},
	      				{text: "班次", dataIndex: 'classname',width:100},
	      				{text: "签到时间", dataIndex: 'starttime',width:150},
	      				{text: "签退时间", dataIndex: 'endtime',width:150}];
        
		me.callParent(arguments);
	}
});