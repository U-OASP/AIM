/***
 * 培训管理
 */
Ext.define("Rds.panel.RdsPlatformTrainPanel",{
	extend:'Ext.panel.Panel',
	layout: 'border',
	requires:["Rds.panel.RdsPlatformTrainFileGrid"], 
	initComponent:function(){
		var me = this;
		me.items = [Ext.create("Rds.panel.RdsPlatformTrainGrid",{
			region:'center'
		}),Ext.create("Rds.panel.RdsPlatformTrainFileGrid",{
			region:'east',
			title:'附件列表',
			width:300
		})];
		me.callParent(arguments);
	}
	
});