
package com.rds.platform.web.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡuserID1���Ե�ֵ��
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
     * ����userID1���Ե�ֵ��
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
     * ��ȡuserID2���Ե�ֵ��
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
     * ����userID2���Ե�ֵ��
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
     * ��ȡcaseid���Ե�ֵ��
     * 
     */
    public int getCaseid() {
        return caseid;
    }

    /**
     * ����caseid���Ե�ֵ��
     * 
     */
    public void setCaseid(int value) {
        this.caseid = value;
    }

    /**
     * ��ȡobjectid���Ե�ֵ��
     * 
     */
    public int getObjectid() {
        return objectid;
    }

    /**
     * ����objectid���Ե�ֵ��
     * 
     */
    public void setObjectid(int value) {
        this.objectid = value;
    }

    /**
     * ��ȡclueid���Ե�ֵ��
     * 
     */
    public int getClueid() {
        return clueid;
    }

    /**
     * ����clueid���Ե�ֵ��
     * 
     */
    public void setClueid(int value) {
        this.clueid = value;
    }

    /**
     * ��ȡassignkind���Ե�ֵ��
     * 
     */
    public int getAssignkind() {
        return assignkind;
    }

    /**
     * ����assignkind���Ե�ֵ��
     * 
     */
    public void setAssignkind(int value) {
        this.assignkind = value;
    }

}
