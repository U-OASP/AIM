
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
 *         &lt;element name="DeleteClue601Result" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "deleteClue601Result"
})
@XmlRootElement(name = "DeleteClue601Response")
public class DeleteClue601Response {

    @XmlElement(name = "DeleteClue601Result")
    protected boolean deleteClue601Result;

    /**
     * ��ȡdeleteClue601Result���Ե�ֵ��
     * 
     */
    public boolean isDeleteClue601Result() {
        return deleteClue601Result;
    }

    /**
     * ����deleteClue601Result���Ե�ֵ��
     * 
     */
    public void setDeleteClue601Result(boolean value) {
        this.deleteClue601Result = value;
    }

}
