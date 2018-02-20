package adbWholesaleSys.dao;

import adbWholesaleSys.connection.DbConnection;
import adbWholesaleSys.dto.ManufacturerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Component
public class ManufacturerDaoImpl implements ManufacturerDao {

    private static final String GET_MANUFACTURERS = "SELECT * FROM manufacturers";

    private final DbConnection dbConnection;

    @Autowired
    public ManufacturerDaoImpl(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }


    @Override
    public List<ManufacturerDto> getManufacturers() throws SQLException, URISyntaxException {
        List<ManufacturerDto> manufacturerDtos = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = dbConnection.getConnection();
            preparedStatement = connection.prepareStatement(String.format(GET_MANUFACTURERS));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ManufacturerDto manufacturerDto = new ManufacturerDto(
                        resultSet.getInt("idManufacturer"),
                        resultSet.getString("designation"));
                manufacturerDtos.add(manufacturerDto);
            }
            resultSet.close();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return manufacturerDtos;
    }
}
