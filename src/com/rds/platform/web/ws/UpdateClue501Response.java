
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
 *         &lt;element name="UpdateClue501Result" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "updateClue501Result"
})
@XmlRootElement(name = "UpdateClue501Response")
public class UpdateClue501Response {

    @XmlElement(name = "UpdateClue501Result")
    protected boolean updateClue501Result;

    /**
     * ��ȡupdateClue501Result���Ե�ֵ��
     * 
     */
    public boolean isUpdateClue501Result() {
        return updateClue501Result;
    }

    /**
     * ����updateClue501Result���Ե�ֵ��
     * 
     */
    public void setUpdateClue501Result(boolean value) {
        this.updateClue501Result = value;
    }

}
