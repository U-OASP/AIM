/***
 * 任务管理
 */
Ext.define("Rds.panel.RdsPlatformTaskPanel",{
	extend:'Ext.panel.Panel',
	layout: 'border',
	name:'task',
	requires:["Rds.panel.RdsPlatformTrainFileGrid"], 
	initComponent:function(){
		var me = this;
		me.items = [Ext.create("Rds.panel.RdsPlatformTaskSubGrid",{
			region:'center',
			ischeck:true
		}),Ext.create("Rds.panel.RdsPlatformTaskFeedBackDetailsPanel",{
			region:'east',
			title:'反馈详细',
			width:300
		}),Ext.create("Rds.panel.RdsPlatformTaskMainGrid",{
			region:'north',
			height:300,
			ischeck:true
		})];
		me.callParent(arguments);
	}
	
});