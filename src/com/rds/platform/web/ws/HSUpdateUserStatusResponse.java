
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
 *         &lt;element name="HS_UpdateUserStatusResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "hsUpdateUserStatusResult"
})
@XmlRootElement(name = "HS_UpdateUserStatusResponse")
public class HSUpdateUserStatusResponse {

    @XmlElement(name = "HS_UpdateUserStatusResult")
    protected int hsUpdateUserStatusResult;

    /**
     * ��ȡhsUpdateUserStatusResult���Ե�ֵ��
     * 
     */
    public int getHSUpdateUserStatusResult() {
        return hsUpdateUserStatusResult;
    }

    /**
     * ����hsUpdateUserStatusResult���Ե�ֵ��
     * 
     */
    public void setHSUpdateUserStatusResult(int value) {
        this.hsUpdateUserStatusResult = value;
    }

}
