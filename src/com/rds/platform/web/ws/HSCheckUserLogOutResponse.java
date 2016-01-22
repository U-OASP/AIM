
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
 *         &lt;element name="HS_CheckUserLogOutResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "hsCheckUserLogOutResult"
})
@XmlRootElement(name = "HS_CheckUserLogOutResponse")
public class HSCheckUserLogOutResponse {

    @XmlElement(name = "HS_CheckUserLogOutResult")
    protected int hsCheckUserLogOutResult;

    /**
     * 获取hsCheckUserLogOutResult属性的值。
     * 
     */
    public int getHSCheckUserLogOutResult() {
        return hsCheckUserLogOutResult;
    }

    /**
     * 设置hsCheckUserLogOutResult属性的值。
     * 
     */
    public void setHSCheckUserLogOutResult(int value) {
        this.hsCheckUserLogOutResult = value;
    }

}
