
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
 *         &lt;element name="TC_Get501_Check_ClueListResult" minOccurs="0">
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
    "tcGet501CheckClueListResult"
})
@XmlRootElement(name = "TC_Get501_Check_ClueListResponse")
public class TCGet501CheckClueListResponse {

    @XmlElement(name = "TC_Get501_Check_ClueListResult")
    protected TCGet501CheckClueListResponse.TCGet501CheckClueListResult tcGet501CheckClueListResult;

    /**
     * 获取tcGet501CheckClueListResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TCGet501CheckClueListResponse.TCGet501CheckClueListResult }
     *     
     */
    public TCGet501CheckClueListResponse.TCGet501CheckClueListResult getTCGet501CheckClueListResult() {
        return tcGet501CheckClueListResult;
    }

    /**
     * 设置tcGet501CheckClueListResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TCGet501CheckClueListResponse.TCGet501CheckClueListResult }
     *     
     */
    public void setTCGet501CheckClueListResult(TCGet501CheckClueListResponse.TCGet501CheckClueListResult value) {
        this.tcGet501CheckClueListResult = value;
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
    public static class TCGet501CheckClueListResult {

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
