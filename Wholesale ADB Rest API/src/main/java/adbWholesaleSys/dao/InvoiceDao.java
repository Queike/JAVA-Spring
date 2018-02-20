package adbWholesaleSys.dao;

import adbWholesaleSys.dto.InvoiceDto;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

public interface InvoiceDao {
    List<InvoiceDto> getInvoices() throws SQLException, URISyntaxException;
    Integer addInvoice(InvoiceDto invoiceDto) throws SQLException;

}
