package database;

import java.sql.*;

public class JDBCClass {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

       String serverName = "rds-qa-thadb.ccj7tvd1f9lb.us-east-1.rds.amazonaws.com";
       String port = "1433";
       String user = "prowessqa";
       String pass = "NewAvon@Prowess_qa";
       String Name = "ACM";

        String query = "SELECT beeNumber, bc.emailAddress, bbi.acctType\n" +
                "FROM beebusiness bb\n" +
                "INNER JOIN beebusinessInformation bbi ON bbi.beebusinessGuid = bb.beebusinessguid\n" +
                "INNER JOIN beeCommunication bc ON bc.beeEntityGuid = bb.beeEntityGuid\n" +
                "where bc.emailAddress = ?";

        String url = "jdbc:sqlserver://"+serverName+":"+port+";databaseName=ACM;user="+user+";password="+pass;
        conn = DriverManager.getConnection(url);
        statement = conn.prepareStatement(query);
        statement.setString(1,"newavon16@rep.com");
        rs = statement.executeQuery();
        while(rs.next()){
            String acct = rs.getString("AcctType");
            System.out.println(acct);
        }
        rs.close();
    }
}
