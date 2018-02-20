package adbWholesaleSys.controller;


import adbWholesaleSys.dao.ManufacturerDao;
import adbWholesaleSys.dto.ManufacturerDto;
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
@RequestMapping("/manufacturers")
public class ManufacturerController {

    private static final Logger LOG = LoggerFactory.getLogger(WorkerController.class);
    private final ManufacturerDao manufacturerDao;

    @Autowired
    public ManufacturerController(ManufacturerDao manufacturerDao) {
        this.manufacturerDao = manufacturerDao;
    }

    @RequestMapping(value = "/getManufacturers", method = RequestMethod.GET)
    public List<ManufacturerDto> getManufacturers(){
        List<ManufacturerDto> result = null;
        try{
            result = manufacturerDao.getManufacturers();
        } catch (URISyntaxException | SQLException e){
            LOG.error(e.getMessage());
        }
        return result;
    }
}
