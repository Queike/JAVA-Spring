package adbWholesaleSys.connection;

import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DbConnectionImpl implements DbConnection {

    private static final String URI_PATH = "postgres://liejtxrettxcip:" +
            "93c6c5a5cd7b5720af99fdec9f413d60c461d87da82ae2ca06eb7f5cd289b599" +
            "@ec2-54-195-241-106.eu-west-1.compute.amazonaws.com:5432/ddt2mvgllntimt";

    @Override
    public Connection getConnection() throws URISyntaxException, SQLException {
        URI dbUri = new URI(URI_PATH);

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ":" + dbUri.getPort() + dbUri.getPath() +
                "?sslmode=require";

        return DriverManager.getConnection(dbUrl, username, password);
    }
}