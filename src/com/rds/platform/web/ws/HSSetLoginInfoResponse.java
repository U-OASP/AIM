
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
 *         &lt;element name="HS_SetLoginInfoResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "hsSetLoginInfoResult"
})
@XmlRootElement(name = "HS_SetLoginInfoResponse")
public class HSSetLoginInfoResponse {

    @XmlElement(name = "HS_SetLoginInfoResult")
    protected int hsSetLoginInfoResult;

    /**
     * ��ȡhsSetLoginInfoResult���Ե�ֵ��
     * 
     */
    public int getHSSetLoginInfoResult() {
        return hsSetLoginInfoResult;
    }

    /**
     * ����hsSetLoginInfoResult���Ե�ֵ��
     * 
     */
    public void setHSSetLoginInfoResult(int value) {
        this.hsSetLoginInfoResult = value;
    }

}
