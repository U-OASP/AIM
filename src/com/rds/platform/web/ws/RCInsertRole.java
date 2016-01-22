
package com.rds.platform.web.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="R_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="R_Assign" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="R_Rank" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "rName",
    "rAssign",
    "rRank"
})
@XmlRootElement(name = "RC_InsertRole")
public class RCInsertRole {

    @XmlElement(name = "R_Name")
    protected String rName;
    @XmlElement(name = "R_Assign")
    protected String rAssign;
    @XmlElement(name = "R_Rank")
    protected String rRank;

    /**
     * 获取rName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRName() {
        return rName;
    }

    /**
     * 设置rName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRName(String value) {
        this.rName = value;
    }

    /**
     * 获取rAssign属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRAssign() {
        return rAssign;
    }

    /**
     * 设置rAssign属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRAssign(String value) {
        this.rAssign = value;
    }

    /**
     * 获取rRank属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRRank() {
        return rRank;
    }

    /**
     * 设置rRank属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRRank(String value) {
        this.rRank = value;
    }

}
