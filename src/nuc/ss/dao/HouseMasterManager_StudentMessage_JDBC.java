package nuc.ss.dao;
/**
 * @author 籍乃博, 王志凯稍作修改部分bug
 * @description 学生留言数据访问层
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nuc.ss.domain.Student;

public class HouseMasterManager_StudentMessage_JDBC {
    public static ArrayList searchStudentMessage() throws SQLException, ClassNotFoundException {
        ArrayList<Student> stl = new ArrayList<Student>();

        String id = null;//学号
        String message = null; //留言

        Student st = null;
        // 1.导入jar包
        // 2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");//MySQL5版本后可以省略注册步骤
        // 3.获取连接
        Connection con = DriverManager.getConnection("jdbc:mysql://182.42.117.228:3306/campus_dormitory?useUnicode=true&characterEncoding=utf-8", "jnb", "2013040432");

        // 4.获取执行者对象
        Statement stat = con.createStatement();

        // 5. 执行sql语句，并且接收结果
        String sql = "SELECT * FROM 留言管理";
        ResultSet rs = stat.executeQuery(sql);
        // 6.处理结果
        while (rs.next()) {
            id = rs.getString("学号");  //学号
            message = rs.getString("留言");//留言
            st = new Student(id, message);
            stl.add(st);
        }
        // 7.释放资源
        con.close();
        stat.close();
        rs.close();
        return stl;
    }

    public static boolean deleteStudentMessage(String tid, String message) throws SQLException, ClassNotFoundException {
        // 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://182.42.117.228:3306/campus_dormitory?useUnicode=true&characterEncoding=utf-8";
        Connection con = DriverManager.getConnection(url, "jnb", "2013040432");
        //String sql = "DELETE FROM 留言管理 WHERE 学号=?";
        String sql = "DELETE FROM 留言管理 WHERE 学号=? AND 留言=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, tid);
        pstmt.setString(2, message);
        pstmt.executeUpdate();//执行删除SQL语句，数据库中即删掉一条记录
        // 释放资源
        con.close();
        return true;
    }
}
