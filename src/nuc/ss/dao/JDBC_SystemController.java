package nuc.ss.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC_SystemController {
    public static void main(String[] args) throws Exception {
        // 1.导入jar包
        // 2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");//MySQL5版本后可以省略注册步骤
        // 3.获取连接
        Connection con = DriverManager.getConnection("jdbc:mysql://182.42.117.228:3306/campus_dormitory", "wzk", "2013040431");

        // 4.获取执行者对象
        Statement stat = con.createStatement();

        // 5. 执行sql语句，并且接收结果
        String sql = "SELECT * FROM 系统管理员信息";
        ResultSet rs = stat.executeQuery(sql);
        // 6.处理结果
        //System.out.println(" 账号" + "\t    " + "密码");
        while (rs.next()) {
            System.out.println(rs.getString("账号") + "\t"
                    + rs.getString("密码"));
        }
        // 7.释放资源
        con.close();
        stat.close();
        rs.close();
    }
}
