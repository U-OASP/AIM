
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
 *         &lt;element name="GetTaskCaseTableExtentResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "getTaskCaseTableExtentResult"
})
@XmlRootElement(name = "GetTaskCaseTableExtentResponse")
public class GetTaskCaseTableExtentResponse {

    @XmlElement(name = "GetTaskCaseTableExtentResult")
    protected String getTaskCaseTableExtentResult;

    /**
     * ��ȡgetTaskCaseTableExtentResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetTaskCaseTableExtentResult() {
        return getTaskCaseTableExtentResult;
    }

    /**
     * ����getTaskCaseTableExtentResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetTaskCaseTableExtentResult(String value) {
        this.getTaskCaseTableExtentResult = value;
    }

}
