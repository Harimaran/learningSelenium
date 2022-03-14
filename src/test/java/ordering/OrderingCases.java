package ordering;

import database.Database;
import database.QueryRepo;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class OrderingCases {

    @Test(priority = 3)
    public void CheckOrderInDB() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Database con2DB = Database.databaseAccess();
        con2DB.connectToDB();
        con2DB.executeQuery(QueryRepo.OrderQuery,"512441431");
        String result = con2DB.getResultFromQuery("OrderStatus");
        System.out.println(result);
        Assert.assertEquals(result,"Closed");
    }
}
