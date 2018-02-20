package adbWholesaleSys.dao;

import adbWholesaleSys.dto.OrderItemDto;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

public interface OrderItemDao {
    Integer addOrderItem(OrderItemDto orderItemDto) throws SQLException;
    List<OrderItemDto> getItemsForOrder(int idOrder) throws SQLException, URISyntaxException;
    int getQuantityOfSoldArticles(int idArticle) throws SQLException, URISyntaxException;
    List<OrderItemDto> getItemsOrders() throws SQLException, URISyntaxException;

}
