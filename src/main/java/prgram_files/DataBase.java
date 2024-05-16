package prgram_files;

import java.sql.*;

//This DataBase class provides a simple interface for interacting with a MySQL database
public class DataBase {
    private static Connection connection;
    private static String url ="";
    private static final String dbName="reservationsystem";

    private static void setUrl()
    {
        // this method use to Sets up the URL for connecting to the MySQL database
        url = "jdbc:mysql://localhost:3306/"+dbName+"?useUnicode=true&characterEncoding=UTF-8";
    }
    private static void setConnection() throws SQLException {
        //use to establishes a connection to the MySQL database using the previously set URL
        setUrl();
        connection = DriverManager.getConnection(url,"root","");
    }

    public static boolean executeQuery(String query)
    {
        //this method Takes an SQL query as a parameter and executes it on the database
        // , This method is suitable for non-select queries(INSERT, UPDATE, DELETE)
        try
        {
            setConnection();
            Statement statement = connection.createStatement();
            statement.execute(query);
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }
    public static ResultSet executeGetData(String query) throws SQLException {
        //Takes a select SQL query as a parameter, executes it on the database
        setConnection();
          Statement statement =connection.createStatement();
          ResultSet rs = statement.executeQuery(query);
          ResultSetMetaData rsMetaData = rs.getMetaData();
          return rs;

    }
}
