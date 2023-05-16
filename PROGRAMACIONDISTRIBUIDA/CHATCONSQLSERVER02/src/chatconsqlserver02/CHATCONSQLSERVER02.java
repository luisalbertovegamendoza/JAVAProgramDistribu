/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chatconsqlserver02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CHATCONSQLSERVER02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws  ClassNotFoundException , SQLException{
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      String connectionURL="jdbc:sqlserver://DESKTOP-QN13SD7\\SQLEXPRESS:1433;DatabaseName=Mercado;user=sa; password=12345678";
      Connection con= DriverManager.getConnection(connectionURL);
      System.out.println("Nos conectamos");
    
    }
    
}
