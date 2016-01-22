/**
 * 节假日设置登记
 * composeModel
 */
Ext.define("Rds.panel.RdsPlatformComposeHolidayGrid",{
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
				url: basepath+'platform/compose/queryplatformcomposeholidays.do',
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
					var selects = me.getView().getSelectionModel().getSelection().length;
					var tbar = me.down("toolbar");
					var btn_down = tbar.down("button[name=down]");
					var btn_up = tbar.down("button[name=up]");
					
					if(selects==1){
						btn_down.setDisabled(false);
						btn_up.setDisabled(false);
					}else if(selects>1){
						btn_down.setDisabled(false);
						btn_up.setDisabled(false);
					}else if(selects<1){
						btn_down.setDisabled(true);
						btn_up.setDisabled(true);
					}
				}
			}
		});
        
        me.dockedItems = [{
			xtype : 'toolbar',
			name : 'menu',
			dock : 'top',
			items : [{
            	xtype:'button',
            	text:'设置为节假日',
            	disabled:true,
            	iconCls:'Applicationformdelete',
            	name:'down',
            	listeners: {
                    click: function(){
                    	var selections = me.getView().getSelectionModel().getSelection();
                    	var codes = '';
                    	for(var i=0;i<selections.length;i++){
                			var item = selections[i];
                			codes = codes +'\''+item.get("id")+'\'';
                			if(i!=(selections.length-1)){
                				codes = codes+",";
                			}
                		}
                		Ext.Ajax.request({  
                    	       url: basepath+"platform/compose/updatedownandup.do",  
                    	       method: "POST",
                    	       params: { 
                    	    	   "ids":codes,
                    	    	   flag:'0'
                    	       },

                    	       success: function (response, option) {  
     	               	    	response = Ext.JSON.decode(response.responseText);  
     	                        if (response.code == '10000') {  
     	                        	Ext.Msg.alert("提示", "设置成功");
     	                        	me.getStore().reload();
     	                        }else if(response.code == '10001') { 
     	                       	   Ext.MessageBox.alert("错误信息", "没有设置记录!");
     	                        } 
                    	       },  
                    	       failure: function () { Ext.Msg.alert("提示", "保存失败<br>没有捕获到异常"); }  
                      	});
                    		
                    }
                },
                scope: me
            },{
            	xtype:'button',
            	text:'设置为非节假日',
            	disabled:true,
            	iconCls:'Applicationformdelete',
            	name:'up',
            	listeners: {
                    click: function(){
                    	var selections = me.getView().getSelectionModel().getSelection();
                    	var codes = '';
                    	for(var i=0;i<selections.length;i++){
                			var item = selections[i];
                			codes = codes +'\''+item.get("id")+'\'';
                			if(i!=(selections.length-1)){
                				codes = codes+",";
                			}
                		}
                		Ext.Ajax.request({  
                    	       url: basepath+"platform/compose/updatedownandup.do",  
                    	       method: "POST",
                    	       params: { 
                    	    	   "ids":codes,
                    	    	   flag:'1'
                    	       },

                    	       success: function (response, option) {  
     	               	    	response = Ext.JSON.decode(response.responseText);  
     	                        if (response.code == '10000') {  
     	                        	Ext.Msg.alert("提示", "设置成功");
     	                        	me.getStore().reload();
     	                        }else if(response.code == '10001') { 
     	                       	   Ext.MessageBox.alert("错误信息", "没有设置记录!");
     	                        } 
                    	       },  
                    	       failure: function () { Ext.Msg.alert("提示", "保存失败<br>没有捕获到异常"); }  
                      	});
                    		
                    }
                },
                scope: me
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
	}
});