
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
 *         &lt;element name="strUser_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bIsUsed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "strUserID",
    "bIsUsed"
})
@XmlRootElement(name = "HS_UpdateUserStatus")
public class HSUpdateUserStatus {

    @XmlElement(name = "strUser_ID")
    protected String strUserID;
    protected boolean bIsUsed;

    /**
     * 获取strUserID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrUserID() {
        return strUserID;
    }

    /**
     * 设置strUserID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrUserID(String value) {
        this.strUserID = value;
    }

    /**
     * 获取bIsUsed属性的值。
     * 
     */
    public boolean isBIsUsed() {
        return bIsUsed;
    }

    /**
     * 设置bIsUsed属性的值。
     * 
     */
    public void setBIsUsed(boolean value) {
        this.bIsUsed = value;
    }

}
