
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
 *         &lt;element name="Clue_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Levels" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "clueID",
    "levels"
})
@XmlRootElement(name = "UpdateClue501")
public class UpdateClue501 {

    @XmlElement(name = "Clue_ID")
    protected String clueID;
    @XmlElement(name = "Levels")
    protected int levels;

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

    /**
     * ��ȡlevels���Ե�ֵ��
     * 
     */
    public int getLevels() {
        return levels;
    }

    /**
     * ����levels���Ե�ֵ��
     * 
     */
    public void setLevels(int value) {
        this.levels = value;
    }

}
