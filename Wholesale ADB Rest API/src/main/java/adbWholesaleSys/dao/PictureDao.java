package adbWholesaleSys.dao;

import adbWholesaleSys.dto.PictureDto;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

public interface PictureDao {
    List<PictureDto> getPicture(int idPicture) throws SQLException, URISyntaxException;

    List<PictureDto> getPictures() throws SQLException, URISyntaxException;
}
