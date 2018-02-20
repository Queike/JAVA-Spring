package adbWholesaleSys.controller;

import adbWholesaleSys.dao.AddressDao;
import adbWholesaleSys.dto.AddressDto;
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
@RequestMapping("/addresses")
public class AddressController {

    private static final Logger LOG = LoggerFactory.getLogger(WorkerController.class);
    private final AddressDao addressDao;

    @Autowired
    public AddressController(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @RequestMapping(value = "/getAddresses", method = RequestMethod.GET)
    public List<AddressDto> getWorker(){
        List<AddressDto> result = null;
        try{
            result = addressDao.getAddresses();
        } catch (URISyntaxException | SQLException e){
            LOG.error(e.getMessage());
        }
        return result;
    }
}
