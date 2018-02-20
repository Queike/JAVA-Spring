package adbWholesaleSys.controller;

import adbWholesaleSys.dao.OrderItemDao;
import adbWholesaleSys.dto.OrderItemDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping("/ordersitems")
public class OrderItemController {
    private static final Logger LOG = LoggerFactory.getLogger(OrderItemController.class);
    private final OrderItemDao orderItemDao;

    @Autowired
    public OrderItemController(OrderItemDao orderItemDao) {
        this.orderItemDao = orderItemDao;
    }

    @RequestMapping(value = "/getItemsForOrder/{idOrder}", method = RequestMethod.GET)
    public List<OrderItemDto> getItemsForOrder(@PathVariable int idOrder){
        List<OrderItemDto> result = null;
        try{
            result = orderItemDao.getItemsForOrder(idOrder);
        } catch (URISyntaxException | SQLException e){
            LOG.error(e.getMessage());
        }
        return result;
    }


    @RequestMapping(value = "/getItemsOrders", method = RequestMethod.GET)
    public List<OrderItemDto> getItemsOrders(){
        List<OrderItemDto> result = null;
        try{
            result = orderItemDao.getItemsOrders();
        } catch (URISyntaxException | SQLException e){
            LOG.error(e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/getQuantityOfSoldArticles/{idArticle}", method = RequestMethod.GET)
    public int getQuantityOfSoldArticles(@PathVariable int idArticle){
        int result = 0;
        try{
            result = orderItemDao.getQuantityOfSoldArticles(idArticle);
        } catch (URISyntaxException | SQLException e){
            LOG.error(e.getMessage());
        }
        return result;
    }


    @RequestMapping(value = "/addOrderItem", method = RequestMethod.POST)
    public int addOrderItem(@RequestBody OrderItemDto orderItem){
        Integer result = null;
        try{
            result = orderItemDao.addOrderItem(orderItem);
        } catch (SQLException e){
            LOG.error(e.getMessage());
        }
        return result;
    }
}
