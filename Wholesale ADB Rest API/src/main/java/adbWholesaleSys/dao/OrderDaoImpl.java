package adbWholesaleSys.dao;

import adbWholesaleSys.connection.DbConnection;
import adbWholesaleSys.dto.OrderDto;
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
public class OrderDaoImpl implements OrderDao{

    private static final String GET_ORDER = "SELECT * FROM Orders WHERE idOrder = '%d'";
    private static final String GET_ORDERS = "SELECT * FROM Orders";
    private static final String INSERT_ORDER = "INSERT INTO Orders(idCustomer, orderNumber, orderDate, receiptDate, delivery, paymentDate, isDeferredPayment, idWorker, idInvoice) VALUES (?,?,?,?,?,?,?,?,?)";

    private final DbConnection dbConnection;

    @Autowired
    public OrderDaoImpl(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    @Transactional
    public Integer addOrder(OrderDto orderDto) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = dbConnection.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_ORDER);
            preparedStatement.setInt(1, orderDto.getIdCustomer());
            preparedStatement.setString(2, orderDto.getOrderNumber());
            preparedStatement.setDate(3, orderDto.getOrderDate());
            preparedStatement.setDate(4, orderDto.getReceiptDate());
            preparedStatement.setString(5, orderDto.getDelivery());
            preparedStatement.setDate(6, orderDto.getPaymentDate());
            preparedStatement.setBoolean(7, orderDto.isDeferredPayment());
            preparedStatement.setInt(8, orderDto.getIdWorker());
            preparedStatement.setInt(9, orderDto.getIdInvoice());
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
    public List<OrderDto> getOrder(int idOrder) throws SQLException, URISyntaxException {
        List<OrderDto> orderDtos = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = dbConnection.getConnection();
            preparedStatement = connection.prepareStatement(String.format(GET_ORDER, idOrder));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                OrderDto orderDto = new OrderDto(
                        resultSet.getInt("idOrder"),
                        resultSet.getInt("idCustomer"),
                        resultSet.getString("orderNumber"),
                        resultSet.getDate("orderDate"),
                        resultSet.getDate("receiptDate"),
                        resultSet.getString("delivery"),
                        resultSet.getDate("paymentDate"),
                        resultSet.getBoolean("isDeferredPayment"),
                        resultSet.getInt("idWorker"),
                        resultSet.getInt("idInvoice"));
                orderDtos.add(orderDto);
            }
            resultSet.close();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return orderDtos;
    }



    @Override
    public List<OrderDto> getOrders() throws SQLException, URISyntaxException {
        List<OrderDto> orderDtos = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = dbConnection.getConnection();
            preparedStatement = connection.prepareStatement(String.format(GET_ORDERS));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                OrderDto orderDto = new OrderDto(
                        resultSet.getInt("idOrder"),
                        resultSet.getInt("idCustomer"),
                        resultSet.getString("orderNumber"),
                        resultSet.getDate("orderDate"),
                        resultSet.getDate("receiptDate"),
                        resultSet.getString("delivery"),
                        resultSet.getDate("paymentDate"),
                        resultSet.getBoolean("isDeferredPayment"),
                        resultSet.getInt("idWorker"),
                        resultSet.getInt("idInvoice"));
                orderDtos.add(orderDto);
            }
            resultSet.close();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return orderDtos;
    }
}
