
package com.mycompany.Util;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBContext {
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123456789";
    private static final String SERVER_NAME = "localhost";
    private static final String PORT = "1433";
    private static final String DATABASE_NAME = "SHOP_BAN_GIAY_TEAM2_PRO1041";
    private static final boolean USING_SSL = true;

    private static String CONNECT_STRING;

    static {
        try {
            DriverManager.registerDriver(new SQLServerDriver());
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            StringBuilder connectStringBuilder = new StringBuilder();
            connectStringBuilder.append("jdbc:sqlserver://")
                    .append(SERVER_NAME).append(":").append(PORT).append(";")
                    .append("databaseName=").append(DATABASE_NAME).append(";")
                    .append("user=").append(USERNAME).append(";")
                    .append("password=").append(PASSWORD).append(";");
            if (USING_SSL) {
                connectStringBuilder.append("encrypt=true;trustServerCertificate=true;");
            }
            CONNECT_STRING = connectStringBuilder.toString();
            System.out.println("Connect String có dạng: " + CONNECT_STRING);
        } catch (Exception ex) {
            //Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONNECT_STRING);
    }

    public static void main(String[] args) throws SQLException {
        Connection conn = getConnection();
        String dbpn = conn.getMetaData().getDatabaseProductName();
        System.out.println(dbpn);
        
    }
}
