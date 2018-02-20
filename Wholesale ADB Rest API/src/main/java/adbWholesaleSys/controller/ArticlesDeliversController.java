package adbWholesaleSys.controller;

import adbWholesaleSys.dao.ArticlesDeliversDao;
import adbWholesaleSys.dto.ArticlesDeliversDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/articlesdelivers")
public class ArticlesDeliversController {
    private static final Logger LOG = LoggerFactory.getLogger(ArticlesDeliversController.class);
    private final ArticlesDeliversDao articlesDeliversDAO;

    @Autowired
    public ArticlesDeliversController(ArticlesDeliversDao articlesDeliversDAO) {
        this.articlesDeliversDAO = articlesDeliversDAO;
    }

    @RequestMapping(value = "/getQuantityOfArticle/{idArticle}", method = RequestMethod.GET)
    public int getQuantityOfArticle(@PathVariable int idArticle) {
        int result = 0;
        try {
            result = articlesDeliversDAO.getQuantityOfArticle(idArticle);
        } catch (URISyntaxException | SQLException e) {
            LOG.error(e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/getArticlesDelivers", method = RequestMethod.GET)
    public List<ArticlesDeliversDto> getArticlesDelivers() {
        List<ArticlesDeliversDto> result = null;
        try {
            result = articlesDeliversDAO.getArticlesDelivers();
        } catch (URISyntaxException | SQLException e) {
            LOG.error(e.getMessage());
        }
        return result;
    }
}
