
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
 *         &lt;element name="msgTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="msgHtml" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="toUserID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="toMail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "msgTitle",
    "msgHtml",
    "toUserID",
    "toMail"
})
@XmlRootElement(name = "HS_SendMsgMail")
public class HSSendMsgMail {

    protected String msgTitle;
    protected String msgHtml;
    protected int toUserID;
    protected String toMail;

    /**
     * 获取msgTitle属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgTitle() {
        return msgTitle;
    }

    /**
     * 设置msgTitle属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgTitle(String value) {
        this.msgTitle = value;
    }

    /**
     * 获取msgHtml属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgHtml() {
        return msgHtml;
    }

    /**
     * 设置msgHtml属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgHtml(String value) {
        this.msgHtml = value;
    }

    /**
     * 获取toUserID属性的值。
     * 
     */
    public int getToUserID() {
        return toUserID;
    }

    /**
     * 设置toUserID属性的值。
     * 
     */
    public void setToUserID(int value) {
        this.toUserID = value;
    }

    /**
     * 获取toMail属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToMail() {
        return toMail;
    }

    /**
     * 设置toMail属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToMail(String value) {
        this.toMail = value;
    }

}
