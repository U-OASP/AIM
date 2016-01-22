
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
 *         &lt;element name="UserID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="newPass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "userID",
    "newPass"
})
@XmlRootElement(name = "UR_UpdateUserPass")
public class URUpdateUserPass {

    @XmlElement(name = "UserID")
    protected int userID;
    protected String newPass;

    /**
     * 获取userID属性的值。
     * 
     */
    public int getUserID() {
        return userID;
    }

    /**
     * 设置userID属性的值。
     * 
     */
    public void setUserID(int value) {
        this.userID = value;
    }

    /**
     * 获取newPass属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewPass() {
        return newPass;
    }

    /**
     * 设置newPass属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewPass(String value) {
        this.newPass = value;
    }

}
