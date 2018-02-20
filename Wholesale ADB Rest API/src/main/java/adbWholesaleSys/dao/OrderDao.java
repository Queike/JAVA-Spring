package adbWholesaleSys.dao;

import adbWholesaleSys.dto.OrderDto;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

public interface OrderDao {
    Integer addOrder(OrderDto orderDto) throws SQLException;
    List<OrderDto> getOrder(int idOrder) throws SQLException, URISyntaxException;
    List<OrderDto> getOrders() throws SQLException, URISyntaxException;
}
