package adbWholesaleSys.dao;

import adbWholesaleSys.connection.DbConnection;
import adbWholesaleSys.dto.InvoiceDto;
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
public class InvoiceDaoImpl implements InvoiceDao{

    private static final String GET_INVOICES = "SELECT * FROM Invoices";
    private static final String INSERT_INVOICE = "INSERT INTO Invoices(idOrder, dateOfIssue, idWorker, idCustomer) VALUES (?,?,?,?)";

    private final DbConnection dbConnection;

    @Autowired
    public InvoiceDaoImpl(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    @Transactional
    public Integer addInvoice(InvoiceDto invoiceDto) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = dbConnection.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_INVOICE);
            preparedStatement.setInt(1, invoiceDto.getIdOrder());
            preparedStatement.setDate(2, invoiceDto.getDateOfIssue());
            preparedStatement.setInt(3, invoiceDto.getIdWorker());
            preparedStatement.setInt(4, invoiceDto.getIdCustomer());
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
    public List<InvoiceDto> getInvoices() throws SQLException, URISyntaxException {
        List<InvoiceDto> invoiceDtos = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = dbConnection.getConnection();
            preparedStatement = connection.prepareStatement(String.format(GET_INVOICES));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                InvoiceDto invoiceDto = new InvoiceDto(
                        resultSet.getInt("idInvoice"),
                        resultSet.getInt("idOrder"),
                        resultSet.getDate("dateOfIssue"),
                        resultSet.getInt("idWorker"),
                        resultSet.getInt("idCustomer"));
                invoiceDtos.add(invoiceDto);
            }
            resultSet.close();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return invoiceDtos;
    }
}
