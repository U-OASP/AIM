
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
 *         &lt;element name="CheckUserLoginByUPResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "checkUserLoginByUPResult",
    "nUserID",
    "nStatus"
})
@XmlRootElement(name = "CheckUserLoginByUPResponse")
public class CheckUserLoginByUPResponse {

    @XmlElement(name = "CheckUserLoginByUPResult")
    protected int checkUserLoginByUPResult;
    protected int nUserID;
    protected int nStatus;

    /**
     * ��ȡcheckUserLoginByUPResult���Ե�ֵ��
     * 
     */
    public int getCheckUserLoginByUPResult() {
        return checkUserLoginByUPResult;
    }

    /**
     * ����checkUserLoginByUPResult���Ե�ֵ��
     * 
     */
    public void setCheckUserLoginByUPResult(int value) {
        this.checkUserLoginByUPResult = value;
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
