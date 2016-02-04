
package com.rds.platform.web.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="strUID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strUCASE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nUserID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nStatus" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "strUID",
    "strUCASE",
    "nUserID",
    "nStatus"
})
@XmlRootElement(name = "CheckUserLoginNotCrypt")
public class CheckUserLoginNotCrypt {

    protected String strUID;
    protected String strUCASE;
    protected int nUserID;
    protected int nStatus;

    /**
     * 获取strUID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrUID() {
        return strUID;
    }

    /**
     * 设置strUID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrUID(String value) {
        this.strUID = value;
    }

    /**
     * 获取strUCASE属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrUCASE() {
        return strUCASE;
    }

    /**
     * 设置strUCASE属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrUCASE(String value) {
        this.strUCASE = value;
    }

    /**
     * 获取nUserID属性的值。
     * 
     */
    public int getNUserID() {
        return nUserID;
    }

    /**
     * 设置nUserID属性的值。
     * 
     */
    public void setNUserID(int value) {
        this.nUserID = value;
    }

    /**
     * 获取nStatus属性的值。
     * 
     */
    public int getNStatus() {
        return nStatus;
    }

    /**
     * 设置nStatus属性的值。
     * 
     */
    public void setNStatus(int value) {
        this.nStatus = value;
    }

}
