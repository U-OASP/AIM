
package com.rds.platform.web.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>UserInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="UserInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DEPT_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BIRTHDAY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DEPARTMENT_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LOGINNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LOGIN_METHOD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MAILADDRESS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PARENT_ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RANK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REMARK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SEX" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="STATUS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="USERNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="USERPATH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="USER_CREATED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="USER_ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="USER_REG_IP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CARD_SN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="USER_STUDY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="USER_METHOD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ROLE_RANK" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="USER_ORDER" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IS_DBCHK" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="USER_ROLE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="USER_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DFKY_CARD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SelectString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserInfo", propOrder = {
    "deptname",
    "birthday",
    "departmentid",
    "loginname",
    "loginmethod",
    "mailaddress",
    "parentid",
    "rank",
    "remark",
    "sex",
    "status",
    "username",
    "userpath",
    "usercreated",
    "userid",
    "userregip",
    "cardsn",
    "userstudy",
    "usermethod",
    "rolerank",
    "userorder",
    "isdbchk",
    "userrole",
    "usertype",
    "dfkycard",
    "selectString"
})
public class UserInfo {

    @XmlElement(name = "DEPT_NAME")
    protected String deptname;
    @XmlElement(name = "BIRTHDAY")
    protected String birthday;
    @XmlElement(name = "DEPARTMENT_ID")
    protected String departmentid;
    @XmlElement(name = "LOGINNAME")
    protected String loginname;
    @XmlElement(name = "LOGIN_METHOD")
    protected String loginmethod;
    @XmlElement(name = "MAILADDRESS")
    protected String mailaddress;
    @XmlElement(name = "PARENT_ID")
    protected int parentid;
    @XmlElement(name = "RANK")
    protected String rank;
    @XmlElement(name = "REMARK")
    protected String remark;
    @XmlElement(name = "SEX")
    protected int sex;
    @XmlElement(name = "STATUS")
    protected int status;
    @XmlElement(name = "USERNAME")
    protected String username;
    @XmlElement(name = "USERPATH")
    protected String userpath;
    @XmlElement(name = "USER_CREATED")
    protected String usercreated;
    @XmlElement(name = "USER_ID")
    protected int userid;
    @XmlElement(name = "USER_REG_IP")
    protected String userregip;
    @XmlElement(name = "CARD_SN")
    protected String cardsn;
    @XmlElement(name = "USER_STUDY")
    protected String userstudy;
    @XmlElement(name = "USER_METHOD")
    protected String usermethod;
    @XmlElement(name = "ROLE_RANK")
    protected int rolerank;
    @XmlElement(name = "USER_ORDER")
    protected int userorder;
    @XmlElement(name = "IS_DBCHK")
    protected int isdbchk;
    @XmlElement(name = "USER_ROLE")
    protected String userrole;
    @XmlElement(name = "USER_TYPE")
    protected String usertype;
    @XmlElement(name = "DFKY_CARD")
    protected String dfkycard;
    @XmlElement(name = "SelectString")
    protected String selectString;

    /**
     * 获取deptname属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDEPTNAME() {
        return deptname;
    }

    /**
     * 设置deptname属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDEPTNAME(String value) {
        this.deptname = value;
    }

    /**
     * 获取birthday属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBIRTHDAY() {
        return birthday;
    }

    /**
     * 设置birthday属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBIRTHDAY(String value) {
        this.birthday = value;
    }

    /**
     * 获取departmentid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDEPARTMENTID() {
        return departmentid;
    }

    /**
     * 设置departmentid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDEPARTMENTID(String value) {
        this.departmentid = value;
    }

    /**
     * 获取loginname属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLOGINNAME() {
        return loginname;
    }

    /**
     * 设置loginname属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLOGINNAME(String value) {
        this.loginname = value;
    }

    /**
     * 获取loginmethod属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLOGINMETHOD() {
        return loginmethod;
    }

    /**
     * 设置loginmethod属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLOGINMETHOD(String value) {
        this.loginmethod = value;
    }

    /**
     * 获取mailaddress属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMAILADDRESS() {
        return mailaddress;
    }

    /**
     * 设置mailaddress属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMAILADDRESS(String value) {
        this.mailaddress = value;
    }

    /**
     * 获取parentid属性的值。
     * 
     */
    public int getPARENTID() {
        return parentid;
    }

