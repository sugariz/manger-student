/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.sql.*;

/**
 *
 * @author azu
 */
public class mySQLConnect {

    private String host = "";
    private String username = "";
    private String password = "";
    private String database = "";
    
    private Connection connect = null;
    private Statement statement = null;
    private ResultSet result = null;
    
    public mySQLConnect(String host, String username, String password, String database) {
        this.host      = host;
        this.username  = username;
        this.password  = password;
        this.database  = database;
    }
    
    protected void driverTest() throws Exception {
        try {
            java.lang.Class.forName("com.mysql.jdbc.Driver");
        }
        catch(java.lang.ClassNotFoundException e) {
            throw new Exception("MySQL JDBC Driver not found.");
        }
    }
    
    protected Connection getConnect() throws Exception {
        if(this.connect == null) {
            this.driverTest();
            // jdbc:mysql://localhost:3306/QUAN_LY_HOC_SINH?zeroDateTimeBehavior=CONVERT_TO_NULL
//            /den1.mysql4.gear.host:3306/quanlyhocsinh
            String url = String.format("jdbc:mysql://%s:3306/%s", this.host, this.database);
            try {
                this.connect = DriverManager.getConnection(url, this.username, this.password);
            }
            catch(java.sql.SQLException e) {
                throw new Exception("Can't connect to Database!");
            }
        }
        
        return this.connect;
    }
    
    protected Statement getStatement() throws  Exception {
        if(this.statement == null ? true : this.statement.isClosed()) {
            this.statement = this.getConnect().createStatement();
        }
        
        return this.statement;
    }
    
    public ResultSet executeQuery(String query) throws Exception {
        try {
            this.result = getStatement().executeQuery(query);
        }
        catch (Exception e) {
            throw new Exception(String.format("Error: %s - %s", e.getMessage(), query));
        }
        
        return this.result;
    }
    
    public int executeUpdate(String query) throws Exception {
        int res = Integer.MIN_VALUE;
        try {
            res = getStatement().executeUpdate(query);
        }
        catch(Exception e) {
            throw new Exception(String.format("Error: %s - %s", e.getMessage(), query));
        }
        finally {
            this.Close();
        }
        
        return res;
    }
    
    public void Close() throws SQLException {
        if(this.result != null && !this.result.isClosed()) {
            this.result.close();
            this.result = null;
        }
        if(this.statement != null && !this.statement.isClosed()) {
            this.statement.close();
            this.statement = null;
        }
        if(this.connect != null && !this.connect.isClosed()) {
            this.connect.close();
            this.connect = null;
        }
    }
    
    public static void main(String[] args) throws Exception {
        mySQLConnect connect = new mySQLConnect("localhost", "root", "", "QUAN_LY_HOC_SINH");
        
        ResultSet result = connect.executeQuery("SELECT * FROM HOCSINH");

        ResultSetMetaData metadata = result.getMetaData();
        int columnCount = metadata.getColumnCount();
        
        for (int i=1; i<=columnCount; i++) {
 
            String columnName = metadata.getColumnName(i);

            System.out.println(columnName);

          }
        
//        while(result.next()) {
//            System.out.println(result.getObject("TEN"));
//        }
        result = connect.executeQuery("SELECT * FROM HOCSINH WHERE GIOITINH=1");
        System.out.println(result);
        connect.Close();
    }
    
}
