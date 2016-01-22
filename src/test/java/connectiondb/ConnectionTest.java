package connectiondb;
import java.sql.Connection;
import java.sql.SQLException;

//import com.mysql.jdbc.Connection;


import db.ConnectionFactory;
import db.ConnectionFactoryPostreSQL;

public class ConnectionTest {
/*	public static void main(String[] args) throws SQLException {
		Connection connection = (Connection) new ConnectionFactory().getConnection();
		System.out.println("Connection OK!");
		connection.close();
	}
*/	
	public static void main(String[] args) throws SQLException {
		Connection connection = (Connection) new ConnectionFactoryPostreSQL().getConnection();
		System.out.println("Connection OK!");
		connection.close();
	}
}
