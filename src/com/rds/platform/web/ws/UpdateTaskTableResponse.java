
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
 *         &lt;element name="UpdateTaskTableResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "updateTaskTableResult"
})
@XmlRootElement(name = "UpdateTaskTableResponse")
public class UpdateTaskTableResponse {

    @XmlElement(name = "UpdateTaskTableResult")
    protected boolean updateTaskTableResult;

    /**
     * ��ȡupdateTaskTableResult���Ե�ֵ��
     * 
     */
    public boolean isUpdateTaskTableResult() {
        return updateTaskTableResult;
    }

    /**
     * ����updateTaskTableResult���Ե�ֵ��
     * 
     */
    public void setUpdateTaskTableResult(boolean value) {
        this.updateTaskTableResult = value;
    }

}
