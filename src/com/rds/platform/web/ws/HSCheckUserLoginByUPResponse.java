
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
 *         &lt;element name="HS_CheckUserLoginByUPResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "hsCheckUserLoginByUPResult",
    "nUserID",
    "nStatus"
})
@XmlRootElement(name = "HS_CheckUserLoginByUPResponse")
public class HSCheckUserLoginByUPResponse {

    @XmlElement(name = "HS_CheckUserLoginByUPResult")
    protected int hsCheckUserLoginByUPResult;
    protected int nUserID;
    protected int nStatus;

    /**
     * ��ȡhsCheckUserLoginByUPResult���Ե�ֵ��
     * 
     */
    public int getHSCheckUserLoginByUPResult() {
        return hsCheckUserLoginByUPResult;
    }

    /**
     * ����hsCheckUserLoginByUPResult���Ե�ֵ��
     * 
     */
    public void setHSCheckUserLoginByUPResult(int value) {
        this.hsCheckUserLoginByUPResult = value;
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
