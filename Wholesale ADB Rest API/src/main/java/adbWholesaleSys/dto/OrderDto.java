package adbWholesaleSys.dto;

import java.sql.Array;
import java.sql.Date;


public class OrderDto {
    private int idOrder;
    private int idCustomer;
    private String orderNumber;
    private Date orderDate;
    private Date receiptDate;
    private String delivery;
    private Date paymentDate;
    private boolean isDeferredPayment;
    private int idWorker;
    private Integer idInvoice;

    public OrderDto(){}

    public OrderDto(int idOrder, int idCustomer, String orderNumber, Date orderDate, Date receiptDate, String delivery, Date paymentDate, boolean isDeferredPayment, int idWorker, int idInvoice) {
        this.idOrder = idOrder;
        this.idCustomer = idCustomer;
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.receiptDate = receiptDate;
        this.delivery = delivery;
        this.paymentDate = paymentDate;
        this.isDeferredPayment = isDeferredPayment;
        this.idWorker = idWorker;
        this.idInvoice = idInvoice;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public java.sql.Date getOrderDate() {
        return orderDate;
    }

    public java.sql.Date getReceiptDate() {
        return receiptDate;
    }

    public String getDelivery() {
        return delivery;
    }

    public java.sql.Date getPaymentDate() {
        return paymentDate;
    }

    public boolean isDeferredPayment() {
        return isDeferredPayment;
    }

    public int getIdWorker() {
        return idWorker;
    }

    public Integer getIdInvoice() {
        return idInvoice;
    }

}
