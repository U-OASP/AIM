
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
 *         &lt;element name="GetUserClassResult" type="{http://WangShuai.UserCtrl.org/}UserInfo" minOccurs="0"/>
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
    "getUserClassResult"
})
@XmlRootElement(name = "GetUserClassResponse")
public class GetUserClassResponse {

    @XmlElement(name = "GetUserClassResult")
    protected UserInfo getUserClassResult;

    /**
     * ��ȡgetUserClassResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link UserInfo }
     *     
     */
    public UserInfo getGetUserClassResult() {
        return getUserClassResult;
    }

    /**
     * ����getUserClassResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link UserInfo }
     *     
     */
    public void setGetUserClassResult(UserInfo value) {
        this.getUserClassResult = value;
    }

}
