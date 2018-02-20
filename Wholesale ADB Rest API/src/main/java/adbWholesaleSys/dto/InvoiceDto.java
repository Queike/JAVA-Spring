package adbWholesaleSys.dto;

import java.sql.Date;

public class InvoiceDto {
    private int idInvoice;
    private int idOrder;
    private Date dateOfIssue;
    private int idWorker;
    private int idCustomer;

    public InvoiceDto(){}

    public InvoiceDto(int idInvoice, int idOrder, Date dateOfIssue, int idWorker, int idCustomer) {
        this.idInvoice = idInvoice;
        this.idOrder = idOrder;
        this.dateOfIssue = dateOfIssue;
        this.idWorker = idWorker;
        this.idCustomer = idCustomer;
    }

    public int getIdInvoice() {
        return idInvoice;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public int getIdWorker() {
        return idWorker;
    }

    public int getIdCustomer() {
        return idCustomer;
    }
}
