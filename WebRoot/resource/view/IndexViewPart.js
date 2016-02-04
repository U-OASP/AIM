Ext.define('Rds.view.IndexViewPart', {
	extend : 'Ext.container.Viewport',
	layout : 'border',
	require:[],
	initComponent : function() {
		var me = this;
		
		me.items = [{
            xtype:'panel',
            region : 'north',
			hidden:true,
            border:false,
            height:60
        },{
        	xtype:'panel',
			region : 'west',
			id : 'west-panel',
//			title : "功能菜单",
//			autoScroll:true,   
//			iconCls : "Applicationviewtile",
			split : true,
			width : 230,
			minWidth : 175,
			maxWidth : 400,
			items:[],
			layout : 'anchor'
		},Ext.create('Ext.panel.Panel', {
			region : 'center',
			deferredRender : false,
			layout:'border',
			items : [me.loadCenterTab()]
		}),Ext.create('Ext.Toolbar',{
    	    region:"south",
			hidden:true,
        	height:33,
        	items:["当前用户："+'设计人员','->',"技术支持:<a href='' target='_blank' style='text-decoration:none;'><font color='#0000FF'>XXXX技术有限公司</font></a>&nbsp;&nbsp;"]
		})];

		me.loadPermitRoot();
		me.callParent(arguments);
	},

	
	loadCenterTab:function(){
		var centertab = Ext.create('Ext.tab.Panel', {
			region:'center',
			border:0,
			items: []
		});
		return centertab;
	},
	
	/**
	 *	菜单根功能
	 */
	loadPermitRoot:function(){
		var me = this;
		Ext.Ajax.request({
			url : basepath+"platform/permit/querypermits.do", //获取树节点的地址
	        method: "POST",
//	        headers: { 'Content-Type': 'application/json' },
	        params: { 
	        	userid:"",
	        	parentid:'0',
	        	menuid:menuid
	        },
	        success: function(response){
	            var result = Ext.decode(response.responseText); 
	            var west = me.down("panel[region=west]")
	            Ext.each(result,function(item){
	            	west.add(Ext.create("Ext.tree.Panel", {
						title : item.text,
						iconCls : item.iconCls,
						enableDD: true,
						border:false,
						useArrows: true,
			            animate: true,
						autoScroll : true,
						rootVisible : false,
						viewConfig : {
							loadingText : "正在加载..."
						},
						store : Ext.create("Ext.data.TreeStore",{
							fields:['id','text','type','leaf','url','iconCls','js'],
							proxy : {
								type: 'ajax', //获取方式
								url : basepath+"platform/permit/querypermits.do", //获取树节点的地址
								params:{
									userid:"",
				                	parentid:item.id
				                }
							},
							clearOnLoad : true
						}),
						listeners : {
			                beforeload : function(store, operation) { 
			                	var id = operation.node.internalId;
			                    var new_params = {//参数  
			                    		parentid : id=="root"?item.id:id
			                    };  
			                    Ext.apply(store.proxy.extraParams, new_params);  
			                },
							itemClick:function(tree,record){
								var leaf = record.get("leaf");
								var url = record.get("url");
								var text = record.get("text");
								var type = record.get("type");
								if(leaf){
									var tabs = me.down("tabpanel[region=center]");
									var tab = null;
									
									if(type=="jsp"){
										url = (url==null?"":url);
										if(url.indexOf("?")>-1){
											url = itsm + url + "&"+ queryString;
										}else{
											url = itsm + url +"?"+ queryString;
										}
									}								
									//tabs中是否存在 存在就
									for ( var i = 0; i < tabs.items.getCount(); i++) {
										var item = tabs.items.get(i);
											if (item.getId() == url) {
												tab = item;
										}
									}
									//如果不存在添加一个tab
									if(tab==null){
										var close=true;
										if(type=="js"){
											try{
												var panel = Ext.create(url,{
													id:url,
													title:text,
													closable:close
												});
												tab = tabs.add(panel);
												//显示tab
												tab.show();
											}catch(e){
												console.log(e);
											}
											
										}else if(type=="jsp"){
											try{
												var panel = Ext.create("Ext.panel.Panel",{
													id:url,
													title:text,
													html:"<iframe src=\""+url+"\" id=\"iframepage\" frameborder=\"0\" width=\"100%\"height='100%' marginheight=\"0\" marginwidth=\"0\" onLoad=\"iFrameHeight()\"></iframe>",
													closable:close
												});
												tab = tabs.add(panel);
												//显示tab
												tab.show();
											}catch(e){
												console.log(e);
											}
											
										}
									}else{
										tab.show();
									}
									
								}
								
							}
						}
					}));
	            });
	       },failure:function(response){
	           var json=Ext.decode(response.responseText);   
	       }
		});
	}
});

