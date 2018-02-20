package adbWholesaleSys.dao;

import adbWholesaleSys.connection.DbConnection;
import adbWholesaleSys.dto.OrderItemDto;
import org.eclipse.jetty.server.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrderItemDaoImpl implements OrderItemDao{

    private static final String GET_ITEMS_FOR_ORDER = "SELECT * FROM OrdersItems WHERE idOrder = '%d'";
    private static final String GET_ITEMS_ORDERS = "SELECT * FROM OrdersItems";
    private static final String GET_QUANTITY_OF_SOLD_ARTICLES = "SELECT SUM(quantity) FROM OrdersItems WHERE idArticle = '%d'";
    private static final String INSERT_ITEM_ORDER = "INSERT INTO OrdersItems(idOrder, idArticle, quantity) VALUES (?,?,?)";

    private final DbConnection dbConnection;

    @Autowired
    public OrderItemDaoImpl(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    @Transactional
    public Integer addOrderItem(OrderItemDto orderItemDto) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = dbConnection.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_ITEM_ORDER);
            preparedStatement.setInt(1, orderItemDto.getIdOrder());
            preparedStatement.setInt(2, orderItemDto.getIdArticle());
            preparedStatement.setInt(3, orderItemDto.getQuantity());
            preparedStatement.executeUpdate();

        } catch (URISyntaxException | SQLException e) {
            return Response.SC_INTERNAL_SERVER_ERROR;
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return Response.SC_CREATED;
    }

    @Override
    public List<OrderItemDto> getItemsForOrder(int idOrder) throws SQLException, URISyntaxException {
        List<OrderItemDto> orderItemDtos = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = dbConnection.getConnection();
            preparedStatement = connection.prepareStatement(String.format(GET_ITEMS_FOR_ORDER, idOrder));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                OrderItemDto orderItemDto = new OrderItemDto(
                        resultSet.getInt("idOrderItem"),
                        resultSet.getInt("idOrder"),
                        resultSet.getInt("idArticle"),
                        resultSet.getInt("quantity"));
                orderItemDtos.add(orderItemDto);
            }
            resultSet.close();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return orderItemDtos;
    }


    @Override
    public List<OrderItemDto> getItemsOrders() throws SQLException, URISyntaxException {
        List<OrderItemDto> orderItemDtos = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = dbConnection.getConnection();
            preparedStatement = connection.prepareStatement(String.format(GET_ITEMS_ORDERS));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                OrderItemDto orderItemDto = new OrderItemDto(
                        resultSet.getInt("idOrderItem"),
                        resultSet.getInt("idOrder"),
                        resultSet.getInt("idArticle"),
                        resultSet.getInt("quantity"));
                orderItemDtos.add(orderItemDto);
            }
            resultSet.close();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return orderItemDtos;
    }



    @Override
    public int getQuantityOfSoldArticles(int idArticle) throws SQLException, URISyntaxException {
        int quantity = 0;
        PreparedStatement preparedStatement = null;
        try{
            Connection connection = dbConnection.getConnection();
            preparedStatement = connection.prepareStatement(String.format(GET_QUANTITY_OF_SOLD_ARTICLES, idArticle));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                resultSet.next();
                quantity = resultSet.getInt(1);

                resultSet.close();
            }
        } finally{
            if(preparedStatement != null){
                preparedStatement.close();
            }
            return  quantity;
        }
    }
}
