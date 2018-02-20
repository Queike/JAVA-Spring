package adbWholesaleSys.dao;


import adbWholesaleSys.dto.ArticleDto;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

public interface ArticleDao {
    List<ArticleDto> getArticle(int idArticle) throws SQLException, URISyntaxException;
    List<ArticleDto> getArticles() throws SQLException, URISyntaxException;
}
