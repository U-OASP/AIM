
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
 *         &lt;element name="UR_UpdateUserWithCodeResult" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
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
    "urUpdateUserWithCodeResult"
})
@XmlRootElement(name = "UR_UpdateUserWithCodeResponse")
public class URUpdateUserWithCodeResponse {

    @XmlElement(name = "UR_UpdateUserWithCodeResult")
    protected Object urUpdateUserWithCodeResult;

    /**
     * ��ȡurUpdateUserWithCodeResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getURUpdateUserWithCodeResult() {
        return urUpdateUserWithCodeResult;
    }

    /**
     * ����urUpdateUserWithCodeResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setURUpdateUserWithCodeResult(Object value) {
        this.urUpdateUserWithCodeResult = value;
    }

}
