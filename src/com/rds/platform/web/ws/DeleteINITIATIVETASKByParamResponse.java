
package com.rds.platform.web.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Delete_INITIATIVE_TASK_ByParamResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "deleteINITIATIVETASKByParamResult"
})
@XmlRootElement(name = "Delete_INITIATIVE_TASK_ByParamResponse")
public class DeleteINITIATIVETASKByParamResponse {

    @XmlElement(name = "Delete_INITIATIVE_TASK_ByParamResult")
    protected boolean deleteINITIATIVETASKByParamResult;

    /**
     * 获取deleteINITIATIVETASKByParamResult属性的值。
     * 
     */
    public boolean isDeleteINITIATIVETASKByParamResult() {
        return deleteINITIATIVETASKByParamResult;
    }

    /**
     * 设置deleteINITIATIVETASKByParamResult属性的值。
     * 
     */
    public void setDeleteINITIATIVETASKByParamResult(boolean value) {
        this.deleteINITIATIVETASKByParamResult = value;
    }

}
