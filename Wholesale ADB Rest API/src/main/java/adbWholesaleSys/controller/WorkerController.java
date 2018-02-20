package adbWholesaleSys.controller;

import adbWholesaleSys.dao.WorkerDao;
import adbWholesaleSys.dto.WorkerDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping("/workers")
public class WorkerController {

    private static final Logger LOG = LoggerFactory.getLogger(WorkerController.class);
    private final WorkerDao workerDAO;

    @Autowired
    public WorkerController(WorkerDao workerDAO) {
        this.workerDAO = workerDAO;
    }

    @RequestMapping(value = "/getWorker/{idWorker}", method = RequestMethod.GET)
    public List<WorkerDto> getWorker(@PathVariable int idWorker){
        List<WorkerDto> result = null;
        try{
            result = workerDAO.getWorker(idWorker);
        } catch (URISyntaxException | SQLException e){
            LOG.error(e.getMessage());
        }
        return result;
    }


    @RequestMapping(value = "/getWorkers", method = RequestMethod.GET)
    public List<WorkerDto> getWorker(){
        List<WorkerDto> result = null;
        try{
            result = workerDAO.getWorkers();
        } catch (URISyntaxException | SQLException e){
            LOG.error(e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/addWorker", method = RequestMethod.POST)
    public int addWorker(@RequestBody WorkerDto worker){
        Integer result = null;
        try{
            result = workerDAO.addWorker(worker);
        } catch (SQLException e){
            LOG.error(e.getMessage());
        }
        return result;
    }
}
