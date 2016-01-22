
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
 *         &lt;element name="UserID_1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserID_2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="caseid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="objectid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="clueid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="assignkind" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "userID1",
    "userID2",
    "caseid",
    "objectid",
    "clueid",
    "assignkind"
})
@XmlRootElement(name = "TC_Get501ALLClueListByCon")
public class TCGet501ALLClueListByCon {

    @XmlElement(name = "UserID_1")
    protected String userID1;
    @XmlElement(name = "UserID_2")
    protected String userID2;
    protected int caseid;
    protected int objectid;
    protected int clueid;
    protected int assignkind;

    /**
     * 获取userID1属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserID1() {
        return userID1;
    }

    /**
     * 设置userID1属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserID1(String value) {
        this.userID1 = value;
    }

    /**
     * 获取userID2属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserID2() {
        return userID2;
    }

    /**
     * 设置userID2属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserID2(String value) {
        this.userID2 = value;
    }

    /**
     * 获取caseid属性的值。
     * 
     */
    public int getCaseid() {
        return caseid;
    }

    /**
     * 设置caseid属性的值。
     * 
     */
    public void setCaseid(int value) {
        this.caseid = value;
    }

    /**
     * 获取objectid属性的值。
     * 
     */
    public int getObjectid() {
        return objectid;
    }

    /**
     * 设置objectid属性的值。
     * 
     */
    public void setObjectid(int value) {
        this.objectid = value;
    }

    /**
     * 获取clueid属性的值。
     * 
     */
    public int getClueid() {
        return clueid;
    }

    /**
     * 设置clueid属性的值。
     * 
     */
    public void setClueid(int value) {
        this.clueid = value;
    }

    /**
     * 获取assignkind属性的值。
     * 
     */
    public int getAssignkind() {
        return assignkind;
    }

    /**
     * 设置assignkind属性的值。
     * 
     */
    public void setAssignkind(int value) {
        this.assignkind = value;
    }

}
