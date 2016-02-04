
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
 *         &lt;element name="wantedtype" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="loginname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "wantedtype",
    "loginname"
})
@XmlRootElement(name = "GetInfoByName")
public class GetInfoByName {

    protected int wantedtype;
    protected String loginname;

    /**
     * 获取wantedtype属性的值。
     * 
     */
    public int getWantedtype() {
        return wantedtype;
    }

    /**
     * 设置wantedtype属性的值。
     * 
     */
    public void setWantedtype(int value) {
        this.wantedtype = value;
    }

    /**
     * 获取loginname属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginname() {
        return loginname;
    }

    /**
     * 设置loginname属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginname(String value) {
        this.loginname = value;
    }

}
