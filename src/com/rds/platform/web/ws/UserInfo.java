
package com.rds.platform.web.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>UserInfo complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡdeptname���Ե�ֵ��
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
     * ����deptname���Ե�ֵ��
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
     * ��ȡbirthday���Ե�ֵ��
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
     * ����birthday���Ե�ֵ��
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
     * ��ȡdepartmentid���Ե�ֵ��
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
     * ����departmentid���Ե�ֵ��
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
     * ��ȡloginname���Ե�ֵ��
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
     * ����loginname���Ե�ֵ��
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
     * ��ȡloginmethod���Ե�ֵ��
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
     * ����loginmethod���Ե�ֵ��
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
     * ��ȡmailaddress���Ե�ֵ��
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
     * ����mailaddress���Ե�ֵ��
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
     * ��ȡparentid���Ե�ֵ��
     * 
     */
    public int getPARENTID() {
        return parentid;
    }

    /**
     * ����parentid���Ե�ֵ��
     * 
     */
    public void setPARENTID(int value) {
        this.parentid = value;
    }

    /**
     * ��ȡrank���Ե�ֵ��
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
     * ����rank���Ե�ֵ��
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
     * ��ȡremark���Ե�ֵ��
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
     * ����remark���Ե�ֵ��
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
     * ��ȡsex���Ե�ֵ��
     * 
     */
    public int getSEX() {
        return sex;
    }

    /**
     * ����sex���Ե�ֵ��
     * 
     */
    public void setSEX(int value) {
        this.sex = value;
    }

    /**
     * ��ȡstatus���Ե�ֵ��
     * 
     */
    public int getSTATUS() {
        return status;
    }

    /**
     * ����status���Ե�ֵ��
     * 
     */
    public void setSTATUS(int value) {
        this.status = value;
    }

    /**
     * ��ȡusername���Ե�ֵ��
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
     * ����username���Ե�ֵ��
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
     * ��ȡuserpath���Ե�ֵ��
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
     * ����userpath���Ե�ֵ��
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
     * ��ȡusercreated���Ե�ֵ��
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
     * ����usercreated���Ե�ֵ��
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
     * ��ȡuserid���Ե�ֵ��
     * 
     */
    public int getUSERID() {
        return userid;
    }

    /**
     * ����userid���Ե�ֵ��
     * 
     */
    public void setUSERID(int value) {
        this.userid = value;
    }

    /**
     * ��ȡuserregip���Ե�ֵ��
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
     * ����userregip���Ե�ֵ��
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
     * ��ȡcardsn���Ե�ֵ��
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
     * ����cardsn���Ե�ֵ��
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
     * ��ȡuserstudy���Ե�ֵ��
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
     * ����userstudy���Ե�ֵ��
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
     * ��ȡusermethod���Ե�ֵ��
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
     * ����usermethod���Ե�ֵ��
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
     * ��ȡrolerank���Ե�ֵ��
     * 
     */
    public int getROLERANK() {
        return rolerank;
    }

    /**
     * ����rolerank���Ե�ֵ��
     * 
     */
    public void setROLERANK(int value) {
        this.rolerank = value;
    }

    /**
     * ��ȡuserorder���Ե�ֵ��
     * 
     */
    public int getUSERORDER() {
        return userorder;
    }

    /**
     * ����userorder���Ե�ֵ��
     * 
     */
    public void setUSERORDER(int value) {
        this.userorder = value;
    }

    /**
     * ��ȡisdbchk���Ե�ֵ��
     * 
     */
    public int getISDBCHK() {
        return isdbchk;
    }

    /**
     * ����isdbchk���Ե�ֵ��
     * 
     */
    public void setISDBCHK(int value) {
        this.isdbchk = value;
    }

    /**
     * ��ȡuserrole���Ե�ֵ��
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
     * ����userrole���Ե�ֵ��
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
     * ��ȡusertype���Ե�ֵ��
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
     * ����usertype���Ե�ֵ��
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
     * ��ȡdfkycard���Ե�ֵ��
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
     * ����dfkycard���Ե�ֵ��
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
     * ��ȡselectString���Ե�ֵ��
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
     * ����selectString���Ե�ֵ��
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
