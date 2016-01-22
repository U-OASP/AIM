package com.rds.code.model;

/**
 * @author linys
 * @ClassName: MsgModelUtil
 * @Description: 获取返回页面内容模板工具类
 * @date 2015年4月8日
 */
public class MsgModelUtil {
    public static BaseMessageModel getModel(boolean result,String msg){
        BaseMessageModel model = new BaseMessageModel();
        model.setResult(result);
        model.setMessage(msg);
        return model;
    }
}
