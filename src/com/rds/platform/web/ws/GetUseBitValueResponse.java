
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
 *         &lt;element name="GetUseBitValueResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "getUseBitValueResult"
})
@XmlRootElement(name = "GetUseBitValueResponse")
public class GetUseBitValueResponse {

    @XmlElement(name = "GetUseBitValueResult")
    protected int getUseBitValueResult;

    /**
     * ��ȡgetUseBitValueResult���Ե�ֵ��
     * 
     */
    public int getGetUseBitValueResult() {
        return getUseBitValueResult;
    }

    /**
     * ����getUseBitValueResult���Ե�ֵ��
     * 
     */
    public void setGetUseBitValueResult(int value) {
        this.getUseBitValueResult = value;
    }

}
