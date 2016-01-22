
package com.rds.platform.web.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>RightXMLMode�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="RightXMLMode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ALLFile"/>
 *     &lt;enumeration value="ALLTable"/>
 *     &lt;enumeration value="ITEM"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RightXMLMode")
@XmlEnum
public enum RightXMLMode {

    @XmlEnumValue("ALLFile")
    ALL_FILE("ALLFile"),
    @XmlEnumValue("ALLTable")
    ALL_TABLE("ALLTable"),
    ITEM("ITEM");
    private final String value;

    RightXMLMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RightXMLMode fromValue(String v) {
        for (RightXMLMode c: RightXMLMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
