
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
 *         &lt;element name="InsertTaskTableResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "insertTaskTableResult"
})
@XmlRootElement(name = "InsertTaskTableResponse")
public class InsertTaskTableResponse {

    @XmlElement(name = "InsertTaskTableResult")
    protected boolean insertTaskTableResult;

    /**
     * 获取insertTaskTableResult属性的值。
     * 
     */
    public boolean isInsertTaskTableResult() {
        return insertTaskTableResult;
    }

    /**
     * 设置insertTaskTableResult属性的值。
     * 
     */
    public void setInsertTaskTableResult(boolean value) {
        this.insertTaskTableResult = value;
    }

}
