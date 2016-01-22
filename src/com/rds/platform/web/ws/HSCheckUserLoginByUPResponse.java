
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
     * 获取hsCheckUserLoginByUPResult属性的值。
     * 
     */
    public int getHSCheckUserLoginByUPResult() {
        return hsCheckUserLoginByUPResult;
    }

    /**
     * 设置hsCheckUserLoginByUPResult属性的值。
     * 
     */
    public void setHSCheckUserLoginByUPResult(int value) {
        this.hsCheckUserLoginByUPResult = value;
    }

    /**
     * 获取nUserID属性的值。
     * 
     */
    public int getNUserID() {
        return nUserID;
    }

    /**
     * 设置nUserID属性的值。
     * 
     */
    public void setNUserID(int value) {
        this.nUserID = value;
    }

    /**
     * 获取nStatus属性的值。
     * 
     */
    public int getNStatus() {
        return nStatus;
    }

    /**
     * 设置nStatus属性的值。
     * 
     */
    public void setNStatus(int value) {
        this.nStatus = value;
    }

}
