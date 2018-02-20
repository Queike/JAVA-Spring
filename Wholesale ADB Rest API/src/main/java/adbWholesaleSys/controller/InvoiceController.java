package adbWholesaleSys.controller;

import adbWholesaleSys.dao.InvoiceDao;
import adbWholesaleSys.dto.InvoiceDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);
    private final InvoiceDao invoiceDao;

    @Autowired
    public InvoiceController(InvoiceDao invoiceDao) {
        this.invoiceDao = invoiceDao;
    }


    @RequestMapping(value = "/getInvoices", method = RequestMethod.GET)
    public List<InvoiceDto> getOrders(){
        List<InvoiceDto> result = null;
        try{
            result = invoiceDao.getInvoices();
        } catch (URISyntaxException | SQLException e){
            LOG.error(e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/addInvoice", method = RequestMethod.POST)
    public int addOrder(@RequestBody InvoiceDto invoice){
        Integer result = null;
        try{
            result = invoiceDao.addInvoice(invoice);
        } catch (SQLException e){
            LOG.error(e.getMessage());
        }
        return result;
    }
}
