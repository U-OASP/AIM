
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
 *         &lt;element name="SetRightYWAppendResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "setRightYWAppendResult"
})
@XmlRootElement(name = "SetRightYWAppendResponse")
public class SetRightYWAppendResponse {

    @XmlElement(name = "SetRightYWAppendResult")
    protected boolean setRightYWAppendResult;

    /**
     * ��ȡsetRightYWAppendResult���Ե�ֵ��
     * 
     */
    public boolean isSetRightYWAppendResult() {
        return setRightYWAppendResult;
    }

    /**
     * ����setRightYWAppendResult���Ե�ֵ��
     * 
     */
    public void setSetRightYWAppendResult(boolean value) {
        this.setRightYWAppendResult = value;
    }

}
