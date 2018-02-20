package adbWholesaleSys.dao;

import adbWholesaleSys.dto.ManufacturerDto;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

public interface ManufacturerDao {
    List<ManufacturerDto> getManufacturers() throws SQLException, URISyntaxException;
}
