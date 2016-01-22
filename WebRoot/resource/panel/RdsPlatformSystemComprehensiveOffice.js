Ext.define("Rds.panel.RdsPlatformSystemComprehensiveOffice",{
	extend:'Ext.grid.Panel',
	page:25,
	initComponent:function(){
		var me = this;
		
		var interval = new QualityInterval(me);
		interval.interval();
		
		me.store = Ext.create('Ext.data.Store',{
			fields:['id','provider','name','type','healthdegree','action'],
			pageSize : me.page,
			proxy: {
                type: 'ajax',
                actionMethods:{read:'POST'},
				url: basepath+'platform/prompt/queryplatformpromptioispage.do',
                params:{
                },
                reader: {
                    type: 'json',
                    root:'data',
                    totalProperty:'total'
                }
            }
		});

		
        me.columns = [
                      Ext.create("Ext.grid.RowNumberer",{text: '序号',width:39,align:'center'}),
                      { text: '名称', dataIndex: 'name',width:250},
                      { text: '类别', dataIndex: 'type',width:200},
                      { text: '供应商', dataIndex: 'provider',width:230},
                      { text: '健康度', dataIndex: 'healthdegree',width:200}];
        me.bbar = new Ext.PagingToolbar({
			pageSize : me.page,  // 一页显示25行
			store : me.store,  // 前面定义的store
       	 	displayInfo : true, // 是否显示总体信息
       	 	displayMsg : "第 {0} - {1} 条  共 {2} 条",
       	 	emptyMsg : "没有符合条件的记录"
		});
        
        me.store.load();

		me.callParent(arguments);
	}
});