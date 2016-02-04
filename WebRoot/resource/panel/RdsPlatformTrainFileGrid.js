/**
 * 培训管理
 */
Ext.define("Rds.panel.RdsPlatformTrainFileGrid",{
	extend:'Ext.grid.Panel',
	title:'培训管理',
	region:'west',
	tid:'',
	initComponent:function(){
		var me = this;
		
		me.store = Ext.create('Ext.data.Store',{
			fields:['tid','path','filename','id','createtime'],
			proxy: {
                type: 'ajax',
                actionMethods:{read:'POST'},
				url: basepath+'platform/train/queryplatformtrainfiles.do',
                params:{
                	tid:'90D075C8B79C4212AAE70FE83AEC62CD'
                },
                reader: {
                    type: 'json'
                }
            },
            listeners:{
            	beforeload:function( store, operation, eOpts ){
	        		Ext.apply(store.proxy.extraParams, {
	        			tid:me.tid
	        		});
	        	},
	        	load:function(){
	        		me.selModel.deselectAll();
	        	}
            }
		});
		
//		me.store.load();
        me.columns = [
	      				{text: "文件名", dataIndex: 'filename',width:250}];
        me.selModel = Ext.create('Ext.selection.CheckboxModel',{
			listeners:{
				'selectionchange':function( model, record, index, eOpts ){
					var selects = me.getView().getSelectionModel().getSelection().length;
					var tbar = me.down("toolbar");
					
					var btn_down = tbar.down("button[name=down]");
					
					if(selects==1){
						btn_down.setDisabled(false);
					}else if(selects>1){
						btn_down.setDisabled(false);
					}else if(selects<1){
						btn_down.setDisabled(true);
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
            	hidden:true,
            	text:'删除',
            	disabled:true,
            	iconCls:'Applicationformdelete',
            	name:'delete',
            	listeners: {
                    click: function(){
                    	var selections = me.getView().getSelectionModel().getSelection();
                    	var codes = '';
                    	for(var i=0;i<selections.length;i++){
                			var item = selections[i];
                			codes = codes +'\''+item.get("tid")+'\'';
                			if(i!=(selections.length-1)){
                				codes = codes+",";
                			}
                		}
                		Ext.Ajax.request({  
                    	       url: basepath+"platform/train/delete.do",  
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
            	text:'下载',
            	disabled:true,
            	iconCls:'Applicationformdelete',
            	name:'down',
            	listeners: {
                    click: function(){
                    	var selections = me.getView().getSelectionModel().getSelection();
                    	var record = selections[0];
                    	var path = record.get("path");
                    	var filename = record.get("filename");
                    	window.location.href = basepath+'platform/train/upload.do?filename='+encodeURI(encodeURI(filename))+'&path='+encodeURI(encodeURI(path));  
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
		}];
        
		me.callParent(arguments);
	}
});