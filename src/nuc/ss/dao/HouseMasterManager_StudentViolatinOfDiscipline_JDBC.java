package nuc.ss.dao;
/**
 * @author 籍乃博，王志凯稍作修改部分bug
 * @description 学生违纪信息表数据访问层
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nuc.ss.domain.StudentViolationOfDiscipline;

public class HouseMasterManager_StudentViolatinOfDiscipline_JDBC {
    public static ArrayList searchStudentViolatinOfDiscipline() {
        Connection con = null;
        Statement stat = null;
        ResultSet rs = null;
        ArrayList<StudentViolationOfDiscipline> svodlist = new ArrayList<StudentViolationOfDiscipline>();

        String id = null;//学号
        String name = null; //姓名
        int dormId = 0; //宿舍号
        String content = null; //违纪内容
        String time = null; //违纪时间

        StudentViolationOfDiscipline svod = null;
        // 1.导入jar包
        // 2.注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");//MySQL5版本后可以省略注册步骤 // 3.获取连接
            con = DriverManager.getConnection("jdbc:mysql://182.42.117.228:3306/campus_dormitory?useUnicode=true&characterEncoding=utf-8", "jnb", "2013040432");

            // 4.获取执行者对象
            stat = con.createStatement();

            // 5. 执行sql语句，并且接收结果
            String sql = "SELECT 学生基本信息.`学号`,姓名,宿舍号,违纪内容,违纪时间\r\n"
                    + "FROM 学生基本信息, 学生违纪信息表 \r\n"
                    + "WHERE 学生基本信息.`学号`  = `学生违纪信息表`.`学号`";
            rs = stat.executeQuery(sql);
            // 6.处理结果
            while (rs.next()) {
                id = rs.getString("学号");  //学号
                name = rs.getString("姓名");//姓名
                dormId = rs.getInt("宿舍号");//宿舍号
                content = rs.getString("违纪内容");// 违纪内容
                time = rs.getString("违纪时间"); //违纪时间
                svod = new StudentViolationOfDiscipline(id, name, dormId, content, time);
                svodlist.add(svod);
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
        return svodlist;
    }

    public static boolean deleteStudentViolationOfDiscipline(String tid) {
        Connection con = null;
        PreparedStatement pstmt = null;
        // 注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://182.42.117.228:3306/campus_dormitory?useUnicode=true&characterEncoding=utf-8";
            con = DriverManager.getConnection(url, "jnb", "2013040432");
            String sql = "DELETE FROM 学生违纪信息表 WHERE 学号=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, tid);
            pstmt.executeUpdate();//执行删除SQL语句，数据库中即删掉一条记录
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        // 释放资源
        return true;
    }

    public static boolean updateStudentViolationOfDiscipline(String val, String
            tid, ArrayList<String> tableHeadList, int column) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://182.42.117.228:3306/campus_dormitory?useUnicode=true&characterEncoding=utf-8";
            conn = DriverManager.getConnection(url, "jnb", "2013040432");
            String sql = "UPDATE 学生违纪信息表 SET " + tableHeadList.get(column) + " = ? WHERE 学号 = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, val);
            pstmt.setString(2, tid);
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

    public static boolean addStudentViolationOfDiscipline(StudentViolationOfDiscipline svod) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String id = svod.getId();
        String content = svod.getContent();
        String time = svod.getTime();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://182.42.117.228:3306/campus_dormitory?useUnicode=true&characterEncoding=utf-8";
            conn = DriverManager.getConnection(url, "jnb", "2013040432");
            String sql = "insert into 学生违纪信息表 values(?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, content);
            pstmt.setString(3, time);
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
}
