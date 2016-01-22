Ext.define('Rds.view.ViewPart', {
	extend : 'Ext.container.Viewport',
	layout : 'border',
	require:[
	         'Rds.panel.SystemComprehensiveOffice',
	         'Rds.panel.Date',
	         'Rds.panel.RdsPlatformNoticeGrid',
	         'Rds.panel.RdsPlatformBusinessGrid',
	         'Rds.panel.RdsPlatformNavigatePanel'],
	initComponent : function() {
		var me = this;
		//me.sqe = new Map();
		me.items = [{
            xtype:'panel',
            region : 'north',
			hidden:true,
            border:false,
            height:60
        },{
        	xtype:'panel',
			region : 'west',
			stateId : 'navigation-panel',
			id : 'west-panel',
			split : true,
			width : 400,
			minWidth : 175,
			maxWidth : 400,
			items:[me.loadCalendar(),me.loadNotice(),me.loadBusiness(),me.loadNavigate()],
			layout : 'anchor'
		},Ext.create('Ext.panel.Panel', {
			region : 'center',
			deferredRender : false,
			layout:'border',
			items : [me.loadNorthTab(),me.loadSouthTab(),me.loadCenterPanel()]
		}),Ext.create('Ext.Toolbar',{
    	    region:"south",
			hidden:true,
        	height:33,
        	items:["当前用户："+'设计人员','->',"技术支持:<a href='' target='_blank' style='text-decoration:none;'><font color='#0000FF'>XXXX技术有限公司</font></a>&nbsp;&nbsp;"]
		})];

		me.listeners = {
			'render':function() {
			}
		}
		me.callParent(arguments);
	},

	loadCenterPanel:function(){
		var center = Ext.create("Ext.panel.Panel",{
			region:'center',
			layout: {
				type: 'vbox',
				align: 'middle',
				pack: 'center'
			},
			border:0,
			items:[{
				xtype: 'fieldcontainer',
				fieldLabel: '知识搜索',
				labelStyle: 'font-weight:bold;padding:0;',
				layout: {
					align: 'middle',
					pack: 'center',
					type: 'hbox'
				},
				defaultType: 'textfield',
				fieldDefaults: {
					labelAlign: 'left'
				},
				items: [{
					width:500,
					hideLabel:true,
					name:'input',
					emptyText:'请输入检索关键字',
					margins: '0 0 0 5'
				},{
					xtype:'button',
					text:'查询',
					handler:function(){
						
						var input = center.down("textfield[name=input]").getValue();
						var url = "http://www.baidu.com?input="+input;
						openDialog(url);
					}
				}]
			}]
		});
		return center;
	},

	loadSouthTab:function(){
		var northtab = Ext.create('Ext.tab.Panel', {
			region:'south',
			border:0,
			height:'45%',
			items: [Ext.create("Rds.panel.RdsPlatformWaitWorkflow",{
				title: '待办事项'
			})]
		});
		return northtab;
	},

	loadNorthTab:function(){
		var northtab = Ext.create('Ext.tab.Panel', {
			region:'north',
			height:'45%',
			border:0,
			items: []
		});
		
		if(!h_gj)
			northtab.add(Ext.create("Rds.panel.RdsPlatformAlarmGrid",{
				title: '告警信息'
			}));
		if(!h_tj)
			northtab.add(Ext.create("Rds.panel.RdsPlatformSystemComprehensiveOffice",{
				title: '数据统计'
			}));
		
//		northtab.add({
//			title: '非涉水业务系统'
//		});
		
		return northtab;
	},
	loadCalendar:function(){

		var calendar = Ext.create("Ext.panel.Panel",{
			title:'日历',
			//html: "子元素1",
			hidden:h_rl,
			border:0,
			layout:'border',
			//html:'<div class="easyui-fullCalendar" fit="true"></div>',
			items:[{
				xtype: 'container',
				region:'center',
				items: [Ext.create("Rds.panel.Date",{
					width:'100%',
					height:'100%',
					showToday:false,
					todayText:'今天',
					focusOnShow:true,
					cls: 'ext-cal-nav-picker',
					listeners: {
//						'select': {
//							fn: function(dp, dt){
//								alert("");
//							},
//							scope: this
//						},
						'focus':{
							fn: function(dp, dt){
								alert("");
							},
							scope: this
						}
					}
				})]
			}],
			anchor: '100% 40%'
		});
		return calendar;
	},
	loadNotice:function(){

		var notice = Ext.create("Rds.panel.RdsPlatformNoticeHomeGrid",{
			border:0,
			hidden:h_gg,
			anchor: '100% '+anchor_height
		});

		return notice;
	},
	loadBusiness:function(){
		
		var business = Ext.create("Rds.panel.RdsPlatformBusinessHomeGrid",{
			border:0,
			hidden:h_yw,
			anchor: '100% '+anchor_height
		});
		return business;
	},
	loadNavigate:function(){

		var navigate = Ext.create("Rds.panel.RdsPlatformNavigatePanel",{
			title:'快速导航',
			anchor: '100% 20%',
			border:0
		});
		return navigate;
	}
});

