package cn.zhku.waterfowl.modules.transportation.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @Author： 成君 943193747@qq.com .
 * @Date： 2018/1/28 0028  17:30.
 */
public class DbUtil {
    private static String dbUrl="jdbc:mysql://localhost:3306/waterfowl";
    private static String dbUserName="root";
    private static String dbPassword="123";
    private static String jdbcName="com.mysql.jdbc.Driver";

    /**
     * 获取数据库连接
     * @return
     * @throws Exception
     */
    public static Connection getCon() throws Exception{
        Class.forName(jdbcName);
        Connection con= DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
        return con;
    }

    /**
     * 关闭数据库连接
     * @param con
     * @throws Exception
     */
    public static void closeCon(Connection con) throws Exception{
        if(con!=null){
            con.close();
        }
    }

}
