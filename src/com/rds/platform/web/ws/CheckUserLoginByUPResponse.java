
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
     * 获取checkUserLoginByUPResult属性的值。
     * 
     */
    public int getCheckUserLoginByUPResult() {
        return checkUserLoginByUPResult;
    }

    /**
     * 设置checkUserLoginByUPResult属性的值。
     * 
     */
    public void setCheckUserLoginByUPResult(int value) {
        this.checkUserLoginByUPResult = value;
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
