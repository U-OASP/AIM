
package com.rds.platform.web.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡmsgTitle���Ե�ֵ��
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
     * ����msgTitle���Ե�ֵ��
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
     * ��ȡmsgHtml���Ե�ֵ��
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
     * ����msgHtml���Ե�ֵ��
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
     * ��ȡtoUserID���Ե�ֵ��
     * 
     */
    public int getToUserID() {
        return toUserID;
    }

    /**
     * ����toUserID���Ե�ֵ��
     * 
     */
    public void setToUserID(int value) {
        this.toUserID = value;
    }

    /**
     * ��ȡtoMail���Ե�ֵ��
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
     * ����toMail���Ե�ֵ��
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
