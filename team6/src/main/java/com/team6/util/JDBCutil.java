package com.team6.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JDBCutil {
	//取得連線的靜態方法
	public static Connection getConnection() {

		Connection connection = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource)context.lookup("java:/comp/env/jdbc/team6");
			connection = dataSource.getConnection();
			boolean status = !connection.isClosed();
			System.out.println("連線狀態:" + status);

		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	//取得連線的靜態方法
	
	//關閉連線的靜態方法
	public static void closeResourse(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//關閉連線的靜態方法
	
	// 關閉連線,Statement的靜態方法
	public static void closeResourse(Connection connection, Statement statement) {
		try {
			if (connection != null) {
				connection.close();
			}
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	// 關閉連線,Statement的靜態方法

	// 關閉連線,Statement,ResultSet的靜態方法
	public static void closeResourse(Connection connection, Statement statement, ResultSet resultSet) {
		try {
			if (connection != null) {
				connection.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	// 關閉連線,Statement,ResultSet的靜態方法
	
	
}
