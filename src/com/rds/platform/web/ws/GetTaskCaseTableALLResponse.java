
package com.rds.platform.web.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetTaskCaseTableALLResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "getTaskCaseTableALLResult"
})
@XmlRootElement(name = "GetTaskCaseTableALLResponse")
public class GetTaskCaseTableALLResponse {

    @XmlElement(name = "GetTaskCaseTableALLResult")
    protected String getTaskCaseTableALLResult;

    /**
     * ��ȡgetTaskCaseTableALLResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetTaskCaseTableALLResult() {
        return getTaskCaseTableALLResult;
    }

    /**
     * ����getTaskCaseTableALLResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetTaskCaseTableALLResult(String value) {
        this.getTaskCaseTableALLResult = value;
    }

}
