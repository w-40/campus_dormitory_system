package nuc.ss.dao;
/**
 * @author 段福泉
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nuc.ss.domain.Student;
import nuc.ss.domain.StudentViolationOfDiscipline;

public class SystemController_Student_JDBC {
    public static Student student(String username) throws SQLException, ClassNotFoundException {

        Student st = null;

        String id;//学号
        String password; //密码
        String name;//姓名
        char sex;//性别
        String grade;//年级
        String dormitoryBudingId;//宿舍楼号
        String dormitoryId;//宿舍号
        int bed;//床位
        String phoneNumber;//联系电话
        // 1.导入jar包
        // 2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");//MySQL5版本后可以省略注册步骤
        // 3.获取连接
        Connection con = DriverManager.getConnection("jdbc:mysql://182.42.117.228:3306/campus_dormitory?useUnicode=true&characterEncoding=utf-8", "dfq", "2013040428");

        // 4.获取执行者对象
        Statement stat = con.createStatement();

        // 5. 执行sql语句，并且接收结果
        String sql = "select * from 学生基本信息 where 学号=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, username);
        ResultSet rs = pstmt.executeQuery();//执行SQL查询语句
        //6.处理结果
        while (rs.next()) {
            id = rs.getString("学号");
            password = rs.getString("密码");
            name = rs.getString("姓名");
            sex = rs.getString("性别").charAt(0);
            grade = rs.getString("年级");
            dormitoryBudingId = rs.getString("宿舍楼号");
            dormitoryId = rs.getString("宿舍号");
            bed = rs.getInt("床位");
            phoneNumber = rs.getString("联系电话");
            st = new Student(id, password, name, sex, grade, dormitoryBudingId, dormitoryId, bed, phoneNumber);
        }

        // 7.释放资源
        con.close();
        stat.close();
        rs.close();
        return st;

    }

    public static ArrayList studentViolation(String username) throws SQLException, ClassNotFoundException {
        ArrayList<StudentViolationOfDiscipline> stlist = new ArrayList<StudentViolationOfDiscipline>();
        StudentViolationOfDiscipline st = null;

        String id;//学号
        String content;
        String time;
        // 1.导入jar包
        // 2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");//MySQL5版本后可以省略注册步骤
        // 3.获取连接
        Connection con = DriverManager.getConnection("jdbc:mysql://182.42.117.228:3306/campus_dormitory", "dfq", "2013040428");

        // 4.获取执行者对象
        Statement stat = con.createStatement();

        // 5. 执行sql语句，并且接收结果
        String sql = "select * from 学生违纪信息表 where 学号=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, username);
        ResultSet rs = pstmt.executeQuery();//执行SQL查询语句
        //6.处理结果
        while (rs.next()) {
            id = rs.getString("学号");
            content = rs.getString("违纪内容");
            time = rs.getString("违纪时间");
            st = new StudentViolationOfDiscipline(id, content, time);
            stlist.add(st);

        }

        // 7.释放资源
        con.close();
        stat.close();
        rs.close();
        return stlist;
    }

    public static boolean addMessage(Student st) throws SQLException, ClassNotFoundException {
        String id = st.getId();
        String message = st.getMessage();
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://182.42.117.228:3306/campus_dormitory?useUnicode=true&characterEncoding=utf-8";
        Connection conn = DriverManager.getConnection(url, "dfq", "2013040428");
        String sql = "insert into 留言管理 values(?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
        pstmt.setString(2, message);
        pstmt.executeUpdate();
        conn.close();
        return true;
    }

    public static boolean updatePassword(String username, String password) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://182.42.117.228:3306/campus_dormitory?useUnicode=true&characterEncoding=utf-8";
        Connection conn = DriverManager.getConnection(url, "dfq", "2013040428");
        String sql = "UPDATE 学生基本信息 SET 密码 = ? WHERE 学号 = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, password);
        pstmt.setString(2, username);
        pstmt.executeUpdate();
        conn.close();
        return true;
    }

    public static boolean updateNum(String username, String num) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://182.42.117.228:3306/campus_dormitory?useUnicode=true&characterEncoding=utf-8";
        Connection conn = DriverManager.getConnection(url, "dfq", "2013040428");
        String sql = "UPDATE 学生基本信息 SET 联系电话 = ? WHERE 学号 = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, num);
        pstmt.setString(2, username);
        pstmt.executeUpdate();
        conn.close();
        return true;
    }


}
