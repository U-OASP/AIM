
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
 *         &lt;element name="SetRightRoleRight_YWResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "setRightRoleRightYWResult"
})
@XmlRootElement(name = "SetRightRoleRight_YWResponse")
public class SetRightRoleRightYWResponse {

    @XmlElement(name = "SetRightRoleRight_YWResult")
    protected boolean setRightRoleRightYWResult;

    /**
     * ��ȡsetRightRoleRightYWResult���Ե�ֵ��
     * 
     */
    public boolean isSetRightRoleRightYWResult() {
        return setRightRoleRightYWResult;
    }

    /**
     * ����setRightRoleRightYWResult���Ե�ֵ��
     * 
     */
    public void setSetRightRoleRightYWResult(boolean value) {
        this.setRightRoleRightYWResult = value;
    }

}
