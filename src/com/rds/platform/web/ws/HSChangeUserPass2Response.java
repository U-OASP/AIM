
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
 *         &lt;element name="HS_ChangeUserPass2Result" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "hsChangeUserPass2Result"
})
@XmlRootElement(name = "HS_ChangeUserPass2Response")
public class HSChangeUserPass2Response {

    @XmlElement(name = "HS_ChangeUserPass2Result")
    protected int hsChangeUserPass2Result;

    /**
     * ��ȡhsChangeUserPass2Result���Ե�ֵ��
     * 
     */
    public int getHSChangeUserPass2Result() {
        return hsChangeUserPass2Result;
    }

    /**
     * ����hsChangeUserPass2Result���Ե�ֵ��
     * 
     */
    public void setHSChangeUserPass2Result(int value) {
        this.hsChangeUserPass2Result = value;
    }

}
