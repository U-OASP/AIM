
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
 *         &lt;element name="InsertTaskTableResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "insertTaskTableResult"
})
@XmlRootElement(name = "InsertTaskTableResponse")
public class InsertTaskTableResponse {

    @XmlElement(name = "InsertTaskTableResult")
    protected boolean insertTaskTableResult;

    /**
     * ��ȡinsertTaskTableResult���Ե�ֵ��
     * 
     */
    public boolean isInsertTaskTableResult() {
        return insertTaskTableResult;
    }

    /**
     * ����insertTaskTableResult���Ե�ֵ��
     * 
     */
    public void setInsertTaskTableResult(boolean value) {
        this.insertTaskTableResult = value;
    }

}
