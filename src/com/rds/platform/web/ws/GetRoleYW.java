
package com.rds.platform.web.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="intRoleYW" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "intRoleYW"
})
@XmlRootElement(name = "GetRoleYW")
public class GetRoleYW {

    protected int intRoleYW;

    /**
     * ��ȡintRoleYW���Ե�ֵ��
     * 
     */
    public int getIntRoleYW() {
        return intRoleYW;
    }

    /**
     * ����intRoleYW���Ե�ֵ��
     * 
     */
    public void setIntRoleYW(int value) {
        this.intRoleYW = value;
    }

}
