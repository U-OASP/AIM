
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
 *         &lt;element name="Delete_INITIATIVE_TASKResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "deleteINITIATIVETASKResult"
})
@XmlRootElement(name = "Delete_INITIATIVE_TASKResponse")
public class DeleteINITIATIVETASKResponse {

    @XmlElement(name = "Delete_INITIATIVE_TASKResult")
    protected boolean deleteINITIATIVETASKResult;

    /**
     * 获取deleteINITIATIVETASKResult属性的值。
     * 
     */
    public boolean isDeleteINITIATIVETASKResult() {
        return deleteINITIATIVETASKResult;
    }

    /**
     * 设置deleteINITIATIVETASKResult属性的值。
     * 
     */
    public void setDeleteINITIATIVETASKResult(boolean value) {
        this.deleteINITIATIVETASKResult = value;
    }

}
