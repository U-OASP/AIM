
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
 *         &lt;element name="GetTaskByClueIDResult" minOccurs="0">
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
    "getTaskByClueIDResult"
})
@XmlRootElement(name = "GetTaskByClueIDResponse")
public class GetTaskByClueIDResponse {

    @XmlElement(name = "GetTaskByClueIDResult")
    protected GetTaskByClueIDResponse.GetTaskByClueIDResult getTaskByClueIDResult;

    /**
     * ��ȡgetTaskByClueIDResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link GetTaskByClueIDResponse.GetTaskByClueIDResult }
     *     
     */
    public GetTaskByClueIDResponse.GetTaskByClueIDResult getGetTaskByClueIDResult() {
        return getTaskByClueIDResult;
    }

    /**
     * ����getTaskByClueIDResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link GetTaskByClueIDResponse.GetTaskByClueIDResult }
     *     
     */
    public void setGetTaskByClueIDResult(GetTaskByClueIDResponse.GetTaskByClueIDResult value) {
        this.getTaskByClueIDResult = value;
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
    public static class GetTaskByClueIDResult {

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
