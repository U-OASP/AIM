
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
 *         &lt;element name="SendDepartmentToEMContractResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "sendDepartmentToEMContractResult"
})
@XmlRootElement(name = "SendDepartmentToEMContractResponse")
public class SendDepartmentToEMContractResponse {

    @XmlElement(name = "SendDepartmentToEMContractResult")
    protected String sendDepartmentToEMContractResult;

    /**
     * 获取sendDepartmentToEMContractResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSendDepartmentToEMContractResult() {
        return sendDepartmentToEMContractResult;
    }

    /**
     * 设置sendDepartmentToEMContractResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSendDepartmentToEMContractResult(String value) {
        this.sendDepartmentToEMContractResult = value;
    }

}