    /**
     * 设置parentid属性的值。
     * 
     */
    public void setPARENTID(int value) {
        this.parentid = value;
    }

    /**
     * 获取rank属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRANK() {
        return rank;
    }

    /**
     * 设置rank属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRANK(String value) {
        this.rank = value;
    }

    /**
     * 获取remark属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREMARK() {
        return remark;
    }

    /**
     * 设置remark属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREMARK(String value) {
        this.remark = value;
    }

    /**
     * 获取sex属性的值。
     * 
     */
    public int getSEX() {
        return sex;
    }

    /**
     * 设置sex属性的值。
     * 
     */
    public void setSEX(int value) {
        this.sex = value;
    }

    /**
     * 获取status属性的值。
     * 
     */
    public int getSTATUS() {
        return status;
    }

    /**
     * 设置status属性的值。
     * 
     */
    public void setSTATUS(int value) {
        this.status = value;
    }

    /**
     * 获取username属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSERNAME() {
        return username;
    }

    /**
     * 设置username属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSERNAME(String value) {
        this.username = value;
    }

    /**
     * 获取userpath属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSERPATH() {
        return userpath;
    }

    /**
     * 设置userpath属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSERPATH(String value) {
        this.userpath = value;
    }

    /**
     * 获取usercreated属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSERCREATED() {
        return usercreated;
    }

    /**
     * 设置usercreated属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSERCREATED(String value) {
        this.usercreated = value;
    }

    /**
     * 获取userid属性的值。
     * 
     */
    public int getUSERID() {
        return userid;
    }

    /**
     * 设置userid属性的值。
     * 
     */
    public void setUSERID(int value) {
        this.userid = value;
    }

    /**
     * 获取userregip属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSERREGIP() {
        return userregip;
    }

    /**
     * 设置userregip属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSERREGIP(String value) {
        this.userregip = value;
    }

    /**
     * 获取cardsn属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCARDSN() {
        return cardsn;
    }

    /**
     * 设置cardsn属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCARDSN(String value) {
        this.cardsn = value;
    }

    /**
     * 获取userstudy属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSERSTUDY() {
        return userstudy;
    }

    /**
     * 设置userstudy属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSERSTUDY(String value) {
        this.userstudy = value;
    }

    /**
     * 获取usermethod属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSERMETHOD() {
        return usermethod;
    }

    /**
     * 设置usermethod属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSERMETHOD(String value) {
        this.usermethod = value;
    }

    /**
     * 获取rolerank属性的值。
     * 
     */
    public int getROLERANK() {
        return rolerank;
    }

    /**
     * 设置rolerank属性的值。
     * 
     */
    public void setROLERANK(int value) {
        this.rolerank = value;
    }

    /**
     * 获取userorder属性的值。
     * 
     */
    public int getUSERORDER() {
        return userorder;
    }

    /**
     * 设置userorder属性的值。
     * 
     */
    public void setUSERORDER(int value) {
        this.userorder = value;
    }

    /**
     * 获取isdbchk属性的值。
     * 
     */
    public int getISDBCHK() {
        return isdbchk;
    }

    /**
     * 设置isdbchk属性的值。
     * 
     */
    public void setISDBCHK(int value) {
        this.isdbchk = value;
    }

    /**
     * 获取userrole属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSERROLE() {
        return userrole;
    }

    /**
     * 设置userrole属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSERROLE(String value) {
        this.userrole = value;
    }

    /**
     * 获取usertype属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSERTYPE() {
        return usertype;
    }

    /**
     * 设置usertype属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSERTYPE(String value) {
        this.usertype = value;
    }

    /**
     * 获取dfkycard属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDFKYCARD() {
        return dfkycard;
    }

    /**
     * 设置dfkycard属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDFKYCARD(String value) {
        this.dfkycard = value;
    }

    /**
     * 获取selectString属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSelectString() {
        return selectString;
    }

    /**
     * 设置selectString属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSelectString(String value) {
        this.selectString = value;
    }

}
