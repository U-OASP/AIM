
package com.rds.platform.web.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="getManageUserNameIdsByDeptcodeResult" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="strUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strUserIds" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "getManageUserNameIdsByDeptcodeResult",
    "strUserName",
    "strUserIds"
})
@XmlRootElement(name = "getManageUserNameIdsByDeptcodeResponse")
public class GetManageUserNameIdsByDeptcodeResponse {

    protected Object getManageUserNameIdsByDeptcodeResult;
    protected String strUserName;
    protected String strUserIds;

    /**
     * 获取getManageUserNameIdsByDeptcodeResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getGetManageUserNameIdsByDeptcodeResult() {
        return getManageUserNameIdsByDeptcodeResult;
    }

    /**
     * 设置getManageUserNameIdsByDeptcodeResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setGetManageUserNameIdsByDeptcodeResult(Object value) {
        this.getManageUserNameIdsByDeptcodeResult = value;
    }

    /**
     * 获取strUserName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrUserName() {
        return strUserName;
    }

    /**
     * 设置strUserName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrUserName(String value) {
        this.strUserName = value;
    }

    /**
     * 获取strUserIds属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrUserIds() {
        return strUserIds;
    }

    /**
     * 设置strUserIds属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrUserIds(String value) {
        this.strUserIds = value;
    }

}
