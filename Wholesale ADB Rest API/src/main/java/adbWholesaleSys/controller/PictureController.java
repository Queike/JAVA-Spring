package adbWholesaleSys.controller;

import adbWholesaleSys.dao.PictureDao;
import adbWholesaleSys.dto.PictureDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping("/pictures")
public class PictureController {
    private static final Logger LOG = LoggerFactory.getLogger(PictureController.class);
    private final PictureDao pictureDAO;

    @Autowired
    public PictureController(PictureDao pictureDAO) {
        this.pictureDAO = pictureDAO;
    }

    @RequestMapping(value = "/getPicture/{idPicture}", method = RequestMethod.GET)
    public List<PictureDto> getPicture(@PathVariable int idPicture){
        List<PictureDto> result = null;
        try{
            result = pictureDAO.getPicture(idPicture);
        } catch (URISyntaxException | SQLException e){
            LOG.error(e.getMessage());
        }
        return result;
    }


    @RequestMapping(value = "/getPictures", method = RequestMethod.GET)
    public List<PictureDto> getPictures(){
        List<PictureDto> result = null;
        try{
            result = pictureDAO.getPictures();
        } catch (URISyntaxException | SQLException e){
            LOG.error(e.getMessage());
        }
        return result;
    }
}
