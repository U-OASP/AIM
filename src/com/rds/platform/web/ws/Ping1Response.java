
package com.rds.platform.web.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="Ping1Result" type="{http://WangShuai.UserCtrl.org/}UserInfo" minOccurs="0"/>
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
    "ping1Result"
})
@XmlRootElement(name = "Ping1Response")
public class Ping1Response {

    @XmlElement(name = "Ping1Result")
    protected UserInfo ping1Result;

    /**
     * ��ȡping1Result���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link UserInfo }
     *     
     */
    public UserInfo getPing1Result() {
        return ping1Result;
    }

    /**
     * ����ping1Result���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link UserInfo }
     *     
     */
    public void setPing1Result(UserInfo value) {
        this.ping1Result = value;
    }

}
