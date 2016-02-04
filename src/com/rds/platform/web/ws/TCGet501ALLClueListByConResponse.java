
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
 *         &lt;element name="TC_Get501ALLClueListByConResult" minOccurs="0">
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
    "tcGet501ALLClueListByConResult"
})
@XmlRootElement(name = "TC_Get501ALLClueListByConResponse")
public class TCGet501ALLClueListByConResponse {

    @XmlElement(name = "TC_Get501ALLClueListByConResult")
    protected TCGet501ALLClueListByConResponse.TCGet501ALLClueListByConResult tcGet501ALLClueListByConResult;

    /**
     * 获取tcGet501ALLClueListByConResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TCGet501ALLClueListByConResponse.TCGet501ALLClueListByConResult }
     *     
     */
    public TCGet501ALLClueListByConResponse.TCGet501ALLClueListByConResult getTCGet501ALLClueListByConResult() {
        return tcGet501ALLClueListByConResult;
    }

    /**
     * 设置tcGet501ALLClueListByConResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TCGet501ALLClueListByConResponse.TCGet501ALLClueListByConResult }
     *     
     */
    public void setTCGet501ALLClueListByConResult(TCGet501ALLClueListByConResponse.TCGet501ALLClueListByConResult value) {
        this.tcGet501ALLClueListByConResult = value;
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
    public static class TCGet501ALLClueListByConResult {

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
