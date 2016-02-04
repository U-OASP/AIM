/***
 * 任务处理
 */
Ext.define("Rds.panel.RdsPlatformTaskHandlePanel",{
	extend:'Ext.panel.Panel',
	layout: 'border',
	name:'task',
	requires:["Rds.panel.RdsPlatformTrainFileGrid"], 
	initComponent:function(){
		var me = this;
		me.items = [Ext.create("Rds.panel.RdsPlatformTaskFeedBackGrid",{
			region:'center',
			title:'反馈信息',
			ischeck:true
		}),Ext.create("Rds.panel.RdsPlatformTaskHandleGrid",{
			region:'north',
			title:'任务列表',
			height:300,
			ischeck:true
		})];
		me.callParent(arguments);
	}
	
});