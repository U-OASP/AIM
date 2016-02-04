
package com.rds.platform.web.itsmws;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.3
 * 2015-12-16T15:46:08.437+08:00
 * Generated source version: 3.1.3
 * 
 */
public final class OrdersServices_OrdersServicesImplPort_Client {

    private static final QName SERVICE_NAME = new QName("http://www.chinawiserv.com/onecenter", "OrdersServicesImplService");

    private OrdersServices_OrdersServicesImplPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = OrdersServicesImplService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        OrdersServicesImplService ss = new OrdersServicesImplService(wsdlURL, SERVICE_NAME);
        OrdersServices port = ss.getOrdersServicesImplPort();  
        
        {
        System.out.println("Invoking publishWorkOrder...");
        java.lang.String _publishWorkOrder_arg0 = "";
        java.lang.String _publishWorkOrder__return = port.publishWorkOrder(_publishWorkOrder_arg0);
        System.out.println("publishWorkOrder.result=" + _publishWorkOrder__return);


        }
        {
        System.out.println("Invoking getWorkOrderAttachment...");
        java.lang.String _getWorkOrderAttachment_arg0 = "";
        java.lang.String _getWorkOrderAttachment__return = port.getWorkOrderAttachment(_getWorkOrderAttachment_arg0);
        System.out.println("getWorkOrderAttachment.result=" + _getWorkOrderAttachment__return);


        }
        {
        System.out.println("Invoking queryWorkOrder...");
        java.lang.String _queryWorkOrder_arg0 = "";
        java.lang.String _queryWorkOrder__return = port.queryWorkOrder(_queryWorkOrder_arg0);
        System.out.println("queryWorkOrder.result=" + _queryWorkOrder__return);


        }
        {
        System.out.println("Invoking revokeWorkOrder...");
        java.lang.String _revokeWorkOrder_arg0 = "";
        java.lang.String _revokeWorkOrder__return = port.revokeWorkOrder(_revokeWorkOrder_arg0);
        System.out.println("revokeWorkOrder.result=" + _revokeWorkOrder__return);


        }
        {
        System.out.println("Invoking getWorkOrderDetails...");
        java.lang.String _getWorkOrderDetails_arg0 = "";
        java.lang.String _getWorkOrderDetails__return = port.getWorkOrderDetails(_getWorkOrderDetails_arg0);
        System.out.println("getWorkOrderDetails.result=" + _getWorkOrderDetails__return);


        }
        {
        System.out.println("Invoking markWorkOrder...");
        java.lang.String _markWorkOrder_arg0 = "";
        java.lang.String _markWorkOrder__return = port.markWorkOrder(_markWorkOrder_arg0);
        System.out.println("markWorkOrder.result=" + _markWorkOrder__return);


        }

        System.exit(0);
    }

}
