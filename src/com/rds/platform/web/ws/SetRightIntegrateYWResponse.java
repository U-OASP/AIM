
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
 *         &lt;element name="SetRightIntegrateYWResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "setRightIntegrateYWResult"
})
@XmlRootElement(name = "SetRightIntegrateYWResponse")
public class SetRightIntegrateYWResponse {

    @XmlElement(name = "SetRightIntegrateYWResult")
    protected boolean setRightIntegrateYWResult;

    /**
     * 获取setRightIntegrateYWResult属性的值。
     * 
     */
    public boolean isSetRightIntegrateYWResult() {
        return setRightIntegrateYWResult;
    }

    /**
     * 设置setRightIntegrateYWResult属性的值。
     * 
     */
    public void setSetRightIntegrateYWResult(boolean value) {
        this.setRightIntegrateYWResult = value;
    }

}
