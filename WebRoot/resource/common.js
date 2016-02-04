/**
 * Created by dell on 2015-04-02.
 */
Ext.define("QualityInterval",{
    grid:null,
    //map:null,
    //i:0,
    interval:function(){
        var grid = this.grid;
        var me = this;
        if(grid!=null){
            var map = new Map();
            var i = 0;
            map.put(0,{keycode:'stream 实例正准备启动.'});
            map.put(1,{keycode:'stream 实例启动成功.'});
            map.put(2,{keycode:"stream 连接数据库成功."});
            map.put(3,{keycode:"stream 读取数据1000条."});
            map.put(4,{keycode:"stream 读取数据2000条."});
            map.put(5,{keycode:"stream 读取数据3000条."});
            map.put(6,{keycode:"stream 准备处理数据."});
            map.put(7,{keycode:"stream 处理数据完成.."});
            map.put(8,{keycode:"stream 实例完成."});

            var task = {
                run : function() {
                    if(i<9){
                        var store = grid.getStore();
                        store.add(map.get(i));
                        i++;
                    }else{
                        Ext.TaskManager.stop(task);
                    }

                },
                interval : 2000, //2秒刷新一次
                scope : this
            };
            Ext.TaskManager.start(task);
        }
    },

    constructor: function (grid) {
        this.grid = grid;
    }

});