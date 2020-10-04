package com.example.articles.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * @autor: agr
 * 
 */

public class Conexion {
    private Connection jdbcConnection;
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    
    public Conexion(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}

	public void conectar() throws SQLException {
		
        System.out.println("Iniciando conectar()");
        System.out.println(jdbcURL);
        System.out.println(jdbcUsername);
        System.out.println(this.jdbcPassword);
		
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
//                Class.forName("com.mysql.jdbc.Driver");
                Class.forName("oracle.jdbc.OracleDriver");
            } catch (ClassNotFoundException e) {
                System.out.println("class not found");
                throw new SQLException(e);
            }
       
            
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
            
            
            if (jdbcConnection != null) {
                System.out.println("Connected");
            }
            
            System.out.println("fin conectar()");
            
        }
    }
     
    public void desconectar() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

	public Connection getJdbcConnection() {
		return jdbcConnection;
	}  

}