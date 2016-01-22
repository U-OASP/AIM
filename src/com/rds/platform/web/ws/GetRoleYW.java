
package com.rds.platform.web.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="intRoleYW" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "intRoleYW"
})
@XmlRootElement(name = "GetRoleYW")
public class GetRoleYW {

    protected int intRoleYW;

    /**
     * 获取intRoleYW属性的值。
     * 
     */
    public int getIntRoleYW() {
        return intRoleYW;
    }

    /**
     * 设置intRoleYW属性的值。
     * 
     */
    public void setIntRoleYW(int value) {
        this.intRoleYW = value;
    }

}
