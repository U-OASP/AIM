
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
 *         &lt;element name="UL_DeleteUserResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "ulDeleteUserResult"
})
@XmlRootElement(name = "UL_DeleteUserResponse")
public class ULDeleteUserResponse {

    @XmlElement(name = "UL_DeleteUserResult")
    protected boolean ulDeleteUserResult;

    /**
     * ��ȡulDeleteUserResult���Ե�ֵ��
     * 
     */
    public boolean isULDeleteUserResult() {
        return ulDeleteUserResult;
    }

    /**
     * ����ulDeleteUserResult���Ե�ֵ��
     * 
     */
    public void setULDeleteUserResult(boolean value) {
        this.ulDeleteUserResult = value;
    }

}
