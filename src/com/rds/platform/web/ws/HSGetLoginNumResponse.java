
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
 *         &lt;element name="HS_GetLoginNumResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "hsGetLoginNumResult"
})
@XmlRootElement(name = "HS_GetLoginNumResponse")
public class HSGetLoginNumResponse {

    @XmlElement(name = "HS_GetLoginNumResult")
    protected int hsGetLoginNumResult;

    /**
     * ��ȡhsGetLoginNumResult���Ե�ֵ��
     * 
     */
    public int getHSGetLoginNumResult() {
        return hsGetLoginNumResult;
    }

    /**
     * ����hsGetLoginNumResult���Ե�ֵ��
     * 
     */
    public void setHSGetLoginNumResult(int value) {
        this.hsGetLoginNumResult = value;
    }

}
