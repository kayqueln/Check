/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.JDBCType;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectionFactory {

    /*public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/checkapp";
    public static final String USER = "root";
    public static final String PASS = "";*/

    public static Connection getConnection() {
       Connection connection = null;
       
        try {
            String url = "jdbc:mysql://localhost:3306/checkapp?user=root&password=";
            connection = DriverManager.getConnection(url);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados!");
        }
        return connection;     
    }

    
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conexão com banco de dados", ex);
        }
    }

    
    public static void closeConnection(Connection connection, PreparedStatement statement) {
        try {
            if (connection != null) {
                connection.close();
            }

            if (statement != null) {
                statement.close();
            }

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conexão com banco de dados", ex);
        }
    }
    
    
    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
            }

            if (statement != null) {
                statement.close();
            }
            
            if(resultSet != null){
                resultSet.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conexão com banco de dados", ex);
        }
    }

}
