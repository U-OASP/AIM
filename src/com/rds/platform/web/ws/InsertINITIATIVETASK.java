
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
 *         &lt;element name="EMP_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GROUP_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GATHER_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "empid",
    "groupid",
    "gathertype"
})
@XmlRootElement(name = "Insert_INITIATIVE_TASK")
public class InsertINITIATIVETASK {

    @XmlElement(name = "EMP_ID")
    protected String empid;
    @XmlElement(name = "GROUP_ID")
    protected String groupid;
    @XmlElement(name = "GATHER_TYPE")
    protected String gathertype;

    /**
     * 获取empid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEMPID() {
        return empid;
    }

    /**
     * 设置empid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEMPID(String value) {
        this.empid = value;
    }

    /**
     * 获取groupid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGROUPID() {
        return groupid;
    }

    /**
     * 设置groupid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGROUPID(String value) {
        this.groupid = value;
    }

    /**
     * 获取gathertype属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGATHERTYPE() {
        return gathertype;
    }

    /**
     * 设置gathertype属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGATHERTYPE(String value) {
        this.gathertype = value;
    }

}
