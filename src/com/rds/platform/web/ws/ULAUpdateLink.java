
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
 *         &lt;element name="ULA_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserContent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "ulaid",
    "userMethod",
    "userContent"
})
@XmlRootElement(name = "ULA_UpdateLink")
public class ULAUpdateLink {

    @XmlElement(name = "ULA_ID")
    protected String ulaid;
    @XmlElement(name = "UserMethod")
    protected String userMethod;
    @XmlElement(name = "UserContent")
    protected String userContent;

    /**
     * 获取ulaid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getULAID() {
        return ulaid;
    }

    /**
     * 设置ulaid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setULAID(String value) {
        this.ulaid = value;
    }

    /**
     * 获取userMethod属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserMethod() {
        return userMethod;
    }

    /**
     * 设置userMethod属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserMethod(String value) {
        this.userMethod = value;
    }

    /**
     * 获取userContent属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserContent() {
        return userContent;
    }

    /**
     * 设置userContent属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserContent(String value) {
        this.userContent = value;
    }

}
