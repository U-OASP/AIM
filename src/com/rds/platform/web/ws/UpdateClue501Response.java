
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
 *         &lt;element name="UpdateClue501Result" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "updateClue501Result"
})
@XmlRootElement(name = "UpdateClue501Response")
public class UpdateClue501Response {

    @XmlElement(name = "UpdateClue501Result")
    protected boolean updateClue501Result;

    /**
     * 获取updateClue501Result属性的值。
     * 
     */
    public boolean isUpdateClue501Result() {
        return updateClue501Result;
    }

    /**
     * 设置updateClue501Result属性的值。
     * 
     */
    public void setUpdateClue501Result(boolean value) {
        this.updateClue501Result = value;
    }

}
