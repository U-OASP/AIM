
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
 *         &lt;element name="DeleteTaskActionResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "deleteTaskActionResult"
})
@XmlRootElement(name = "DeleteTaskActionResponse")
public class DeleteTaskActionResponse {

    @XmlElement(name = "DeleteTaskActionResult")
    protected boolean deleteTaskActionResult;

    /**
     * ��ȡdeleteTaskActionResult���Ե�ֵ��
     * 
     */
    public boolean isDeleteTaskActionResult() {
        return deleteTaskActionResult;
    }

    /**
     * ����deleteTaskActionResult���Ե�ֵ��
     * 
     */
    public void setDeleteTaskActionResult(boolean value) {
        this.deleteTaskActionResult = value;
    }

}
