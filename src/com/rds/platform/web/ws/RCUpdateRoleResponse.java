
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
 *         &lt;element name="RC_UpdateRoleResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "rcUpdateRoleResult"
})
@XmlRootElement(name = "RC_UpdateRoleResponse")
public class RCUpdateRoleResponse {

    @XmlElement(name = "RC_UpdateRoleResult")
    protected boolean rcUpdateRoleResult;

    /**
     * 获取rcUpdateRoleResult属性的值。
     * 
     */
    public boolean isRCUpdateRoleResult() {
        return rcUpdateRoleResult;
    }

    /**
     * 设置rcUpdateRoleResult属性的值。
     * 
     */
    public void setRCUpdateRoleResult(boolean value) {
        this.rcUpdateRoleResult = value;
    }

}
