package adbWholesaleSys.controller;

import adbWholesaleSys.dao.ArticleDao;
import adbWholesaleSys.dto.ArticleDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping("/articles")
public class ArticleController {
    private static final Logger LOG = LoggerFactory.getLogger(ArticleController.class);
    private final ArticleDao articleDAO;

    @Autowired
    public ArticleController(ArticleDao articleDAO) {
        this.articleDAO = articleDAO;
    }

    @RequestMapping(value = "/getArticle/{idArticle}", method = RequestMethod.GET)
    public List<ArticleDto> getArticle(@PathVariable int idArticle){
        List<ArticleDto> result = null;
        try{
            result = articleDAO.getArticle(idArticle);
        } catch (URISyntaxException | SQLException e){
            LOG.error(e.getMessage());
        }
        return result;
    }


    @RequestMapping(value = "/getArticles", method = RequestMethod.GET)
    public List<ArticleDto> getArticles(){
        List<ArticleDto> result = null;
        try{
            result = articleDAO.getArticles();
        } catch (URISyntaxException | SQLException e){
            LOG.error(e.getMessage());
        }
        return result;
    }

}
