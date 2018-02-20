package adbWholesaleSys.connection;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;

public interface DbConnection {

    Connection getConnection() throws URISyntaxException, SQLException;

}