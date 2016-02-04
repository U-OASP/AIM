
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
     * 获取hsCheckUserLoginByUP2Result属性的值。
     * 
     */
    public int getHSCheckUserLoginByUP2Result() {
        return hsCheckUserLoginByUP2Result;
    }

    /**
     * 设置hsCheckUserLoginByUP2Result属性的值。
     * 
     */
    public void setHSCheckUserLoginByUP2Result(int value) {
        this.hsCheckUserLoginByUP2Result = value;
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
