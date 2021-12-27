package nuc.ss.dao;
/**
 * @author 王志凯，卫黎明
 * @description 宿舍楼信息表数据访问层
 * searchHouseMaster()：利用JDBC从数据库中查询数据，并将数据用学生对象封装，再用ArrayList集合封装后传给宿管管理业务层
 * deleteHouseMaster(String tid)：将tid对应的数据删除
 * updateHouseMaster(String val, String tid, ArrayList<String> dorimitoryList, int column)：修改数据库中的数据
 * addHouseMaster(HouseMaster houseMaster) 
 */

import nuc.ss.domain.Dormitory;

import java.sql.*;
import java.util.ArrayList;


public class SystemController_DormitoryManage_JDBC {
    public static ArrayList searchDormitory() throws SQLException, ClassNotFoundException {
        ArrayList<Dormitory> dormitorylist = new ArrayList<Dormitory>();
        String id = null;//宿舍楼号
        String name = null; //宿舍楼名称
        
        Dormitory hs = null;
        // 1.导入jar包
        // 2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");//MySQL5版本后可以省略注册步骤
        // 3.获取连接
        Connection con = DriverManager.getConnection("jdbc:mysql://182.42.117.228:3306/campus_dormitory", "wzk", "2013040431");

        // 4.获取执行者对象
        Statement stat = con.createStatement();

        // 5. 执行sql语句，并且接收结果
        String sql = "SELECT * FROM 宿舍楼信息表";
        ResultSet rs = stat.executeQuery(sql);
        // 6.处理结果
        while (rs.next()) {
            id = rs.getString("宿舍楼号");  //宿舍楼号
            name = rs.getString("宿舍楼名称");//宿舍楼名称
            hs = new Dormitory(id, name);
            dormitorylist.add(hs);
        }
        // 7.释放资源
        con.close();
        stat.close();
        rs.close();
        return dormitorylist;
    }

    public static boolean deleteDormitory(String tid) throws SQLException, ClassNotFoundException {
        ArrayList<Dormitory> dormitorylist = new ArrayList<Dormitory>();
        String id = null;//工号
        String name = null; //姓名

        Dormitory hs = null;
        // 2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://182.42.117.228:3306/campus_dormitory?useUnicode=true&characterEncoding=utf-8";
        Connection con = DriverManager.getConnection(url, "wzk", "2013040431");
        String sql = "DELETE FROM 宿舍楼信息表 WHERE 宿舍楼号=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, tid);
        pstmt.executeUpdate();//执行删除SQL语句，数据库中即删掉一条记录
        // 释放资源
        con.close();
        return true;
    }

    public static boolean updateDormitory(String val, String tid, ArrayList<String> dorimitoryList, int column) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://182.42.117.228:3306/campus_dormitory?useUnicode=true&characterEncoding=utf-8";
        Connection conn = DriverManager.getConnection(url, "wzk", "2013040431");
        String sql = "UPDATE 宿舍楼信息表 SET " + dorimitoryList.get(column) + " = ? WHERE 宿舍楼号 = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, val);
        pstmt.setString(2, tid);
        pstmt.executeUpdate();
        conn.close();
        return true;
    }

    public static boolean addDormitory(Dormitory dormitory) throws SQLException, ClassNotFoundException {
        String id = dormitory.getId();
        String name = dormitory.getName();
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://182.42.117.228:3306/campus_dormitory?useUnicode=true&characterEncoding=utf-8";
        Connection conn = DriverManager.getConnection(url, "wzk", "2013040431");
        String sql = "insert into 宿舍楼信息表 values(?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
        pstmt.setString(2, name);
        pstmt.executeUpdate();
        conn.close();
        return true;
    }
}


