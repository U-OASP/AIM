
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
 *         &lt;element name="ULA_InsertLinkResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "ulaInsertLinkResult"
})
@XmlRootElement(name = "ULA_InsertLinkResponse")
public class ULAInsertLinkResponse {

    @XmlElement(name = "ULA_InsertLinkResult")
    protected boolean ulaInsertLinkResult;

    /**
     * ��ȡulaInsertLinkResult���Ե�ֵ��
     * 
     */
    public boolean isULAInsertLinkResult() {
        return ulaInsertLinkResult;
    }

    /**
     * ����ulaInsertLinkResult���Ե�ֵ��
     * 
     */
    public void setULAInsertLinkResult(boolean value) {
        this.ulaInsertLinkResult = value;
    }

}
