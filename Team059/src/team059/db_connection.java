/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team059;

import java.sql.*;

/**
 *
 * @author Turner
 */
public class db_connection {
    
    public static void dbTest() throws ClassNotFoundException {
        String DB_URL = "jdbc:mysql://50.62.209.189:3306/gtech_dbcd_db";
        String USER = "gtech_dbcd_db";
        String PASS = "gtech_dbcd_db1";
       
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
           
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "select * from test";
            ResultSet rs = stmt.executeQuery(sql);
           
            while(rs.next()){
                String id = rs.getString("name");
                String name = rs.getString("address");
                System.out.println(id + ", " + " " + name);
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException e){
            System.out.println("Error " + e);
           
           
        }
    }
    
}
