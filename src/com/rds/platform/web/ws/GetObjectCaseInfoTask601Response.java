
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
 *         &lt;element name="GetObjectCaseInfoTask601Result" minOccurs="0">
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
    "getObjectCaseInfoTask601Result"
})
@XmlRootElement(name = "GetObjectCaseInfoTask601Response")
public class GetObjectCaseInfoTask601Response {

    @XmlElement(name = "GetObjectCaseInfoTask601Result")
    protected GetObjectCaseInfoTask601Response.GetObjectCaseInfoTask601Result getObjectCaseInfoTask601Result;

    /**
     * ��ȡgetObjectCaseInfoTask601Result���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link GetObjectCaseInfoTask601Response.GetObjectCaseInfoTask601Result }
     *     
     */
    public GetObjectCaseInfoTask601Response.GetObjectCaseInfoTask601Result getGetObjectCaseInfoTask601Result() {
        return getObjectCaseInfoTask601Result;
    }

    /**
     * ����getObjectCaseInfoTask601Result���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link GetObjectCaseInfoTask601Response.GetObjectCaseInfoTask601Result }
     *     
     */
    public void setGetObjectCaseInfoTask601Result(GetObjectCaseInfoTask601Response.GetObjectCaseInfoTask601Result value) {
        this.getObjectCaseInfoTask601Result = value;
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
    public static class GetObjectCaseInfoTask601Result {

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
