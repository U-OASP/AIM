
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
 *         &lt;element name="CaseID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ObjectID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ClueID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserIsManager" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Assigner" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AssignKind" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DealKind" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "caseID",
    "objectID",
    "clueID",
    "userID",
    "userIsManager",
    "assigner",
    "assignKind",
    "dealKind"
})
@XmlRootElement(name = "InsertTask701")
public class InsertTask701 {

    @XmlElement(name = "CaseID")
    protected String caseID;
    @XmlElement(name = "ObjectID")
    protected String objectID;
    @XmlElement(name = "ClueID")
    protected String clueID;
    @XmlElement(name = "UserID")
    protected String userID;
    @XmlElement(name = "UserIsManager")
    protected String userIsManager;
    @XmlElement(name = "Assigner")
    protected String assigner;
    @XmlElement(name = "AssignKind")
    protected String assignKind;
    @XmlElement(name = "DealKind")
    protected String dealKind;

    /**
     * 获取caseID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaseID() {
        return caseID;
    }

    /**
     * 设置caseID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaseID(String value) {
        this.caseID = value;
    }

    /**
     * 获取objectID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjectID() {
        return objectID;
    }

    /**
     * 设置objectID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjectID(String value) {
        this.objectID = value;
    }

    /**
     * 获取clueID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClueID() {
        return clueID;
    }

    /**
     * 设置clueID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClueID(String value) {
        this.clueID = value;
    }

    /**
     * 获取userID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserID() {
        return userID;
    }

    /**
     * 设置userID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserID(String value) {
        this.userID = value;
    }

    /**
     * 获取userIsManager属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserIsManager() {
        return userIsManager;
    }

    /**
     * 设置userIsManager属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserIsManager(String value) {
        this.userIsManager = value;
    }

    /**
     * 获取assigner属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssigner() {
        return assigner;
    }

    /**
     * 设置assigner属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssigner(String value) {
        this.assigner = value;
    }

    /**
     * 获取assignKind属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssignKind() {
        return assignKind;
    }

    /**
     * 设置assignKind属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssignKind(String value) {
        this.assignKind = value;
    }

    /**
     * 获取dealKind属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDealKind() {
        return dealKind;
    }

    /**
     * 设置dealKind属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDealKind(String value) {
        this.dealKind = value;
    }

}
