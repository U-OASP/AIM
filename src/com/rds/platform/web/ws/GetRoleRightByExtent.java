
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
     * ��ȡroleID���Ե�ֵ��
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
     * ����roleID���Ե�ֵ��
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
     * ��ȡstratBit���Ե�ֵ��
     * 
     */
    public int getStratBit() {
        return stratBit;
    }

    /**
     * ����stratBit���Ե�ֵ��
     * 
     */
    public void setStratBit(int value) {
        this.stratBit = value;
    }

    /**
     * ��ȡendbit���Ե�ֵ��
     * 
     */
    public int getEndbit() {
        return endbit;
    }

    /**
     * ����endbit���Ե�ֵ��
     * 
     */
    public void setEndbit(int value) {
        this.endbit = value;
    }

}
