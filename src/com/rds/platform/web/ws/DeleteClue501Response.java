
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
 *         &lt;element name="DeleteClue501Result" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "deleteClue501Result"
})
@XmlRootElement(name = "DeleteClue501Response")
public class DeleteClue501Response {

    @XmlElement(name = "DeleteClue501Result")
    protected boolean deleteClue501Result;

    /**
     * ��ȡdeleteClue501Result���Ե�ֵ��
     * 
     */
    public boolean isDeleteClue501Result() {
        return deleteClue501Result;
    }

    /**
     * ����deleteClue501Result���Ե�ֵ��
     * 
     */
    public void setDeleteClue501Result(boolean value) {
        this.deleteClue501Result = value;
    }

}
