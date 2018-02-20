package adbWholesaleSys.controller;

import adbWholesaleSys.dao.CustomerDao;
import adbWholesaleSys.dto.CustomerDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;



@RestController
@RequestMapping("/customers")
public class CustomerController {

    private static final Logger LOG = LoggerFactory.getLogger(WorkerController.class);
    private final CustomerDao customerDao;

    @Autowired
    public CustomerController(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @RequestMapping(value = "/getCustomers", method = RequestMethod.GET)
    public List<CustomerDto> getWorker(){
        List<CustomerDto> result = null;
        try{
            result = customerDao.getCustomers();
        } catch (URISyntaxException | SQLException e){
            LOG.error(e.getMessage());
        }
        return result;
    }

}
