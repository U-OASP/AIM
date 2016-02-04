/**
 * 节假日设置登记
 * composeModel
 */
Ext.define("Rds.panel.RdsPlatformComposeGrid",{
	extend:'Ext.grid.Panel',
	title:'外出登记',
	requires:['Rds.ux.DateTimeField'],
	initComponent:function(){
		var me = this;
        
        var startday = Ext.create("Ext.form.field.Date",{
        	name : 'startday',
			labelWidth : 60,
			format : 'Y-m-d',
//			value:new Date(),
			width : 200,
			fieldLabel : '起始时间'
        });
        var endday = Ext.create("Ext.form.field.Date",{
        	name : 'endday',
			labelWidth : 60,
			format : 'Y-m-d',
//			value:new Date(),
			width : 200,
			fieldLabel : '结束时间'
        });
        
        var lot = Ext.create("Ext.form.field.Number",{
        	name : 'lot',
			labelWidth : 60,
			width : 200,
			value:0,
			fieldLabel : '执行几批'
        });
		
		me.store = Ext.create('Ext.data.Store',{
			fields:['day','morning','night','week_day','flag'],
			proxy: {
                type: 'ajax',
                actionMethods:{read:'POST'},
				url: basepath+'platform/compose/queryplatformcomposespage.do',
                params:{
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
	        			'startday':Ext.util.Format.date(startday.getValue(),'Y-m-d'),
	        			'endday':Ext.util.Format.date(endday.getValue(),'Y-m-d')
	        		});
	        	},
	        	load:function(){
	        		me.selModel.deselectAll();
	        	}
            }
		});
		
		me.listeners={
			'itemdblclick':function( grid, record, item, index, e, eOpts ){
//				Rds.panel.RdsPlatformNoticeHomeGrid.showDetails(record).show();
			}	
		};

		me.store.load();
        me.columns = [
                      Ext.create("Ext.grid.RowNumberer",{text: '序号',width:39,align:'center'}),
                      {text: "日期 ", dataIndex: 'day',width:200},
                      {text: "上午值班人员", dataIndex: 'morning',width:100},
	      			  {text: "下午值班人员", dataIndex: 'night',width:100},
	      			  {text: "周几", dataIndex: 'week_day',width:100},
                      {text: "节假日",  dataIndex: 'flag',width:160,
                      	renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
                      		var result = "";
                      		if(value=='1'){
                      			result = "非节假日";
                      		}else if(value==0){
                      			result = "节假日";
                      		}
                      		return result;
                      	}
                      }];
        me.selModel = Ext.create('Ext.selection.CheckboxModel',{
			listeners:{
				'selectionchange':function( model, record, index, eOpts ){
				}
			}
		});
        
        me.dockedItems = [{
			xtype : 'toolbar',
			name : 'menu',
			dock : 'top',
			items : [{  
                xtype: 'buttongroup',  
                columns: 6,   
                floatable:true,  
                defaults: {  
                    scale: 'small'  
                },  
                items: [lot,{
					xtype : 'button',
					text:'初始化',
					iconCls : 'Find',
					handler:me.onInit
				}]
			}]
		},{
			xtype : 'toolbar',
			name : 'search',
			dock : 'top',
			items : [{  
                xtype: 'buttongroup',  
                columns: 6,   
                floatable:true,  
                defaults: {  
                    scale: 'small'  
                },  
                items: [startday,endday,{
					xtype : 'button',
					text:'查询',
					iconCls : 'Find',
					handler:me.onSearch
				}]
			}]
		}];
        
        me.bbar = new Ext.PagingToolbar({
			pageSize : 25,  // 一页显示25行
			store : me.store,  // 前面定义的store
       	 	displayInfo : true, // 是否显示总体信息
       	 	displayMsg : "第 {0} - {1} 条  共 {2} 条",
       	 	emptyMsg : "没有符合条件的记录"
		});
		me.callParent(arguments);
	},
	
	onSearch:function(){
		var me = this.up("gridpanel");
		me.getStore().currentPage = 1;
		var store = me.getStore();
    	store.reload();
	},
	onInit:function(){
		var toolbar = this.up("toolbar");
		var lot = toolbar.down("numberfield[name=lot]");
		var me = this.up("gridpanel");
		Ext.Ajax.request({  
 	       url: basepath+"platform/compose/init.do",  
 	       method: "POST",
 	       params: { 
 	    	   "lot":lot.getValue()
 	       },
 	       success: function (response, option) {  
 	    	   response = Ext.JSON.decode(response.responseText);  
 	    	   if (response.code == '10000') {  
 	    		   Ext.Msg.alert("提示", "初始化成功!");
 	    		   me.getStore().currentPage = 1;
 	    		   var store = me.getStore();
 	    		   store.reload();
 	    	   }else if(response.code == '10001') { 
 	    		   Ext.MessageBox.alert("初始化失败",response.msg );
 	    	   } 
 	       },  
 	       failure: function () { 
 	    	   Ext.Msg.alert("提示", "保存失败<br>没有捕获到异常"); 
 	       }  
		});
	}
});