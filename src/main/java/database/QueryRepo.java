package database;

public class QueryRepo {

    public static String query = "SELECT beeNumber, bc.emailAddress, bbi.AcctType\n" +
            "FROM beebusiness bb\n" +
            "INNER JOIN beebusinessInformation bbi ON bbi.beebusinessGuid = bb.beebusinessguid\n" +
            "INNER JOIN beeCommunication bc ON bc.beeEntityGuid = bb.beeEntityGuid\n" +
            "where bc.emailAddress = ?";

    public static String OrderQuery = "SELECT \n" +
            "o.OrderNumber,\n" +
            "po.OrderTypeID,\n" +
            "bb.BEENUMBER,\n" +
            "os.FriendlyName AS [OrderStatus]\n" +
            "FROM [Order] o\n" +
            "INNER JOIN POEOrders po ON po.OrderId = o.OrderId\n" +
            "Inner JOIN OrderStatus os ON os.OrderStatusId = o.OrderStatusId\n" +
            "Inner JOIN POEOrderTotal pot ON pot.OrderId = o.OrderId\n" +
            "Inner Join beebusiness bb on bb.BEEBUSINESSGUID = o.BeeBusinessGuidCustomer\n" +
            "--where bbic.beeNumber = '17521078';\n" +
            "--where po.orderTypeId = 'Rep.MISSINGBOX';\n" +
            "where o.OrderNumber in (\n" +
            "?\n" +
            ")";


}
