
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
 *         &lt;element name="Cluetype" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ClueID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "cluetype",
    "clueID"
})
@XmlRootElement(name = "GetTaskByClueID")
public class GetTaskByClueID {

    @XmlElement(name = "Cluetype")
    protected int cluetype;
    @XmlElement(name = "ClueID")
    protected String clueID;

    /**
     * 获取cluetype属性的值。
     * 
     */
    public int getCluetype() {
        return cluetype;
    }

    /**
     * 设置cluetype属性的值。
     * 
     */
    public void setCluetype(int value) {
        this.cluetype = value;
    }

    /**
     * 获取clueID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClueID() {
        return clueID;
    }

    /**
     * 设置clueID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClueID(String value) {
        this.clueID = value;
    }

}
