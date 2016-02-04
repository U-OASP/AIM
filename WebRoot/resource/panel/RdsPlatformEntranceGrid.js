/**
 * 除入场管理
 */
Ext.define("Rds.panel.RdsPlatformEntranceGrid",{
	extend:'Ext.grid.Panel',
	title:'公告',
	requires:[],
	initComponent:function(){
		var me = this;
        var username = Ext.create("Ext.form.field.Text",{
        	name : 'username',
			labelWidth : 60,
			width : 200,
			fieldLabel : '入场人'
        });
        
        var card = Ext.create("Ext.form.field.Text",{
        	name : 'card',
			labelWidth : 60,
			width : 200,
			fieldLabel : '身份证号'
        }); 
        
        var entrancetime = Ext.create("Ext.form.field.Date",{
        	name : 'entrancetime',
			labelWidth : 60,
			format : 'Y-m-d',
//			value:new Date(),
			width : 200,
			fieldLabel : '入场时间'
        }); 
        
        var departuretime = Ext.create("Ext.form.field.Date",{
        	name : 'departuretime',
			labelWidth : 60,
			format : 'Y-m-d',
//			value:new Date(),
			width : 200,
			fieldLabel : '离场时间'
        }); 
		
		me.store = Ext.create('Ext.data.Store',{
			fields:['id','settledid','settledtitle','settledtilte','username','entrancetime','seatid','seatname','mark','account','status','departuretime','sex','card'],
			proxy: {
                type: 'ajax',
                actionMethods:{read:'POST'},
				url: basepath+'platform/entrance/queryplatformentrancespage.do',
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
	        			'card':card.getValue(),
	        			'username':username.getValue(),
	        			'entrancetime':Ext.util.Format.date(entrancetime.getValue(),'Y-m-d'),
	        			'departuretime':Ext.util.Format.date(departuretime.getValue(),'Y-m-d')
	        		});
	        	},
	        	load:function(){
	        		me.selModel.deselectAll();
	        	}
            }
		});
		
		me.listeners={
			'itemdblclick':function( grid, record, item, index, e, eOpts ){
				Rds.panel.RdsPlatformNoticeHomeGrid.showDetails(record).show();
			}	
		};

		me.store.load();
        me.columns = [
                      Ext.create("Ext.grid.RowNumberer",{text: '序号',width:39,align:'center'}),
                        {text: "入场人",  dataIndex: 'username',width:120},
                        {text: "申请单", dataIndex: 'settledtilte',width:150},
                        {text: "性别",  dataIndex: 'sex',width:40},
                        {text: "身份证",  dataIndex: 'card',width:150},
	      				{text: "入场时间", dataIndex: 'entrancetime',width:150},
                        {text: "座位号",  dataIndex: 'seatname',width:120},
                        {text: "离场时间",  dataIndex: 'departuretime',width:120},
                        {text: "状态",  dataIndex: 'status',width:160,
                        	renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
                        		var result = "";
                        		if(value=='0'){
                        			result = "已入场";
                        		}else if(value==1){
                        			result = "已离场";
                        		}
                        		return result;
                        	}
                        },
                        {text: "描述",  dataIndex: 'mark',width:300}];
        me.selModel = Ext.create('Ext.selection.CheckboxModel',{
			listeners:{
				'selectionchange':function( model, record, index, eOpts ){
					var selects = me.getView().getSelectionModel().getSelection().length;
					var tbar = me.down("toolbar");
					
					var btn_edit = tbar.down("button[name=edit]");
					var btn_delete = tbar.down("button[name=delete]");
					var btn_out = tbar.down("button[name=out]");
					
					if(selects==1){
						btn_edit.setDisabled(false);
						btn_delete.setDisabled(false);
						btn_out.setDisabled(false);
					}else if(selects>1){
						btn_edit.setDisabled(true);
						btn_delete.setDisabled(false);
						btn_out.setDisabled(false);
					}else if(selects<1){
						btn_edit.setDisabled(true);
						btn_delete.setDisabled(true);
						btn_out.setDisabled(true);
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
            	text:'添加',
            	iconCls:'Applicationformadd',
            	name:'add',
            	listeners: {
                    click:function(){
                		var me = this.up("gridpanel");
                		var form = me.getNoticeForm();
                		var window = me.getWindow();
                		window.add(form);
                		window.show();
                		window.setTitle("入场管理");
                    }
                },
                scope: me
            },{
            	xtype:'button',
            	text:'修改',
            	iconCls:'Applicationformedit',
            	disabled:true,
            	name:'edit',
            	listeners: {
                    click: function(){
                    	var me = this.up("gridpanel");
                		var selects = me.getView().getSelectionModel().getSelection();
                		var form = me.getNoticeForm();
                		var window = me.getWindow();
                		var record = selects[0];
                		form.loadRecord(record);
                		window.add(form);
                		window.show();
                		window.setTitle("修改入场");
                		form.down("htmleditor[name=mark]").setValue(record.get("mark"));
                		
                    }
                },
                scope: me
            },{
            	xtype:'button',
            	text:'删除',
            	hidden :true,
            	disabled:true,
            	iconCls:'Applicationformdelete',
            	name:'delete',
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
                    	       url: basepath+"platform/entrance/delete.do",  
                    	       method: "POST",
                    	       params: { 
                    	    	   "ids":codes
                    	       },

                    	       success: function (response, option) {  
     	               	    	response = Ext.JSON.decode(response.responseText);  
     	                        if (response.code == '10000') {  
     	                        	Ext.Msg.alert("提示", "删除成功");
     	                        	me.getStore().reload();
     	                        }else if(response.code == '10001') { 
     	                       	   Ext.MessageBox.alert("错误信息", "没有删除记录!");
     	                        } 
                    	       },  
                    	       failure: function () { Ext.Msg.alert("提示", "保存失败<br>没有捕获到异常"); }  
                      	});
                    		
                    }
                },
                scope: me
            },{
            	xtype:'button',
            	text:'离场',
            	disabled:true,
            	iconCls:'Applicationformdelete',
            	name:'out',
            	listeners: {
                    click: function(){
                    	Ext.MessageBox.confirm("信息", "确认离场吗?",function(value){
                    		if(value=='yes'){
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
                            	       url: basepath+"platform/entrance/outentrance.do",  
                            	       method: "POST",
                            	       params: { 
                            	    	   "ids":codes
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
                    		};
                    	});
                    	
                    		
                    }
                },
                scope: me
            },{
            	xtype:'button',
            	text:'刷新',
            	iconCls:'Arrowrotateclockwise',
            	name:'refresh',
            	listeners: {
                    click: function() {

                    	var store = me.getStore();
                    	store.reload();
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
                items: [username,card,entrancetime,departuretime,{
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
	
	getNoticeForm:function(){
		
		var s_combo = Ext.create('Ext.form.ComboBox', {
		    fieldLabel: '申请单',
		    store: Ext.create('Ext.data.Store',   { 
				fields:['id','settledtilte'],
				proxy: {
	                type: 'ajax',
	                actionMethods:{read:'POST'},
	                url: basepath+'platform/settled/queryplatformsettledspage.do',
	                params:{
	                },
	                reader: {
	                    type: 'json',
	                    root:'data',
	                    totalProperty:'total'
	                }
	            },    
				autoLoad:true   
			}),
		    labelWidth : 60,
		    width : 200,
		    labelAlign:'right',
		    queryMode: 'local',
		    displayField: 'settledtilte',
		    name:'settledid',
		    valueField: 'id'
		});
		
		
		var store = Ext.create('Ext.data.Store',   { 
			fields:['id','seatname'],
			proxy: {
                type: 'ajax',
                actionMethods:{read:'POST'},
				url: basepath+'platform/office/queryplatformseats.do',
                params:{
                },
                reader: {
                    type: 'json'
                }
            },    
			autoLoad:true   
		}); 
		
		var combo = Ext.create('Ext.form.ComboBox', {
		    fieldLabel: '办公室',
		    store: store,
		    labelWidth : 60,
		    width : 200,
		    queryMode: 'local',
		    labelAlign:'right',
		    displayField: 'seatname',
		    name:'seatid',
		    valueField: 'id'
		});
		
		var form = Ext.create("Ext.form.Panel",{
			region:'center',
			style : 'margin-left:5px;margin-right:5px;margin-top:5px;margin-bottom:5px;',
            labelAlign:"right",
            bodyPadding: 10,
            defaults: {
                anchor: '100%',
                labelWidth: 100
            },
            border:false,
            items: [{
                xtype: 'fieldset',
                title: '入场管理',
                //collapsible: true,
                defaults: {
                    labelWidth: 89,
                    anchor: '100%',
                    layout: {
                        type: 'hbox',
                        defaultMargins: {top: 5, right: 5, bottom: 0, left: 0}
                    }
                },
                items: [s_combo,{
                	xtype:'textfield',
                	name : 'id',
        			labelWidth : 60,
        			hidden:true,
        			readOnly:true,
        			width : 200,
        			fieldLabel : 'id'
                },{
                	xtype:'textfield',
                	name : 'username',
                	labelAlign:'right',
        			labelWidth : 60,
        			width : 200,
        			allowBlank:false,
        			fieldLabel : '入场人'
                },{
                	xtype:'textfield',
                	name : 'sex',
        			labelWidth : 60,
        			labelAlign:'right',
        			width : 200,
        			allowBlank:false,
        			fieldLabel : '性别'
                },{
                	xtype:'textfield',
                	name : 'card',
        			labelWidth : 60,
        			labelAlign:'right',
        			width : 200,
        			allowBlank:false,
        			fieldLabel : '身份证'
                },{
                	xtype:'textfield',
                	name : 'account',
                	labelAlign:'right',
        			labelWidth : 60,
        			width : 200,
        			allowBlank:false,
        			fieldLabel : '系统帐号'
                },combo,{
                	xtype:'htmleditor',
                	name : 'mark',
                	labelAlign:'right',
        			labelWidth : 60,
        			width : 200,
        			allowBlank:false,
        			height:250,
        			fieldLabel : '描述'
                }]
            }]
		});
		
		return form;
	},
	
	getWindow:function(){
		var me = this;
		var win = Ext.create("Ext.window.Window",{
			title:'title',
			width:475,
			height:550,
			layout:'border',
			buttons:[{
				text:'保存',
				handler:function(){
					var form = win.down("form");
					form.submit({  
					    url : basepath+"platform/entrance/update.do",  
					    baseParams : { 
					    },  
					    waitMsg : '正在提交数据',  
					    waitTitle : '提示',  
					    method : "POST",  
					    success : function(form, action) {  
					        // 得到数据  
					        var result = Ext.JSON.decode(action.response.responseText);// 就可以取出来。如果是数组，那么很简单  
					        if(result.code=='10000'){
					        	Ext.Msg.alert('提示', "保存成功！！！"); 
					        	me.getStore().load();
					        	win.close();
					        }
					    },  
					    failure : function(form, action) {  
					        Ext.Msg.alert('提示', "操作失败：输入非法字符！！！");  
					    }  
					});  
				}
			},{
				text:'取消',
				handler:function(){
					win.close();
				}
			}]
		
		});
		return win;
	}
});