
package com.rds.platform.web.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="strUID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strUCASE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nUserID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nStatus" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "strUID",
    "strUCASE",
    "nUserID",
    "nStatus"
})
@XmlRootElement(name = "CheckUserLoginNotCrypt")
public class CheckUserLoginNotCrypt {

    protected String strUID;
    protected String strUCASE;
    protected int nUserID;
    protected int nStatus;

    /**
     * ��ȡstrUID���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrUID() {
        return strUID;
    }

    /**
     * ����strUID���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrUID(String value) {
        this.strUID = value;
    }

    /**
     * ��ȡstrUCASE���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrUCASE() {
        return strUCASE;
    }

    /**
     * ����strUCASE���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrUCASE(String value) {
        this.strUCASE = value;
    }

    /**
     * ��ȡnUserID���Ե�ֵ��
     * 
     */
    public int getNUserID() {
        return nUserID;
    }

    /**
     * ����nUserID���Ե�ֵ��
     * 
     */
    public void setNUserID(int value) {
        this.nUserID = value;
    }

    /**
     * ��ȡnStatus���Ե�ֵ��
     * 
     */
    public int getNStatus() {
        return nStatus;
    }

    /**
     * ����nStatus���Ե�ֵ��
     * 
     */
    public void setNStatus(int value) {
        this.nStatus = value;
    }

}
