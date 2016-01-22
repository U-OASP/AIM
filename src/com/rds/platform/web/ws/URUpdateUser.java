
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
 *         &lt;element name="ParentID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ParentPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="User_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="User_Pass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="User_Remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="User_Sex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="User_Birth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="User_Role" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="User_Rank" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="User_DeptCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="User_LoginMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="User_Card" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="User_IP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="User_Method" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="User_Study" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="User_Role_Rank" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "parentID",
    "parentPath",
    "userID",
    "userPass",
    "userRemark",
    "userSex",
    "userBirth",
    "userRole",
    "userRank",
    "userDeptCode",
    "userLoginMethod",
    "userCard",
    "userIP",
    "userMethod",
    "userStudy",
    "userRoleRank"
})
@XmlRootElement(name = "UR_UpdateUser")
public class URUpdateUser {

    @XmlElement(name = "ParentID")
    protected String parentID;
    @XmlElement(name = "ParentPath")
    protected String parentPath;
    @XmlElement(name = "User_ID")
    protected String userID;
    @XmlElement(name = "User_Pass")
    protected String userPass;
    @XmlElement(name = "User_Remark")
    protected String userRemark;
    @XmlElement(name = "User_Sex")
    protected String userSex;
    @XmlElement(name = "User_Birth")
    protected String userBirth;
    @XmlElement(name = "User_Role")
    protected String userRole;
    @XmlElement(name = "User_Rank")
    protected String userRank;
    @XmlElement(name = "User_DeptCode")
    protected String userDeptCode;
    @XmlElement(name = "User_LoginMethod")
    protected String userLoginMethod;
    @XmlElement(name = "User_Card")
    protected String userCard;
    @XmlElement(name = "User_IP")
    protected String userIP;
    @XmlElement(name = "User_Method")
    protected String userMethod;
    @XmlElement(name = "User_Study")
    protected String userStudy;
    @XmlElement(name = "User_Role_Rank")
    protected String userRoleRank;

    /**
     * 获取parentID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentID() {
        return parentID;
    }

    /**
     * 设置parentID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentID(String value) {
        this.parentID = value;
    }

    /**
     * 获取parentPath属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentPath() {
        return parentPath;
    }

    /**
     * 设置parentPath属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentPath(String value) {
        this.parentPath = value;
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
     * 获取userPass属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserPass() {
        return userPass;
    }

    /**
     * 设置userPass属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserPass(String value) {
        this.userPass = value;
    }

    /**
     * 获取userRemark属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserRemark() {
        return userRemark;
    }

    /**
     * 设置userRemark属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserRemark(String value) {
        this.userRemark = value;
    }

    /**
     * 获取userSex属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserSex() {
        return userSex;
    }

    /**
     * 设置userSex属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserSex(String value) {
        this.userSex = value;
    }

    /**
     * 获取userBirth属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserBirth() {
        return userBirth;
    }

    /**
     * 设置userBirth属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserBirth(String value) {
        this.userBirth = value;
    }

    /**
     * 获取userRole属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * 设置userRole属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserRole(String value) {
        this.userRole = value;
    }

    /**
     * 获取userRank属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserRank() {
        return userRank;
    }

    /**
     * 设置userRank属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserRank(String value) {
        this.userRank = value;
    }

    /**
     * 获取userDeptCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserDeptCode() {
        return userDeptCode;
    }

    /**
     * 设置userDeptCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserDeptCode(String value) {
        this.userDeptCode = value;
    }

    /**
     * 获取userLoginMethod属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserLoginMethod() {
        return userLoginMethod;
    }

    /**
     * 设置userLoginMethod属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserLoginMethod(String value) {
        this.userLoginMethod = value;
    }

    /**
     * 获取userCard属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserCard() {
        return userCard;
    }

    /**
     * 设置userCard属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserCard(String value) {
        this.userCard = value;
    }

    /**
     * 获取userIP属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserIP() {
        return userIP;
    }

    /**
     * 设置userIP属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserIP(String value) {
        this.userIP = value;
    }

    /**
     * 获取userMethod属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserMethod() {
        return userMethod;
    }

    /**
     * 设置userMethod属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserMethod(String value) {
        this.userMethod = value;
    }

    /**
     * 获取userStudy属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserStudy() {
        return userStudy;
    }

    /**
     * 设置userStudy属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserStudy(String value) {
        this.userStudy = value;
    }

    /**
     * 获取userRoleRank属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserRoleRank() {
        return userRoleRank;
    }

    /**
     * 设置userRoleRank属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserRoleRank(String value) {
        this.userRoleRank = value;
    }

}
