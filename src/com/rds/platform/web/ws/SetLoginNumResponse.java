
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
 *         &lt;element name="SetLoginNumResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "setLoginNumResult"
})
@XmlRootElement(name = "SetLoginNumResponse")
public class SetLoginNumResponse {

    @XmlElement(name = "SetLoginNumResult")
    protected int setLoginNumResult;

    /**
     * ��ȡsetLoginNumResult���Ե�ֵ��
     * 
     */
    public int getSetLoginNumResult() {
        return setLoginNumResult;
    }

    /**
     * ����setLoginNumResult���Ե�ֵ��
     * 
     */
    public void setSetLoginNumResult(int value) {
        this.setLoginNumResult = value;
    }

}
