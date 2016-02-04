/***
 * 任务审批
 */
Ext.define("Rds.panel.RdsPlatformTaskCheckPanel",{
	extend:'Ext.panel.Panel',
	layout: 'border',
	name:'task',
	requires:["Rds.panel.RdsPlatformTrainFileGrid"], 
	initComponent:function(){
		var me = this;
		me.items = [Ext.create("Rds.panel.RdsPlatformTaskSubGrid",{
			region:'center',
			ischeck:false
		}),/*Ext.create("Rds.panel.RdsPlatformTaskDetailsPanel",{
			region:'east',
			title:'详细信息',
			width:300
		}),*/Ext.create("Rds.panel.RdsPlatformTaskMainGrid",{
			region:'north',
//			title:'附件列表',
			height:300,
			ischeck:false
		})];
		me.callParent(arguments);
	}
	
});