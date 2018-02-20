package adbWholesaleSys.dao;

import adbWholesaleSys.dto.WorkerDto;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

public interface WorkerDao {


    Integer addWorker(WorkerDto workerDto) throws SQLException;

    List<WorkerDto> getWorker(int idWorker) throws SQLException, URISyntaxException;

    List<WorkerDto> getWorkers() throws SQLException, URISyntaxException;
}
