
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
 *         &lt;element name="Insert_INITIATIVE_TASKResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "insertINITIATIVETASKResult"
})
@XmlRootElement(name = "Insert_INITIATIVE_TASKResponse")
public class InsertINITIATIVETASKResponse {

    @XmlElement(name = "Insert_INITIATIVE_TASKResult")
    protected boolean insertINITIATIVETASKResult;

    /**
     * ��ȡinsertINITIATIVETASKResult���Ե�ֵ��
     * 
     */
    public boolean isInsertINITIATIVETASKResult() {
        return insertINITIATIVETASKResult;
    }

    /**
     * ����insertINITIATIVETASKResult���Ե�ֵ��
     * 
     */
    public void setInsertINITIATIVETASKResult(boolean value) {
        this.insertINITIATIVETASKResult = value;
    }

}
