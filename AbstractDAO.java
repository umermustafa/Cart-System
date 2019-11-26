package com.db.cartsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;

public class AbstractDAO {
	private final String url= "jdbc:mariadb://localhost:3306/students";
	private final String user="root";
	private final String pass="";
	
	protected Connection connection=null;
	protected PreparedStatement ps=null;
	protected ResultSet rs=null;
	public void connect() throws SQLClientInfoException{
		try {
			connection=DriverManager.getConnection(url,user,pass);
		} catch (Exception e) {
			throw new SQLClientInfoException();
		}
	}
	public void dispose() {
		try {
			if (!rs.equals(null)) {
				if (!rs.isClosed()) {
					rs.close();
				}
			}
			if (!ps.equals(null)) {
				if (!ps.isClosed()) {
					ps.close();
				}
			}
			if (!connection.equals(null)) {
				if (!connection.isClosed()) {
					connection.close();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
