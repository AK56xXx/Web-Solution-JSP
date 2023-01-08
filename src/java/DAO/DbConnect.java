package DAO;


import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AK
 */
public class DbConnect {
    protected Connection conn;
    protected Statement st;
    private String serverName="localhost";
    private String portName="3306";
    private String databaseName="netbeans";
    private String url ="jdbc:mysql://localhost:3306/"+ databaseName;
    private String username = "root";
    private String password ="";
    private String errString;

    public DbConnect() {
    }

    public Connection getConn() {
        conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
           conn= DriverManager.getConnection(getUrl(), username,password);
           st=conn.createStatement();
            System.out.println("Connect");
        }catch(Exception e){
            System.out.println("Error message");
            System.out.println(errString);
            return null;         
            
        }
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Statement getSt() {
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getErrString() {
        return errString;
    }

    public void setErrString(String errString) {
        this.errString = errString;
    }
    
    
     
    
}
