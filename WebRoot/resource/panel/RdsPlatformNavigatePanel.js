Ext.define("Rds.panel.RdsPlatformNavigatePanel",{
	extend:'Ext.panel.Panel',
	title:'快速导航',
	layout: {
		type: 'hbox',
		align: 'middle',
		pack: 'center'
	},
	border:0,
	anchor: '100% 20%',
	
	initComponent:function(){
		var me = this;
		me.callParent(arguments);
		
		Ext.each(navs,function(item){
			me.add(Ext.create('Ext.Img', {
				padding:item.padding,
				title:item.title,
				src:item.src,
				listeners: {
					click: {
						element: 'el',
						fn: item.callback
					}
				}

			}));
		});
	}
	
});