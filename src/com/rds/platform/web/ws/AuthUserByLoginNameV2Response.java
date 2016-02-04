
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
 *         &lt;element name="AuthUserByLoginNameV2Result" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "authUserByLoginNameV2Result"
})
@XmlRootElement(name = "AuthUserByLoginNameV2Response")
public class AuthUserByLoginNameV2Response {

    @XmlElement(name = "AuthUserByLoginNameV2Result")
    protected int authUserByLoginNameV2Result;

    /**
     * 获取authUserByLoginNameV2Result属性的值。
     * 
     */
    public int getAuthUserByLoginNameV2Result() {
        return authUserByLoginNameV2Result;
    }

    /**
     * 设置authUserByLoginNameV2Result属性的值。
     * 
     */
    public void setAuthUserByLoginNameV2Result(int value) {
        this.authUserByLoginNameV2Result = value;
    }

}
