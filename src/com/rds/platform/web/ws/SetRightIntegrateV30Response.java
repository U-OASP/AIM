
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
 *         &lt;element name="SetRightIntegrateV30Result" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "setRightIntegrateV30Result"
})
@XmlRootElement(name = "SetRightIntegrateV30Response")
public class SetRightIntegrateV30Response {

    @XmlElement(name = "SetRightIntegrateV30Result")
    protected boolean setRightIntegrateV30Result;

    /**
     * ��ȡsetRightIntegrateV30Result���Ե�ֵ��
     * 
     */
    public boolean isSetRightIntegrateV30Result() {
        return setRightIntegrateV30Result;
    }

    /**
     * ����setRightIntegrateV30Result���Ե�ֵ��
     * 
     */
    public void setSetRightIntegrateV30Result(boolean value) {
        this.setRightIntegrateV30Result = value;
    }

}
