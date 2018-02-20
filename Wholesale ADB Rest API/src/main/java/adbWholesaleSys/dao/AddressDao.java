package adbWholesaleSys.dao;

import adbWholesaleSys.dto.AddressDto;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

public interface AddressDao {
    List<AddressDto> getAddresses() throws SQLException, URISyntaxException;
}
