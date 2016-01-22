Ext.define("QualityInterval",{
	grid:null,  
    interval:function(){
    	var grid = this.grid;
    	if(grid!=null){
    		
    		var task = {
    				run : function() {
    					var store = grid.getStore();
    					store.reload();
    			},    
    			interval : 1000*4500, //2秒刷新一次
    			
    			scope : this
    		};
//    		Ext.TaskManager.start(task);
    	}
    },
    constructor: function (grid) {  
        this.grid = grid; 
    } 
	
});