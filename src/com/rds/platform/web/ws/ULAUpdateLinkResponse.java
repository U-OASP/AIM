
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
 *         &lt;element name="ULA_UpdateLinkResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "ulaUpdateLinkResult"
})
@XmlRootElement(name = "ULA_UpdateLinkResponse")
public class ULAUpdateLinkResponse {

    @XmlElement(name = "ULA_UpdateLinkResult")
    protected boolean ulaUpdateLinkResult;

    /**
     * 获取ulaUpdateLinkResult属性的值。
     * 
     */
    public boolean isULAUpdateLinkResult() {
        return ulaUpdateLinkResult;
    }

    /**
     * 设置ulaUpdateLinkResult属性的值。
     * 
     */
    public void setULAUpdateLinkResult(boolean value) {
        this.ulaUpdateLinkResult = value;
    }

}
