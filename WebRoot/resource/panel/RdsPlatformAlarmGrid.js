Ext.define("Rds.panel.RdsPlatformAlarmGrid",{
	extend:'Ext.grid.Panel',
	pageSize:25,
	initComponent:function(){
		var me = this;
		var interval = new QualityInterval(me);
		interval.interval();
		
		me.store = Ext.create('Ext.data.Store',{
			fields:['alarmId','alarmTrackId','occurTime','severity','message','source','alarmType','moId','additionalInfo','mo'],
			pageSize:me.pageSize,
			proxy: {
                type: 'ajax',
                actionMethods:{read:'POST'},
				url: basepath+'platform/alarm/queryplatformalarmpage.do',
                params:{
                },
                reader: {
                    type: 'json',
                    root:'data',
                    totalProperty:'total'
                }
            }
		});

		me.store.load();
        me.columns = [
                      Ext.create("Ext.grid.RowNumberer",{text: '序号',width:39,align:'center'}),
                      { text: '告警内容', dataIndex: 'message',width:300},
                      { text: '严重级别', dataIndex: 'severity',width:100},
                      { text: '告警类型', dataIndex: 'alarmType',width:100},
                      { text: '发生时间', dataIndex: 'occurTime',width:160},
                      //{ text: 'MOID', dataIndex: 'moId',width:150},
                      { text: '设备IP', dataIndex: 'additionalInfo',width:150}];
        
        me.bbar = new Ext.PagingToolbar({
			pageSize : me.pageSize,  // 一页显示25行
			store : me.store,  // 前面定义的store
       	 	displayInfo : true, // 是否显示总体信息
       	 	displayMsg : "第 {0} - {1} 条  共 {2} 条",
       	 	emptyMsg : "没有符合条件的记录"
		});
		me.callParent(arguments);
	}
});