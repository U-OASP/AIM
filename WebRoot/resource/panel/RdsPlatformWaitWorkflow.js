Ext.define("Rds.panel.RdsPlatformWaitWorkflow",{
	extend:'Ext.grid.Panel',
	title:'待办事项',
	pageSize:25,
	requires:'Rds.ux.DateTimeField',
	serviceType:2,
	initComponent:function(){
		var me = this;
		
		var beginTime = Ext.create("Rds.ux.DateTimeField",{
			width : 210,
            labelWidth : 60,
            endDateField:'endtime',
//            vtype:'daterange',
            fieldLabel: '开始时间',
            format: 'Y-m-d H:i:s',
            name:'beginTime'
        });
		
		var endTime = Ext.create("Rds.ux.DateTimeField",{
			width : 210,
            labelWidth : 60,
            startDateField:'beginTime',
//            vtype:'daterange',
            fieldLabel: '结束时间',
            format: 'Y-m-d H:i:s',
            name:'endTime'
        });
		
		Ext.define('State', {  
	        extend: 'Ext.data.Model',  
	        fields: [ 
	            { type: 'string', name: 'name' },  
	            { type: 'string', name: 'value' }  
	        ]  
	    });  
	    // The data for all states  
	    var states = [  
//	        { "name": "1", "value": "草稿" },  
	        { "name": "2", "value": "待办" } 
//	        { "name": "3", "value": "待跟踪" }  
	        ];  
	  
	    // The data store holding the states; shared by each of the ComboBox examples below  
	    var store = Ext.create('Ext.data.Store', {  
	        model: 'State',  
	        data: states  
	    }); 
        
        var operate = Ext.create('Ext.form.field.ComboBox', {  
            fieldLabel: '操作类型',  
            name : 'operate',
            displayField: 'value', 
            valueField:'name',
            width: 200,  
            labelWidth: 60,  
            store: store,  
            queryMode: 'local',  
            typeAhead: true,
            value:'2'
        });/*Ext.create("Ext.form.field.Text",{
        	name : 'operate',
			labelWidth : 60,
			width : 200,
			fieldLabel : '操作类型'
        });*/ 
		
		var interval = new QualityInterval(me);
		interval.interval();
		
		me.store = Ext.create('Ext.data.Store',{
			fields:['processInstanceId','submitter','categoryName','code','priority','createTime','surplusTime','subject','states'],
			pageSize:me.pageSize,
			proxy: {
                type: 'ajax',
                actionMethods:{read:'POST'},
				url: basepath+'platform/wait/queryplatformwaitworkflowpage.do',
                params:{
                	
                },
                reader: {
                    type: 'json',
                    root:'datas',
                    totalProperty:'total'
                }
            },
            listeners:{
	            beforeload:function( store, operation, eOpts ){
	            	var btime = Ext.util.Format.date(beginTime.getValue(),"Y-m-d H:i:s");
	    			var etime = Ext.util.Format.date(endTime.getValue(),"Y-m-d H:i:s");
	    			
	        		Ext.apply(store.proxy.extraParams, {
	        			'operate':'\''+2+'\'',
	        			'userId':'\''+username+'\'',
	        			'beginTime':'\''+btime+'\'',
	        			'endTime':'\''+etime+'\'',
	        			'serviceType':'\''+me.serviceType+'\'',
	        			'status':'\''+2+'\'',
	        			'title':'\''+'\''
	        		});
	        	}
            }
		});

		me.store.load();
        me.columns = [
                      //Ext.create("Ext.grid.RowNumberer",{text: '序号',width:39,align:'center'}),
                      { text: '工单编号', dataIndex: 'processInstanceId',width:170},
                      { text: '工单主题', dataIndex: 'subject',width:170,
                    	  renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
                    		  
                    		  var processInstanceID = record.get("processInstanceID");
                    		  var url = itsm+"bpm/showDealProcessBPMExecAction.action?processInstanceID="+processInstanceId+"&workBenchID=dealWorkorder_"+processInstanceID;
                    		  return "<a href='javascript:openDialog(\'"+url+")'\'></a>";
                    	  }
                      
                      },
                      { text: '优先级', dataIndex: 'priority',width:100},
                      { text: '上一处理人', dataIndex: 'submitter',width:80},
                      { text: '创建时间', dataIndex: 'createTime',width:120},
                      { text: '超时警告', dataIndex: '',width:120},
                      { text: '剩余时间', dataIndex: 'surplusTime',width:120}];
		
//		function getPostParams(){
//			var btime = Ext.util.Format.date(beginTime.getValue(),"Y-m-d H:i:s");
//			var etime = Ext.util.Format.date(endTime.getValue(),"Y-m-d H:i:s");
//			return {"beginTime":btime,"endTime":etime,"serviceType":me.serviceType,"status":2};
//		}
        
        me.dockedItems = [{
			xtype : 'toolbar',
			name : 'search',
			dock : 'top',
			items : [{
				text:'事件',
				handler:function(){
					me.serviceType = 2;
					me.store.load();
				}
			},'-',{
				text:'变更',
				handler:function(){
					me.serviceType = 3;
					me.store.load();
				}
			},'-',{
				text:'问题',
				handler:function(){
					me.serviceType = 4;
					me.store.load();
				}
			},'-',{
				text:'发布',
				handler:function(){
					me.serviceType = 5;
					me.store.load();
				}
			},'-',{
				text:'任务',
				handler:function(){
					me.serviceType = 6;
					me.store.load();
				}
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
                items: [beginTime,endTime,{
					xtype : 'button',
					text:'查询',
					iconCls : 'Find',
					handler:me.onSearch
				}]
			}]
		}];
        
        me.bbar = new Ext.PagingToolbar({
			pageSize : me.pageSize,  // 一页显示25行
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