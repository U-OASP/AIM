
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
 *         &lt;element name="DeleteClue601Result" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "deleteClue601Result"
})
@XmlRootElement(name = "DeleteClue601Response")
public class DeleteClue601Response {

    @XmlElement(name = "DeleteClue601Result")
    protected boolean deleteClue601Result;

    /**
     * 获取deleteClue601Result属性的值。
     * 
     */
    public boolean isDeleteClue601Result() {
        return deleteClue601Result;
    }

    /**
     * 设置deleteClue601Result属性的值。
     * 
     */
    public void setDeleteClue601Result(boolean value) {
        this.deleteClue601Result = value;
    }

}
