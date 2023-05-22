package com.appstracta.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

	private Connection connection;
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/sakila?useSSL=false";
	private static final String USER = "test";
	private static final String PASSWORD = "123456789";

	public void conectar() {
		try {
			// Le decimos a Java a que base datos nos conectamos
			// De acuerdo a la lectura es el paso 1
			this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cerrar() {
		if (this.connection != null) {
			try {
				// De acuerdo a la lectura es el paso 4
				this.connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Connection getConnection() {
		return this.connection;
	}

}
