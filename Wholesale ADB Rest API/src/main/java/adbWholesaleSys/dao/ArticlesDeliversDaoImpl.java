package adbWholesaleSys.dao;

import adbWholesaleSys.connection.DbConnection;
import adbWholesaleSys.dto.ArticlesDeliversDto;
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
public class ArticlesDeliversDaoImpl implements ArticlesDeliversDao{
    private static final String GET_QUANTITY_OF_ARTICLE = "SELECT SUM(quantity) FROM articlesdelivers WHERE idArticle = '%d'";
    private static final String GET_ARTICLES_DELIVERS = "SELECT * FROM articlesdelivers";

    private final DbConnection dbConnection;

    @Autowired
    public ArticlesDeliversDaoImpl(DbConnection dbConnection){
        this.dbConnection = dbConnection;
    }

    @Override
    public int getQuantityOfArticle(int idArticle) throws SQLException, URISyntaxException {
        int quantity = 0;
        PreparedStatement preparedStatement = null;
        try{
            Connection connection = dbConnection.getConnection();
            preparedStatement = connection.prepareStatement(String.format(GET_QUANTITY_OF_ARTICLE, idArticle));
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            quantity = resultSet.getInt(1);

            resultSet.close();
        } finally{
            if(preparedStatement != null){
                preparedStatement.close();
            }
            return  quantity;
        }
    }


    @Override
    public List<ArticlesDeliversDto> getArticlesDelivers() throws SQLException, URISyntaxException {
        List<ArticlesDeliversDto> orderItemDtos = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = dbConnection.getConnection();
            preparedStatement = connection.prepareStatement(String.format(GET_ARTICLES_DELIVERS));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ArticlesDeliversDto articlesDeliversDto = new ArticlesDeliversDto(
                        resultSet.getInt("idArticlesDelivers"),
                        resultSet.getInt("idArticle"),
                        resultSet.getInt("idManufacturer"),
                        resultSet.getInt("quantity"));
                orderItemDtos.add(articlesDeliversDto);
            }
            resultSet.close();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return orderItemDtos;
    }
}
