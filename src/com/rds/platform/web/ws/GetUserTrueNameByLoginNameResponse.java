
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
 *         &lt;element name="GetUserTrueNameByLoginNameResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "getUserTrueNameByLoginNameResult"
})
@XmlRootElement(name = "GetUserTrueNameByLoginNameResponse")
public class GetUserTrueNameByLoginNameResponse {

    @XmlElement(name = "GetUserTrueNameByLoginNameResult")
    protected String getUserTrueNameByLoginNameResult;

    /**
     * 获取getUserTrueNameByLoginNameResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetUserTrueNameByLoginNameResult() {
        return getUserTrueNameByLoginNameResult;
    }

    /**
     * 设置getUserTrueNameByLoginNameResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetUserTrueNameByLoginNameResult(String value) {
        this.getUserTrueNameByLoginNameResult = value;
    }

}
