package com.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionMaker
{
    private String dbusername;
    private String dbpassword;
    private String DriverName;
    private String ConnectionString;
    public boolean isDbConnected;
    public Connection connection;

    public DatabaseConnectionMaker(String dbusername, String dbpassword, String DriverName, String ConnectionString)
    {
        this.dbusername=dbusername;
        this.dbpassword=dbpassword;
        this.ConnectionString=ConnectionString;
        this.DriverName=DriverName;
        this.isDbConnected=false;
    }

    public Connection dbConnectionCheck() throws SQLException, ClassNotFoundException {
        this.registerDriver();
        this.connection = DriverManager.getConnection(ConnectionString,dbusername,dbpassword);
        return connection;
    }

    public void registerDriver() throws ClassNotFoundException
    {
        Class.forName(this.DriverName);
    }
    public void dbConnectionClose(Connection conn) throws SQLException
    {
        if(!conn.isClosed())
        {
            conn.close();
        }
    }

}
