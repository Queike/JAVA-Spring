package adbWholesaleSys.dao;

import adbWholesaleSys.connection.DbConnection;
import adbWholesaleSys.dto.ArticleDto;
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
public class ArticleDaoImpl implements ArticleDao{
    private static final String GET_ARTICLE = "SELECT * FROM Articles WHERE idArticle = '%d'";
    private static final String GET_ARTICLES = "SELECT * FROM Articles";

    private final DbConnection dbConnection;

    @Autowired
    public ArticleDaoImpl(DbConnection dbConnection){
        this.dbConnection = dbConnection;
    }

    @Override
    public List<ArticleDto> getArticle(int idArticle) throws SQLException, URISyntaxException {
        List<ArticleDto> articleDtos = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try{
            Connection connection = dbConnection.getConnection();
            preparedStatement = connection.prepareStatement(String.format(GET_ARTICLE, idArticle));
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                ArticleDto articleDto = new ArticleDto(
                        resultSet.getInt("idArticle"),
                        resultSet.getInt("idPicture"),
                        resultSet.getString("name"),
                        resultSet.getBigDecimal("price"),
                        resultSet.getString("description"));
                articleDtos.add(articleDto);
            }
                resultSet.close();
            } finally{
                if(preparedStatement != null){
                    preparedStatement.close();
                }
                return  articleDtos;
            }
        }


    @Override
    public List<ArticleDto> getArticles() throws SQLException, URISyntaxException {
        List<ArticleDto> articleDtos = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try{
            Connection connection = dbConnection.getConnection();
            preparedStatement = connection.prepareStatement(String.format(GET_ARTICLES));
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                ArticleDto articleDto = new ArticleDto(
                        resultSet.getInt("idArticle"),
                        resultSet.getInt("idPicture"),
                        resultSet.getString("name"),
                        resultSet.getBigDecimal("price"),
                        resultSet.getString("description"));
                articleDtos.add(articleDto);
            }
            resultSet.close();
        } finally{
            if(preparedStatement != null){
                preparedStatement.close();
            }
            return  articleDtos;
        }
    }
}
