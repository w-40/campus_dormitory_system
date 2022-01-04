package nuc.ss.dao;
/**
 * @author 段福泉
 * @description 分配宿舍
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AllocateDormitory_JDBC {

    public static boolean allocateDormitory(String username, String l1, String l2, String l3) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://182.42.117.228:3306/campus_dormitory?useUnicode=true&characterEncoding=utf-8";
            conn = DriverManager.getConnection(url, "wzk", "2013040431");
            String sql = "UPDATE 学生基本信息 SET 宿舍楼号 = ?,宿舍号 = ?,床位 = ? WHERE 学号 = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, l1);
            pstmt.setString(2, l2);
            pstmt.setString(3, l3);
            pstmt.setString(4, username);
            pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return true;
    }

    public static boolean updateDormitory(String l1, String l2) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://182.42.117.228:3306/campus_dormitory?useUnicode=true&characterEncoding=utf-8";
            conn = DriverManager.getConnection(url, "wzk", "2013040431");
            String sql = "UPDATE `宿舍信息表` SET 人数 = 人数 + 1 WHERE 宿舍楼号 = ? AND 宿舍号 = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, l1);
            pstmt.setString(2, l2);
            pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return true;
    }


    public static boolean searchDormitory(String l1, String l2, String l3) {

        Connection con = null;
        Statement stat = null;
        ResultSet rs = null;

        // 2.注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");//MySQL5版本后可以省略注册步骤
            // 3.获取连接
            con = DriverManager.getConnection("jdbc:mysql://182.42.117.228:3306/campus_dormitory", "wzk", "2013040431");

            // 4.获取执行者对象
            stat = con.createStatement();

            // 5. 执行sql语句，并且接收结果
            String sql = "select * from 学生基本信息 where 宿舍楼号 = ? AND 宿舍号 = ? AND 床位 = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, l1);
            pstmt.setString(2, l2);
            pstmt.setString(3, l3);
            rs = pstmt.executeQuery();//执行SQL查询语句
            if (rs.next()) {
                return true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
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
}
