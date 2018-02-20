package adbWholesaleSys.dao;

import adbWholesaleSys.connection.DbConnection;
import adbWholesaleSys.dto.WorkerDto;
import org.eclipse.jetty.server.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.net.URISyntaxException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class WorkerDaoImpl implements WorkerDao {

    private static final String GET_WORKER = "SELECT * FROM Workers WHERE idWorker = '%d'";
    private static final String GET_WORKERS = "SELECT * FROM Workers";
    private static final String INSERT_WORKER = "INSERT INTO Workers(Forename, Surname, pesel, dateOfEmployment, dateOfRelease) VALUES (?,?,?,?,?)";

    private final DbConnection dbConnection;

    @Autowired
    public WorkerDaoImpl(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    @Transactional
    public Integer addWorker(WorkerDto workerDto) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = dbConnection.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_WORKER);
            preparedStatement.setString(1, workerDto.getForename());
            preparedStatement.setString(2, workerDto.getSurname());
            preparedStatement.setString(3, workerDto.getPesel());
            preparedStatement.setDate(4, workerDto.getDateOfEmployment());
            preparedStatement.setDate(5, workerDto.getDateOfRelease());
            preparedStatement.executeUpdate();

        } catch (URISyntaxException | SQLException e) {
            return Response.SC_INTERNAL_SERVER_ERROR;
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return Response.SC_CREATED;
    }

    @Override
    public List<WorkerDto> getWorker(int idWorker) throws SQLException, URISyntaxException {
        List<WorkerDto> workerDtos = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = dbConnection.getConnection();
            preparedStatement = connection.prepareStatement(String.format(GET_WORKER, idWorker));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                WorkerDto workerDto = new WorkerDto(
                        resultSet.getInt("idWorker"),
                        resultSet.getString("Forename"),
                        resultSet.getString("Surname"),
                        resultSet.getString("pesel"),
                        resultSet.getDate("dateOfEmployment"),
                        resultSet.getDate("dateOfRelease"));
                workerDtos.add(workerDto);
            }
            resultSet.close();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return workerDtos;
    }


    @Override
    public List<WorkerDto> getWorkers() throws SQLException, URISyntaxException {
        List<WorkerDto> workerDtos = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = dbConnection.getConnection();
            preparedStatement = connection.prepareStatement(String.format(GET_WORKERS));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                WorkerDto workerDto = new WorkerDto(
                        resultSet.getInt("idWorker"),
                        resultSet.getString("Forename"),
                        resultSet.getString("Surname"),
                        resultSet.getString("pesel"),
                        resultSet.getDate("dateOfEmployment"),
                        resultSet.getDate("dateOfRelease"));
                workerDtos.add(workerDto);
            }
            resultSet.close();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return workerDtos;
    }
}
