
package com.rds.platform.web.itsmws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.rds.platform.web.itsmws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetWorkOrderAttachment_QNAME = new QName("http://www.chinawiserv.com/onecenter", "getWorkOrderAttachment");
    private final static QName _GetWorkOrderAttachmentResponse_QNAME = new QName("http://www.chinawiserv.com/onecenter", "getWorkOrderAttachmentResponse");
    private final static QName _GetWorkOrderDetails_QNAME = new QName("http://www.chinawiserv.com/onecenter", "getWorkOrderDetails");
    private final static QName _GetWorkOrderDetailsResponse_QNAME = new QName("http://www.chinawiserv.com/onecenter", "getWorkOrderDetailsResponse");
    private final static QName _MarkWorkOrder_QNAME = new QName("http://www.chinawiserv.com/onecenter", "markWorkOrder");
    private final static QName _MarkWorkOrderResponse_QNAME = new QName("http://www.chinawiserv.com/onecenter", "markWorkOrderResponse");
    private final static QName _PublishWorkOrder_QNAME = new QName("http://www.chinawiserv.com/onecenter", "publishWorkOrder");
    private final static QName _PublishWorkOrderResponse_QNAME = new QName("http://www.chinawiserv.com/onecenter", "publishWorkOrderResponse");
    private final static QName _QueryWorkOrder_QNAME = new QName("http://www.chinawiserv.com/onecenter", "queryWorkOrder");
    private final static QName _QueryWorkOrderResponse_QNAME = new QName("http://www.chinawiserv.com/onecenter", "queryWorkOrderResponse");
    private final static QName _RevokeWorkOrder_QNAME = new QName("http://www.chinawiserv.com/onecenter", "revokeWorkOrder");
    private final static QName _RevokeWorkOrderResponse_QNAME = new QName("http://www.chinawiserv.com/onecenter", "revokeWorkOrderResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.rds.platform.web.itsmws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetWorkOrderAttachment }
     * 
     */
    public GetWorkOrderAttachment createGetWorkOrderAttachment() {
        return new GetWorkOrderAttachment();
    }

    /**
     * Create an instance of {@link GetWorkOrderAttachmentResponse }
     * 
     */
    public GetWorkOrderAttachmentResponse createGetWorkOrderAttachmentResponse() {
        return new GetWorkOrderAttachmentResponse();
    }

    /**
     * Create an instance of {@link GetWorkOrderDetails }
     * 
     */
    public GetWorkOrderDetails createGetWorkOrderDetails() {
        return new GetWorkOrderDetails();
    }

    /**
     * Create an instance of {@link GetWorkOrderDetailsResponse }
     * 
     */
    public GetWorkOrderDetailsResponse createGetWorkOrderDetailsResponse() {
        return new GetWorkOrderDetailsResponse();
    }

    /**
     * Create an instance of {@link MarkWorkOrder }
     * 
     */
    public MarkWorkOrder createMarkWorkOrder() {
        return new MarkWorkOrder();
    }

    /**
     * Create an instance of {@link MarkWorkOrderResponse }
     * 
     */
    public MarkWorkOrderResponse createMarkWorkOrderResponse() {
        return new MarkWorkOrderResponse();
    }

    /**
     * Create an instance of {@link PublishWorkOrder }
     * 
     */
    public PublishWorkOrder createPublishWorkOrder() {
        return new PublishWorkOrder();
    }

    /**
     * Create an instance of {@link PublishWorkOrderResponse }
     * 
     */
    public PublishWorkOrderResponse createPublishWorkOrderResponse() {
        return new PublishWorkOrderResponse();
    }

    /**
     * Create an instance of {@link QueryWorkOrder }
     * 
     */
    public QueryWorkOrder createQueryWorkOrder() {
        return new QueryWorkOrder();
    }

    /**
     * Create an instance of {@link QueryWorkOrderResponse }
     * 
     */
    public QueryWorkOrderResponse createQueryWorkOrderResponse() {
        return new QueryWorkOrderResponse();
    }

    /**
     * Create an instance of {@link RevokeWorkOrder }
     * 
     */
    public RevokeWorkOrder createRevokeWorkOrder() {
        return new RevokeWorkOrder();
    }

    /**
     * Create an instance of {@link RevokeWorkOrderResponse }
     * 
     */
    public RevokeWorkOrderResponse createRevokeWorkOrderResponse() {
        return new RevokeWorkOrderResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWorkOrderAttachment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.chinawiserv.com/onecenter", name = "getWorkOrderAttachment")
    public JAXBElement<GetWorkOrderAttachment> createGetWorkOrderAttachment(GetWorkOrderAttachment value) {
        return new JAXBElement<GetWorkOrderAttachment>(_GetWorkOrderAttachment_QNAME, GetWorkOrderAttachment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWorkOrderAttachmentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.chinawiserv.com/onecenter", name = "getWorkOrderAttachmentResponse")
    public JAXBElement<GetWorkOrderAttachmentResponse> createGetWorkOrderAttachmentResponse(GetWorkOrderAttachmentResponse value) {
        return new JAXBElement<GetWorkOrderAttachmentResponse>(_GetWorkOrderAttachmentResponse_QNAME, GetWorkOrderAttachmentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWorkOrderDetails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.chinawiserv.com/onecenter", name = "getWorkOrderDetails")
    public JAXBElement<GetWorkOrderDetails> createGetWorkOrderDetails(GetWorkOrderDetails value) {
        return new JAXBElement<GetWorkOrderDetails>(_GetWorkOrderDetails_QNAME, GetWorkOrderDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWorkOrderDetailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.chinawiserv.com/onecenter", name = "getWorkOrderDetailsResponse")
    public JAXBElement<GetWorkOrderDetailsResponse> createGetWorkOrderDetailsResponse(GetWorkOrderDetailsResponse value) {
        return new JAXBElement<GetWorkOrderDetailsResponse>(_GetWorkOrderDetailsResponse_QNAME, GetWorkOrderDetailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MarkWorkOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.chinawiserv.com/onecenter", name = "markWorkOrder")
    public JAXBElement<MarkWorkOrder> createMarkWorkOrder(MarkWorkOrder value) {
        return new JAXBElement<MarkWorkOrder>(_MarkWorkOrder_QNAME, MarkWorkOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MarkWorkOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.chinawiserv.com/onecenter", name = "markWorkOrderResponse")
    public JAXBElement<MarkWorkOrderResponse> createMarkWorkOrderResponse(MarkWorkOrderResponse value) {
        return new JAXBElement<MarkWorkOrderResponse>(_MarkWorkOrderResponse_QNAME, MarkWorkOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublishWorkOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.chinawiserv.com/onecenter", name = "publishWorkOrder")
    public JAXBElement<PublishWorkOrder> createPublishWorkOrder(PublishWorkOrder value) {
        return new JAXBElement<PublishWorkOrder>(_PublishWorkOrder_QNAME, PublishWorkOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublishWorkOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.chinawiserv.com/onecenter", name = "publishWorkOrderResponse")
    public JAXBElement<PublishWorkOrderResponse> createPublishWorkOrderResponse(PublishWorkOrderResponse value) {
        return new JAXBElement<PublishWorkOrderResponse>(_PublishWorkOrderResponse_QNAME, PublishWorkOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryWorkOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.chinawiserv.com/onecenter", name = "queryWorkOrder")
    public JAXBElement<QueryWorkOrder> createQueryWorkOrder(QueryWorkOrder value) {
        return new JAXBElement<QueryWorkOrder>(_QueryWorkOrder_QNAME, QueryWorkOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryWorkOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.chinawiserv.com/onecenter", name = "queryWorkOrderResponse")
    public JAXBElement<QueryWorkOrderResponse> createQueryWorkOrderResponse(QueryWorkOrderResponse value) {
        return new JAXBElement<QueryWorkOrderResponse>(_QueryWorkOrderResponse_QNAME, QueryWorkOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RevokeWorkOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.chinawiserv.com/onecenter", name = "revokeWorkOrder")
    public JAXBElement<RevokeWorkOrder> createRevokeWorkOrder(RevokeWorkOrder value) {
        return new JAXBElement<RevokeWorkOrder>(_RevokeWorkOrder_QNAME, RevokeWorkOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RevokeWorkOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.chinawiserv.com/onecenter", name = "revokeWorkOrderResponse")
    public JAXBElement<RevokeWorkOrderResponse> createRevokeWorkOrderResponse(RevokeWorkOrderResponse value) {
        return new JAXBElement<RevokeWorkOrderResponse>(_RevokeWorkOrderResponse_QNAME, RevokeWorkOrderResponse.class, null, value);
    }

}
