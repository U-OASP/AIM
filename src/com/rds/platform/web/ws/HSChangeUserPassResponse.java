
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
 *         &lt;element name="HS_ChangeUserPassResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "hsChangeUserPassResult"
})
@XmlRootElement(name = "HS_ChangeUserPassResponse")
public class HSChangeUserPassResponse {

    @XmlElement(name = "HS_ChangeUserPassResult")
    protected int hsChangeUserPassResult;

    /**
     * ��ȡhsChangeUserPassResult���Ե�ֵ��
     * 
     */
    public int getHSChangeUserPassResult() {
        return hsChangeUserPassResult;
    }

    /**
     * ����hsChangeUserPassResult���Ե�ֵ��
     * 
     */
    public void setHSChangeUserPassResult(int value) {
        this.hsChangeUserPassResult = value;
    }

}
