Ext.Loader.setConfig({
    enabled: true,
    paths: {
    	"Rds.view": "resource/view",
        "Rds.ux": "resource/ux",
        "Rds.panel": "resource/panel"
    }
});
Ext.require('Rds.view.IndexViewPart');
Ext.onReady(function() {
    var proto = Ext.picker.Date.prototype, date = Ext.Date;
    proto.monthNames = date.monthNames;
    proto.dayNames = date.dayNames;
    proto.format = date.defaultFormat;
    Ext.override(Ext.form.field.Base,{     
    	//针对form中的基本组件 　　     
    	initComponent:function(){        
    	 if(this.allowBlank!==undefined && !this.allowBlank){       
    	 if(this.fieldLabel){ this.fieldLabel += '<font color=red>*</font>';     
    	 }       
    	 }       
    	 this.callParent(arguments);     
    	 } 
    	 });
	Ext.create('Rds.view.IndexViewPart');
});



