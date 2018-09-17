package com.pongyeang.utilities;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

public class MySQLConnectionPool {
	private static DataSource datasource;
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/pongyeang?useUnicode=true&characterEncoding=UTF-8";
	private static String username = "root";
	private static String password = "12345";
	
	private static PoolProperties configurePoolProperties(String driver,String url, String username, String password) {
		PoolProperties properties = new PoolProperties();
		
		properties.setDriverClassName(driver);
		properties.setUrl(url);
		properties.setUsername(username);
		properties.setPassword(password);
		return properties;
	}
	public static synchronized Connection getConnection() {
		
		Connection connection = null;
		
		try {
			if (datasource == null) {
				datasource = new DataSource(configurePoolProperties(driver, url, username,password));
			}
			connection = datasource.getConnection();
			
		} catch (SQLException ex) {
			
			ExceptionUtil.messageException(new Throwable(),ex);
		}
		
		return connection;
	}

}
