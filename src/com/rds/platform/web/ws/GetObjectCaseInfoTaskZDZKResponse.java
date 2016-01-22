
package com.rds.platform.web.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
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
 *         &lt;element name="GetObjectCaseInfoTask_ZDZKResult" minOccurs="0">
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
    "getObjectCaseInfoTaskZDZKResult"
})
@XmlRootElement(name = "GetObjectCaseInfoTask_ZDZKResponse")
public class GetObjectCaseInfoTaskZDZKResponse {

    @XmlElement(name = "GetObjectCaseInfoTask_ZDZKResult")
    protected GetObjectCaseInfoTaskZDZKResponse.GetObjectCaseInfoTaskZDZKResult getObjectCaseInfoTaskZDZKResult;

    /**
     * 获取getObjectCaseInfoTaskZDZKResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link GetObjectCaseInfoTaskZDZKResponse.GetObjectCaseInfoTaskZDZKResult }
     *     
     */
    public GetObjectCaseInfoTaskZDZKResponse.GetObjectCaseInfoTaskZDZKResult getGetObjectCaseInfoTaskZDZKResult() {
        return getObjectCaseInfoTaskZDZKResult;
    }

    /**
     * 设置getObjectCaseInfoTaskZDZKResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link GetObjectCaseInfoTaskZDZKResponse.GetObjectCaseInfoTaskZDZKResult }
     *     
     */
    public void setGetObjectCaseInfoTaskZDZKResult(GetObjectCaseInfoTaskZDZKResponse.GetObjectCaseInfoTaskZDZKResult value) {
        this.getObjectCaseInfoTaskZDZKResult = value;
    }


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
    public static class GetObjectCaseInfoTaskZDZKResult {

        @XmlAnyElement(lax = true)
        protected Object any;

        /**
         * 获取any属性的值。
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
         * 设置any属性的值。
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
