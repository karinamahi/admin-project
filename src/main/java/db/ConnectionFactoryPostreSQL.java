package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactoryPostreSQL {
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/estudo?currentSchema=teste", "postgres", "159");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
