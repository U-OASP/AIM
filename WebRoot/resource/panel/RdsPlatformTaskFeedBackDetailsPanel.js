/***
 * 任务反馈详情
 */
Ext.define("Rds.panel.RdsPlatformTaskFeedBackDetailsPanel",{
	extend:'Ext.panel.Panel',
	layout: 'border',
	name:'task',
	requires:[""], 
	html:'<div class="content" id="div1"></div>',
	tpl : new Ext.XTemplate(
			'<table cellpadding=0 cellspacing=0 border=1 width=100%>',
            '<tpl for=".">',
                '<tr class="data"><td class="x-editable">反馈内容:{fbmark}</br><a href="'+basepath+'platform/train/down.do?path={filepath:this.getPath()}">下载附件</a></td></tr>',
            '</tpl>',
            '</table>',
            {
            	getPath: function (filepath) {
            		return encodeURI(encodeURI(filepath));
            	}
            }),
	initComponent:function(){
		var me = this;
		
		me.callParent(arguments);
	},
	
	setItems:function(taskid){
		var me = this;
		Ext.Ajax.request({  
			url: basepath+"platform/task/queryplatformtaskfeedback.do",  
 	       	method: "POST",
 	       	params: { 
 	       		"taskid":taskid
 	       	},

 	       	success: function (response, option) {  
 	       		response = Ext.JSON.decode(response.responseText);  
// 	       		console.log(response);
 	       		me.tpl.overwrite(Ext.get("div1"), response);
 	       	},  
 	       	failure: function () { Ext.Msg.alert("提示", "保存失败<br>没有捕获到异常"); }  
		});
	}
	
});