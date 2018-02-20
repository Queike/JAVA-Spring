package adbWholesaleSys.dao;

import adbWholesaleSys.connection.DbConnection;
import adbWholesaleSys.dto.AddressDto;
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
public class AddressDaoImpl implements AddressDao{

    private static final String GET_ADDRESSES = "SELECT * FROM addresses";

    private final DbConnection dbConnection;

    @Autowired
    public AddressDaoImpl(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }


    @Override
    public List<AddressDto> getAddresses() throws SQLException, URISyntaxException {
        List<AddressDto> addressDtos = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = dbConnection.getConnection();
            preparedStatement = connection.prepareStatement(String.format(GET_ADDRESSES));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                AddressDto addressDto = new AddressDto(
                        resultSet.getInt("idAddress"),
                        resultSet.getString("street"),
                        resultSet.getInt("streetNumber"),
                        resultSet.getInt("apartmentNumber"),
                        resultSet.getString("postalCode"),
                        resultSet.getString("city"),
                        resultSet.getString("country"));
                addressDtos.add(addressDto);
            }
            resultSet.close();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return addressDtos;
    }

}
