package com.sneakergo.common.constants;

/**
 * Created by Hung on 11/18/2016.
 */
public class SQLParamConstant {
    public static final String GET_REVENUE_EACH_MONTH = "SELECT DATE_FORMAT(date,'%m') AS period, sum(totalPrice) " +
            "AS revenue FROM Bill" +
            " WHERE enabled=true AND YEAR(date) =:year GROUP BY MONTH(date)";

    public static final String GET_STOCK_RECORDS = "SELECT s.attributeID as attributeID, s.productID as productID,s.quantity" +
            " as quantity, a.size as size, p.productName as productName " +
            "FROM attribute a,stock s, product p " +
            "WHERE a.attributeID=s.attributeID AND s.productID=p.productID AND s.enabled=true ORDER BY s.quantity ASC";


    public static final String GET_ALL_BILL_IN_TIME = "SELECT b.billID as billID, a.accountID as accountID," +
            " a.name as accountName, b.date as date, b.totalPrice as totalPrice,b.enabled as enabled " +
            "FROM bill b, account a " +
            "WHERE b.accountID=a.accountID AND b.date>=:fromDate AND b.date<=:toDate " +
            "ORDER BY b.date DESC";

    public static final String GET_ALL_SALE_BY_TIME = "SELECT s.saleID as saleID, p.productName as productName, s.salePercent as salePercent, s.fromDate as fromDate, s.toDate as toDate, s.enabled as enabled " +
            "FROM sale s, product p " +
            "WHERE s.productID=p.productID AND s.fromDate<=:toDate AND s.toDate>=:fromDate";

    public static final String GET_ALL_IMPORT_IN_TIME = "SELECT i.importID as importID, p.productName as productName, " +
            "a.size as size, i.quantity as quantity, i.price as price, " +
            "i.importDate as importDate, i.Supplier as supplier, i.quantity*i.price as total " +
            "FROM import i,stock s,product p,attribute a " +
            "WHERE i.stockID=s.stockID AND s.productID=p.productID AND s.attributeID=a.attributeID " +
            "AND i.importDate>=:fromDate AND i.importDate<=:toDate";

    public static final String GET_BILL_DETAIL_OF_BILL="SELECT p.productName as productName,a.size as size, b.price as price, " +
            "b.quantity as quantity, b.price*b.quantity as total " +
            "FROM billdetail b,product p,stock s,attribute a " +
            "WHERE b.stockID=s.stockID AND b.billID=:billID AND s.productID=p.productID AND s.attributeID=a.attributeID";

    public static final String GET_TOP_PRODUCT="SELECT p.productID as productID, SUM(d.quantity) as quantity " +
            "FROM product p,billdetail d,stock s,bill b " +
            "WHERE p.productID=s.productID AND s.stockID=d.stockID " +
            "AND b.billID=d.billID AND YEAR(b.date)=:year " +
            "GROUP BY p.productID ORDER BY quantity DESC";
}
