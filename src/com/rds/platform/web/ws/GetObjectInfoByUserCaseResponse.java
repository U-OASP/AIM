
package com.rds.platform.web.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
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
 *         &lt;element name="GetObjectInfoByUserCaseResult" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;any/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "getObjectInfoByUserCaseResult"
})
@XmlRootElement(name = "GetObjectInfoByUserCaseResponse")
public class GetObjectInfoByUserCaseResponse {

    @XmlElement(name = "GetObjectInfoByUserCaseResult")
    protected GetObjectInfoByUserCaseResponse.GetObjectInfoByUserCaseResult getObjectInfoByUserCaseResult;

    /**
     * ��ȡgetObjectInfoByUserCaseResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link GetObjectInfoByUserCaseResponse.GetObjectInfoByUserCaseResult }
     *     
     */
    public GetObjectInfoByUserCaseResponse.GetObjectInfoByUserCaseResult getGetObjectInfoByUserCaseResult() {
        return getObjectInfoByUserCaseResult;
    }

    /**
     * ����getObjectInfoByUserCaseResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link GetObjectInfoByUserCaseResponse.GetObjectInfoByUserCaseResult }
     *     
     */
    public void setGetObjectInfoByUserCaseResult(GetObjectInfoByUserCaseResponse.GetObjectInfoByUserCaseResult value) {
        this.getObjectInfoByUserCaseResult = value;
    }


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
     *         &lt;any/>
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
        "any"
    })
    public static class GetObjectInfoByUserCaseResult {

        @XmlAnyElement(lax = true)
        protected Object any;

        /**
         * ��ȡany���Ե�ֵ��
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getAny() {
            return any;
        }

        /**
         * ����any���Ե�ֵ��
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setAny(Object value) {
            this.any = value;
        }

    }

}
