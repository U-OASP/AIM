
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
 *         &lt;element name="HS_GetLoginNumResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "hsGetLoginNumResult"
})
@XmlRootElement(name = "HS_GetLoginNumResponse")
public class HSGetLoginNumResponse {

    @XmlElement(name = "HS_GetLoginNumResult")
    protected int hsGetLoginNumResult;

    /**
     * 获取hsGetLoginNumResult属性的值。
     * 
     */
    public int getHSGetLoginNumResult() {
        return hsGetLoginNumResult;
    }

    /**
     * 设置hsGetLoginNumResult属性的值。
     * 
     */
    public void setHSGetLoginNumResult(int value) {
        this.hsGetLoginNumResult = value;
    }

}
