package com.iNeuron.ai;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

public class Test {

	public static void main(String[] args) {
		
		// Create an object of a class which implements javax.sql.DataSource
		MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();

		dataSource.setURL("jdbc:mysql:///people");
		dataSource.setUser("root");
		dataSource.setPassword("Sagar@123");
		Connection connection = null;
		Statement statement = null;
		ResultSet rst = null;

		try {
			if (dataSource != null)
				connection = dataSource.getConnection();

			if (connection != null)
				statement = connection.createStatement();

			String selectQuery = "Select firstname, lastname, profession from friends";
			if (statement != null)
				rst = statement.executeQuery(selectQuery);

			if (rst != null) {
				while (rst.next())
					System.out.println(rst.getString(1) + "\t" + rst.getString(2) + "\t" + rst.getString(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				connection.close();
				statement.close();
				rst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
