
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
 *         &lt;element name="HS_CheckUserLoginByUP2Result" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "hsCheckUserLoginByUP2Result",
    "nUserID",
    "nStatus"
})
@XmlRootElement(name = "HS_CheckUserLoginByUP2Response")
public class HSCheckUserLoginByUP2Response {

    @XmlElement(name = "HS_CheckUserLoginByUP2Result")
    protected int hsCheckUserLoginByUP2Result;
    protected int nUserID;
    protected int nStatus;

    /**
     * ��ȡhsCheckUserLoginByUP2Result���Ե�ֵ��
     * 
     */
    public int getHSCheckUserLoginByUP2Result() {
        return hsCheckUserLoginByUP2Result;
    }

    /**
     * ����hsCheckUserLoginByUP2Result���Ե�ֵ��
     * 
     */
    public void setHSCheckUserLoginByUP2Result(int value) {
        this.hsCheckUserLoginByUP2Result = value;
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
