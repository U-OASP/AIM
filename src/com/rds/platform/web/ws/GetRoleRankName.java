
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
 *         &lt;element name="intRoleRank" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "intRoleRank"
})
@XmlRootElement(name = "GetRoleRankName")
public class GetRoleRankName {

    protected int intRoleRank;

    /**
     * ��ȡintRoleRank���Ե�ֵ��
     * 
     */
    public int getIntRoleRank() {
        return intRoleRank;
    }

    /**
     * ����intRoleRank���Ե�ֵ��
     * 
     */
    public void setIntRoleRank(int value) {
        this.intRoleRank = value;
    }

}
