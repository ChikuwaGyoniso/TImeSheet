package dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceManager {
	private final String JNDI = "java:comp/env/jdbc/mysql";
	protected Connection connection;

	public DataSourceManager() {
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup(JNDI);
			connection = dataSource.getConnection();

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {

			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
