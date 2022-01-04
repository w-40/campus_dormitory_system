package nuc.ss.dao;
/**
 * @author 王志凯, 段福泉
 * @description 登录数据访问层
 * systemControllerLogin(String username, String password)：查询并校验系统管理员账号密码数据
 * dormitoryControllerLogin(String username, String password)：查询并校验速速管理员账号密码数据
 * studentLogin(String username, String password)：查询并校验学生账号密码数据
 * 并将执行结果返回到登录业务层
 */

import java.sql.*;
import java.util.ArrayList;

import nuc.ss.domain.HouseMaster;
import nuc.ss.domain.Student;

public class Login_JDBC {
    public static boolean systemControllerLogin(String username, String password) {
        Connection con = null;
        Statement stat = null;
        ResultSet rs = null;
        // 1.导入jar包
        // 2.注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");//MySQL5版本后可以省略注册步骤
            // 3.获取连接
            con = DriverManager.getConnection("jdbc:mysql://182.42.117.228:3306/campus_dormitory?useUnicode=true&characterEncoding=utf-8", "wzk", "2013040431");

            // 4.获取执行者对象
            stat = con.createStatement();

            // 5. 执行sql语句，并且接收结果
            String sql = "SELECT * FROM 系统管理员信息";
            rs = stat.executeQuery(sql);
            // 6.处理结果
            //System.out.println(" 账号" + "\t    " + "密码");
            while (rs.next()) {
                if (rs.getString("账号").equals(username) && rs.getString("密码").equals(password)) {
                    return true;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        // 7.释放资源
        finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (stat != null) {
                    stat.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    public static boolean dormitoryControllerLogin(String username, String password) {
        Connection con = null;
        Statement stat = null;
        ResultSet rs = null;
        // 1.导入jar包
        // 2.注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");//MySQL5版本后可以省略注册步骤
            // 3.获取连接
            con = DriverManager.getConnection("jdbc:mysql://182.42.117.228:3306/campus_dormitory", "wzk", "2013040431");

            // 4.获取执行者对象
            stat = con.createStatement();

            // 5. 执行sql语句，并且接收结果
            String sql = "SELECT * FROM 宿管信息表";
            rs = stat.executeQuery(sql);
            // 6.处理结果
            //System.out.println(" 账号" + "\t    " + "密码");
            while (rs.next()) {
                if (rs.getString("工号").equals(username) && rs.getString("密码").equals(password)) {
                    return true;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        // 7.释放资源
        finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (stat != null) {
                    stat.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    public static boolean studentLogin(String username, String password) {
        Connection con = null;
        Statement stat = null;
        ResultSet rs = null;
        // 1.导入jar包
        // 2.注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");//MySQL5版本后可以省略注册步骤
            // 3.获取连接
            con = DriverManager.getConnection("jdbc:mysql://182.42.117.228:3306/campus_dormitory", "wzk", "2013040431");

            // 4.获取执行者对象
            stat = con.createStatement();

            // 5. 执行sql语句，并且接收结果
            String sql = "SELECT * FROM 学生基本信息";
            rs = stat.executeQuery(sql);
            // 6.处理结果
            while (rs.next()) {
                if (rs.getString("学号").equals(username) && rs.getString("密码").equals(password)) {
                    return true;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        // 7.释放资源
        finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (stat != null) {
                    stat.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    public static String studentName(String username) {
        Connection con = null;
        Statement stat = null;
        ResultSet rs = null;
        String name = null;
        // 1.导入jar包
        // 2.注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");//MySQL5版本后可以省略注册步骤
            // 3.获取连接
            con = DriverManager.getConnection("jdbc:mysql://182.42.117.228:3306/campus_dormitory", "dfq", "2013040428");

            // 4.获取执行者对象
            stat = con.createStatement();

            // 5. 执行sql语句，并且接收结果
            String sql = "select 姓名 from 学生基本信息 where 学号=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();//执行SQL查询语句
            //6.处理结果
            while (rs.next()) {
                name = rs.getString("姓名");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        // 7.释放资源
        finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (stat != null) {
                    stat.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return name;

    }
}
