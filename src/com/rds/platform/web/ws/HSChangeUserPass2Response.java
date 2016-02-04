
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
 *         &lt;element name="HS_ChangeUserPass2Result" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "hsChangeUserPass2Result"
})
@XmlRootElement(name = "HS_ChangeUserPass2Response")
public class HSChangeUserPass2Response {

    @XmlElement(name = "HS_ChangeUserPass2Result")
    protected int hsChangeUserPass2Result;

    /**
     * 获取hsChangeUserPass2Result属性的值。
     * 
     */
    public int getHSChangeUserPass2Result() {
        return hsChangeUserPass2Result;
    }

    /**
     * 设置hsChangeUserPass2Result属性的值。
     * 
     */
    public void setHSChangeUserPass2Result(int value) {
        this.hsChangeUserPass2Result = value;
    }

}
