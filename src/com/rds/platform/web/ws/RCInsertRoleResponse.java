
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
 *         &lt;element name="RC_InsertRoleResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "rcInsertRoleResult"
})
@XmlRootElement(name = "RC_InsertRoleResponse")
public class RCInsertRoleResponse {

    @XmlElement(name = "RC_InsertRoleResult")
    protected boolean rcInsertRoleResult;

    /**
     * 获取rcInsertRoleResult属性的值。
     * 
     */
    public boolean isRCInsertRoleResult() {
        return rcInsertRoleResult;
    }

    /**
     * 设置rcInsertRoleResult属性的值。
     * 
     */
    public void setRCInsertRoleResult(boolean value) {
        this.rcInsertRoleResult = value;
    }

}
