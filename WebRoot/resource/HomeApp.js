Ext.Loader.setConfig({
    enabled: true,
    paths: {
    	"Rds.view": "resource/view",
        "Rds.ux": "resource/ux",
        "Rds.panel": "resource/panel"
    }
});
Ext.require('Rds.view.ViewPart');
Ext.onReady(function() {
	Ext.tip.QuickTipManager.init();
    var proto = Ext.picker.Date.prototype, date = Ext.Date;
    proto.monthNames = date.monthNames;
    proto.dayNames = date.dayNames;
    proto.format = date.defaultFormat;
	Ext.create('Rds.view.ViewPart');
});
