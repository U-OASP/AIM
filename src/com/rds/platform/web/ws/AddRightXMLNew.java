
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
 *         &lt;element name="FartherModuleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FartherModuleCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ModuleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SubModuleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "fartherModuleName",
    "fartherModuleCode",
    "moduleName",
    "subModuleName"
})
@XmlRootElement(name = "Add_RightXML_New")
public class AddRightXMLNew {

    @XmlElement(name = "FartherModuleName")
    protected String fartherModuleName;
    @XmlElement(name = "FartherModuleCode")
    protected String fartherModuleCode;
    @XmlElement(name = "ModuleName")
    protected String moduleName;
    @XmlElement(name = "SubModuleName")
    protected String subModuleName;

    /**
     * 获取fartherModuleName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFartherModuleName() {
        return fartherModuleName;
    }

    /**
     * 设置fartherModuleName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFartherModuleName(String value) {
        this.fartherModuleName = value;
    }

    /**
     * 获取fartherModuleCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFartherModuleCode() {
        return fartherModuleCode;
    }

    /**
     * 设置fartherModuleCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFartherModuleCode(String value) {
        this.fartherModuleCode = value;
    }

    /**
     * 获取moduleName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * 设置moduleName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModuleName(String value) {
        this.moduleName = value;
    }

    /**
     * 获取subModuleName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubModuleName() {
        return subModuleName;
    }

    /**
     * 设置subModuleName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubModuleName(String value) {
        this.subModuleName = value;
    }

}
