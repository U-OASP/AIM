
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
 *         &lt;element name="DeleteClue701Result" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "deleteClue701Result"
})
@XmlRootElement(name = "DeleteClue701Response")
public class DeleteClue701Response {

    @XmlElement(name = "DeleteClue701Result")
    protected boolean deleteClue701Result;

    /**
     * ��ȡdeleteClue701Result���Ե�ֵ��
     * 
     */
    public boolean isDeleteClue701Result() {
        return deleteClue701Result;
    }

    /**
     * ����deleteClue701Result���Ե�ֵ��
     * 
     */
    public void setDeleteClue701Result(boolean value) {
        this.deleteClue701Result = value;
    }

}
