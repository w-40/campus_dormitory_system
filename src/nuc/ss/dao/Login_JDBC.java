package nuc.ss.dao;
/**
 * @author 王志凯
 * @description 登录数据访问层
 * systemControllerLogin(String username, String password)：查询并校验系统管理员账号密码数据
 * dormitoryControllerLogin(String username, String password)：查询并校验速速管理员账号密码数据
 * studentLogin(String username, String password)：查询并校验学生账号密码数据
 * 并将执行结果返回到登录业务层
 */

import java.sql.*;

public class Login_JDBC {
    public static boolean systemControllerLogin(String username, String password) throws Exception {
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
            if (rs.getString("账号").equals(username)&&rs.getString("密码").equals(password)){
                return true;
            }
        }
        // 7.释放资源
        con.close();
        stat.close();
        rs.close();
        return false;
    }

    public static boolean dormitoryControllerLogin(String username, String password) throws SQLException, ClassNotFoundException {
        // 1.导入jar包
        // 2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");//MySQL5版本后可以省略注册步骤
        // 3.获取连接
        Connection con = DriverManager.getConnection("jdbc:mysql://182.42.117.228:3306/campus_dormitory", "wzk", "2013040431");

        // 4.获取执行者对象
        Statement stat = con.createStatement();

        // 5. 执行sql语句，并且接收结果
        String sql = "SELECT * FROM 宿管信息表";
        ResultSet rs = stat.executeQuery(sql);
        // 6.处理结果
        //System.out.println(" 账号" + "\t    " + "密码");
        while (rs.next()) {
            if (rs.getString("工号").equals(username)&&rs.getString("密码").equals(password)){
                return true;
            }
        }
        // 7.释放资源
        con.close();
        stat.close();
        rs.close();
        return false;
    }

    public static boolean studentLogin(String username, String password) throws SQLException, ClassNotFoundException {
        // 1.导入jar包
        // 2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");//MySQL5版本后可以省略注册步骤
        // 3.获取连接
        Connection con = DriverManager.getConnection("jdbc:mysql://182.42.117.228:3306/campus_dormitory", "wzk", "2013040431");

        // 4.获取执行者对象
        Statement stat = con.createStatement();

        // 5. 执行sql语句，并且接收结果
        String sql = "SELECT * FROM 学生基本信息";
        ResultSet rs = stat.executeQuery(sql);
        // 6.处理结果
        while (rs.next()) {
            if (rs.getString("学号").equals(username)&&rs.getString("密码").equals(password)){
                return true;
            }
        }
        // 7.释放资源
        con.close();
        stat.close();
        rs.close();
        return false;
    }
}
