package adbWholesaleSys.dao;

import adbWholesaleSys.dto.CustomerDto;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {

    List<CustomerDto> getCustomers() throws SQLException, URISyntaxException;
}
