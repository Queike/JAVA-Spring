package adbWholesaleSys.controller;

import adbWholesaleSys.dao.OrderDao;
import adbWholesaleSys.dto.OrderDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping("/orders")
public class OrderController {
    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);
    private final OrderDao orderDao;

    @Autowired
    public OrderController(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @RequestMapping(value = "/getOrder/{idOrder}", method = RequestMethod.GET)
    public List<OrderDto> getOrder(@PathVariable int idOrder){
        List<OrderDto> result = null;
        try{
            result = orderDao.getOrder(idOrder);
        } catch (URISyntaxException | SQLException e){
            LOG.error(e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/getOrders", method = RequestMethod.GET)
    public List<OrderDto> getOrders(){
        List<OrderDto> result = null;
        try{
            result = orderDao.getOrders();
        } catch (URISyntaxException | SQLException e){
            LOG.error(e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    public int addOrder(@RequestBody OrderDto order){
        Integer result = null;
        try{
            result = orderDao.addOrder(order);
        } catch (SQLException e){
            LOG.error(e.getMessage());
        }
        return result;
    }
}
