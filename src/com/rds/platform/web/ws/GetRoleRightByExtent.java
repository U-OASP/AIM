
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
 *         &lt;element name="RoleID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "roleID",
    "stratBit",
    "endbit"
})
@XmlRootElement(name = "GetRoleRightByExtent")
public class GetRoleRightByExtent {

    @XmlElement(name = "RoleID")
    protected String roleID;
    @XmlElement(name = "StratBit")
    protected int stratBit;
    @XmlElement(name = "Endbit")
    protected int endbit;

    /**
     * 获取roleID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoleID() {
        return roleID;
    }

    /**
     * 设置roleID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoleID(String value) {
        this.roleID = value;
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
