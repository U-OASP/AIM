
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
 *         &lt;element name="SetLoginInfoResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "setLoginInfoResult"
})
@XmlRootElement(name = "SetLoginInfoResponse")
public class SetLoginInfoResponse {

    @XmlElement(name = "SetLoginInfoResult")
    protected int setLoginInfoResult;

    /**
     * 获取setLoginInfoResult属性的值。
     * 
     */
    public int getSetLoginInfoResult() {
        return setLoginInfoResult;
    }

    /**
     * 设置setLoginInfoResult属性的值。
     * 
     */
    public void setSetLoginInfoResult(int value) {
        this.setLoginInfoResult = value;
    }

}
