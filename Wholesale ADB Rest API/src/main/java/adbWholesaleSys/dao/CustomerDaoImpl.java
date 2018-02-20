package adbWholesaleSys.dao;

import adbWholesaleSys.connection.DbConnection;
import adbWholesaleSys.dto.CustomerDto;
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
public class CustomerDaoImpl implements CustomerDao{

    private static final String GET_CUSTOMERS = "SELECT * FROM Customers";

    private final DbConnection dbConnection;

    @Autowired
    public CustomerDaoImpl(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }


    @Override
    public List<CustomerDto> getCustomers() throws SQLException, URISyntaxException {
        List<CustomerDto> customerDtos = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = dbConnection.getConnection();
            preparedStatement = connection.prepareStatement(String.format(GET_CUSTOMERS));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                CustomerDto customerDto = new CustomerDto(
                        resultSet.getInt("idCustomer"),
                        resultSet.getInt("idAddress"),
                        resultSet.getString("companyName"),
                        resultSet.getString("nip"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"));
                customerDtos.add(customerDto);
            }
            resultSet.close();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return customerDtos;
    }
}
