
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
 *         &lt;element name="Cluetype" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ClueID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "cluetype",
    "clueID"
})
@XmlRootElement(name = "GetTaskByClueID")
public class GetTaskByClueID {

    @XmlElement(name = "Cluetype")
    protected int cluetype;
    @XmlElement(name = "ClueID")
    protected String clueID;

    /**
     * ��ȡcluetype���Ե�ֵ��
     * 
     */
    public int getCluetype() {
        return cluetype;
    }

    /**
     * ����cluetype���Ե�ֵ��
     * 
     */
    public void setCluetype(int value) {
        this.cluetype = value;
    }

    /**
     * ��ȡclueID���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClueID() {
        return clueID;
    }

    /**
     * ����clueID���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClueID(String value) {
        this.clueID = value;
    }

}
