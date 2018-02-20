package adbWholesaleSys.dao;

import adbWholesaleSys.dto.ArticlesDeliversDto;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

public interface ArticlesDeliversDao {
    int getQuantityOfArticle(int idArticle) throws SQLException, URISyntaxException;
    List<ArticlesDeliversDto> getArticlesDelivers() throws SQLException, URISyntaxException;
}
