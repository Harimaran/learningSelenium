package database;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.*;

public class Database extends DBDetails{

    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;

//    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
//        Database db = new Database();
//        db.connectToDB();
//        db.executeQuery("newavon@rep.com");
//        db.getResultFromQuery("AcctType");
//    }
    public static Database databaseAccess(){
        return new Database();
    }

    public void  connectToDB() throws SQLException {
        String url = "jdbc:sqlserver://"+serverName+":"+port+";databaseName=ACM;user="+user+";password="+pass;
        conn = DriverManager.getConnection(url);
    }

    private static void connect2DB() throws SQLServerException {
        //DataSource method

        SQLServerDataSource dbs = new SQLServerDataSource();
        dbs.setServerName(serverName);
        dbs.setPortNumber(Integer.parseInt(port));
        dbs.setDatabaseName(Name);
        dbs.setUser(user);
        dbs.setPassword(pass);
        Connection conn = dbs.getConnection();

    }

    public void executeQuery(String valueToQuery) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //executeQuery
        statement = conn.prepareStatement(QueryRepo.query);
        statement.setString(1,valueToQuery);
        rs = statement.executeQuery();
    }
    public void executeQuery(String query, String valueToQuery) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //executeQuery
        statement = conn.prepareStatement(query);
        statement.setString(1,valueToQuery);
        rs = statement.executeQuery();
    }

    public  String getResultFromQuery(String columnName) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //get Specific Value from Query
        String valueFromQuery = null;
        while(rs.next()){
            valueFromQuery = rs.getString(columnName);
        }
        return valueFromQuery;
    }

//    public static void closeDB() throws SQLException {
//        if(conn!= null){
//            conn.close();
//            System.out.println("Connection closed");
//        }
//    }
}
