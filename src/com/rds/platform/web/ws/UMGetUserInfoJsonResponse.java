
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
 *         &lt;element name="UM_GetUserInfo_JsonResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "umGetUserInfoJsonResult"
})
@XmlRootElement(name = "UM_GetUserInfo_JsonResponse")
public class UMGetUserInfoJsonResponse {

    @XmlElement(name = "UM_GetUserInfo_JsonResult")
    protected String umGetUserInfoJsonResult;

    /**
     * ��ȡumGetUserInfoJsonResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUMGetUserInfoJsonResult() {
        return umGetUserInfoJsonResult;
    }

    /**
     * ����umGetUserInfoJsonResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUMGetUserInfoJsonResult(String value) {
        this.umGetUserInfoJsonResult = value;
    }

}
