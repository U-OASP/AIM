
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
 *         &lt;element name="RC_InsertRoleResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "rcInsertRoleResult"
})
@XmlRootElement(name = "RC_InsertRoleResponse")
public class RCInsertRoleResponse {

    @XmlElement(name = "RC_InsertRoleResult")
    protected boolean rcInsertRoleResult;

    /**
     * ��ȡrcInsertRoleResult���Ե�ֵ��
     * 
     */
    public boolean isRCInsertRoleResult() {
        return rcInsertRoleResult;
    }

    /**
     * ����rcInsertRoleResult���Ե�ֵ��
     * 
     */
    public void setRCInsertRoleResult(boolean value) {
        this.rcInsertRoleResult = value;
    }

}
