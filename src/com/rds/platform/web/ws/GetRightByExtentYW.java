
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
 *         &lt;element name="UserID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StratBit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Endbit" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "stratBit",
    "endbit"
})
@XmlRootElement(name = "GetRightByExtentYW")
public class GetRightByExtentYW {

    @XmlElement(name = "UserID")
    protected String userID;
    @XmlElement(name = "StratBit")
    protected int stratBit;
    @XmlElement(name = "Endbit")
    protected int endbit;

    /**
     * 获取userID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserID() {
        return userID;
    }

    /**
     * 设置userID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserID(String value) {
        this.userID = value;
    }

    /**
     * 获取stratBit属性的值。
     * 
     */
    public int getStratBit() {
        return stratBit;
    }

    /**
     * 设置stratBit属性的值。
     * 
     */
    public void setStratBit(int value) {
        this.stratBit = value;
    }

    /**
     * 获取endbit属性的值。
     * 
     */
    public int getEndbit() {
        return endbit;
    }

    /**
     * 设置endbit属性的值。
     * 
     */
    public void setEndbit(int value) {
        this.endbit = value;
    }

}
