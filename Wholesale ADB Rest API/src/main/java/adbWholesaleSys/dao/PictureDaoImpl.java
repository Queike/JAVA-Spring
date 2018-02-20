package adbWholesaleSys.dao;

import adbWholesaleSys.connection.DbConnection;
import adbWholesaleSys.dto.PictureDto;
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
public class PictureDaoImpl implements PictureDao {
    private static final String GET_PICTURE = "SELECT * FROM Pictures WHERE idPicture = '%d'";
    private static final String GET_PICTURES = "SELECT * FROM Pictures";

    private final DbConnection dbConnection;

    @Autowired
    public PictureDaoImpl(DbConnection dbConnection){
        this.dbConnection = dbConnection;
    }

    @Override
    public List<PictureDto> getPicture(int idPicture) throws SQLException, URISyntaxException {
        List<PictureDto> pictureDtos = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try{
            Connection connection = dbConnection.getConnection();
            preparedStatement = connection.prepareStatement(String.format(GET_PICTURE, idPicture));
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                PictureDto pictureDto = new PictureDto(
                        resultSet.getInt("idPicture"),
                        resultSet.getString("picture"));
                pictureDtos.add(pictureDto);
            }
            resultSet.close();
        } finally{
            if(preparedStatement != null){
                preparedStatement.close();
            }
            return  pictureDtos;
        }
    }


    @Override
    public List<PictureDto> getPictures() throws SQLException, URISyntaxException {
        List<PictureDto> pictureDtos = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try{
            Connection connection = dbConnection.getConnection();
            preparedStatement = connection.prepareStatement(String.format(GET_PICTURES));
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                PictureDto pictureDto = new PictureDto(
                        resultSet.getInt("idPicture"),
                        resultSet.getString("picture"));
                pictureDtos.add(pictureDto);
            }
            resultSet.close();
        } finally{
            if(preparedStatement != null){
                preparedStatement.close();
            }
            return  pictureDtos;
        }
    }
}
