package HLDataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HLDataHelper {
    private static String DBPathConnection = "jdbc:sqlite:DataBase//HLEcuaFauna2K24A.sqlie";
    private static Connection conn = null;
    // protected SQLiteDataHelper(){}

    protected static synchronized Connection openConnection() throws Exception{
        try{
            if(conn == null)
                conn = DriverManager.getConnection(DBPathConnection);
        }catch(SQLException e){
            throw e;
        }
        return conn;
    }

    protected static void closeConnection() throws Exception{
        try {
            if (conn != null) 
                conn.close();
        } catch (Exception e) {
            throw e;
        }
    }
}


