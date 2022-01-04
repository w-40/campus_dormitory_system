package nuc.ss.dao;

import nuc.ss.domain.Dorm;
import nuc.ss.domain.Dormitory;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author hsystart
 * @create 2021-12-28 18:33
 */
public class SystemController_DormManage_JDBC {
    public static ArrayList searchDorm() throws SQLException, ClassNotFoundException {
        ArrayList<Dorm> Dormlist = new ArrayList<Dorm>();
        int id;//宿舍号
        String dormitory = null; //宿舍楼名称
        int num;

        Dorm hs = null;
        // 1.导入jar包
        // 2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");//MySQL5版本后可以省略注册步骤
        // 3.获取连接
        Connection con = DriverManager.getConnection("jdbc:mysql://182.42.117.228:3306/campus_dormitory?useUnicode=true&characterEncoding=utf-8", "wzk", "2013040431");

        // 4.获取执行者对象
        Statement stat = con.createStatement();

        // 5. 执行sql语句，并且接收结果
        String sql = "SELECT * FROM 宿舍信息表";
        ResultSet rs = stat.executeQuery(sql);
        // 6.处理结果
        while (rs.next()) {
            id = rs.getInt("宿舍号");  //宿舍号
            dormitory = rs.getString("宿舍楼号");//宿舍楼名称
            num = rs.getInt("人数");
            hs = new Dorm(id, dormitory, num);
            Dormlist.add(hs);
        }
        // 7.释放资源
        con.close();
        stat.close();
        rs.close();
        return Dormlist;
    }

    public static boolean deleteDorm(String tid) throws SQLException, ClassNotFoundException {
        ArrayList<Dorm> Dormlist = new ArrayList<Dorm>();
        int id;//宿舍号
        String dormitory = null; //宿舍楼名称
        int num;

        Dorm hs = null;
        // 2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://182.42.117.228:3306/campus_dormitory?useUnicode=true&characterEncoding=utf-8";
        Connection con = DriverManager.getConnection(url, "wzk", "2013040431");
        String sql = "DELETE FROM 宿舍信息表 WHERE 宿舍号=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, tid);
        pstmt.executeUpdate();//执行删除SQL语句，数据库中即删掉一条记录
        // 释放资源
        con.close();
        return true;
    }

    public static boolean updateDorm(String val, String tid, ArrayList<String> dorimitoryList, int column) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://182.42.117.228:3306/campus_dormitory?useUnicode=true&characterEncoding=utf-8";
        Connection conn = DriverManager.getConnection(url, "wzk", "2013040431");
        String sql = "UPDATE 宿舍信息表 SET " + dorimitoryList.get(column) + " = ? WHERE 宿舍号 = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, val);
        pstmt.setString(2, tid);
        pstmt.executeUpdate();
        conn.close();
        return true;
    }

    public static boolean addDorm(Dorm Dorm) throws SQLException, ClassNotFoundException {
        int id = Dorm.getId();
        String dormitory = Dorm.getDormitoryId(); //宿舍楼号
        int num = Dorm.getNum();
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://182.42.117.228:3306/campus_dormitory?useUnicode=true&characterEncoding=utf-8";
        Connection conn = DriverManager.getConnection(url, "wzk", "2013040431");
        String sql = "insert into 宿舍信息表 values(?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.setString(2, dormitory);
        pstmt.setInt(3, num);
        pstmt.executeUpdate();
        conn.close();
        return true;
    }
}
