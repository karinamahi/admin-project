package connectiondb;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import db.ConnectionFactory;

public class ConnectionTest {
	public static void main(String[] args) throws SQLException {
		Connection connection = (Connection) new ConnectionFactory().getConnection();
		System.out.println("Connection OK!");
		connection.close();
	}
}
