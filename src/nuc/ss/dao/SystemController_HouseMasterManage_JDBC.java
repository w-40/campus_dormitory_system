package nuc.ss.dao;
/**
 * @author 王志凯，卫黎明
 * @description 宿管信息表数据访问层
 * searchHouseMaster()：利用JDBC从数据库中查询数据，并将数据用学生对象封装，再用ArrayList集合封装后传给宿管管理业务层
 * deleteHouseMaster(String tid)：将tid对应的数据删除
 * updateHouseMaster(String val, String tid, ArrayList<String> tableHeadList, int column)：修改数据库中的数据
 * addHouseMaster(HouseMaster houseMaster) 利用得到的宿管对象添加宿管信息
 */
import nuc.ss.domain.HouseMaster;

import java.sql.*;
import java.util.ArrayList;

public class SystemController_HouseMasterManage_JDBC {
    public static ArrayList searchHouseMaster() throws SQLException, ClassNotFoundException {
        ArrayList<HouseMaster> houseMasterslist = new ArrayList<HouseMaster>();
        String id = null;//工号
        String password = null;
        String name = null; //姓名
        char sex = 0;//性别
        String dormitoryId = null; //管理宿舍楼号
        String phoneNumber = null; //联系电话

        HouseMaster hs = null;
        // 1.导入jar包
        // 2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");//MySQL5版本后可以省略注册步骤
        // 3.获取连接
        Connection con = DriverManager.getConnection("jdbc:mysql://182.42.117.228:3306/campus_dormitory?useUnicode=true&characterEncoding=utf-8", "wzk", "2013040431");

        // 4.获取执行者对象
        Statement stat = con.createStatement();

        // 5. 执行sql语句，并且接收结果
        String sql = "SELECT * FROM 宿管信息表";
        ResultSet rs = stat.executeQuery(sql);
        // 6.处理结果
        while (rs.next()) {
            id = rs.getString("工号");  //工号
            password = rs.getString("密码");
            name = rs.getString("姓名");//姓名
            sex = rs.getString("性别").charAt(0); //性别
            dormitoryId = rs.getString("管理宿舍楼号");//管理宿舍楼号
            phoneNumber = rs.getString("联系电话");//联系电话
            hs = new HouseMaster(id, password, name, sex, dormitoryId, phoneNumber);
            houseMasterslist.add(hs);
        }
        // 7.释放资源
        con.close();
        stat.close();
        rs.close();
        return houseMasterslist;
    }

    public static boolean deleteHouseMaster(String tid) throws SQLException, ClassNotFoundException {
        ArrayList<HouseMaster> houseMasterslist = new ArrayList<HouseMaster>();
        String id = null;//工号
        String password = null;
        String name = null; //姓名
        char sex = 0;//性别
        String dormitoryId = null; //管理宿舍楼号
        String phoneNumber = null; //联系电话

        HouseMaster hs = null;
        // 2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://182.42.117.228:3306/campus_dormitory?useUnicode=true&characterEncoding=utf-8";
        Connection con = DriverManager.getConnection(url, "wzk", "2013040431");
        String sql = "DELETE FROM 宿管信息表 WHERE 工号=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, tid);
        pstmt.executeUpdate();//执行删除SQL语句，数据库中即删掉一条记录
        // 释放资源
        con.close();
        return true;
    }

    public static boolean updateHouseMaster(String val, String tid, ArrayList<String> tableHeadList, int column) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://182.42.117.228:3306/campus_dormitory?useUnicode=true&characterEncoding=utf-8";
        Connection conn = DriverManager.getConnection(url, "wzk", "2013040431");
        String sql = "UPDATE 宿管信息表 SET " + tableHeadList.get(column) + " = ? WHERE 工号 = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, val);
        pstmt.setString(2, tid);
        pstmt.executeUpdate();
        conn.close();
        return true;
    }

    public static boolean updateSetHouseMaster(String val, String tid, ArrayList<String> tableHeadList, int column) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://182.42.117.228:3306/campus_dormitory?useUnicode=true&characterEncoding=utf-8";
        Connection conn = DriverManager.getConnection(url, "wzk", "2013040431");
        String sql = "UPDATE 宿管信息表 SET " + tableHeadList.get(column) + " = ? WHERE 工号 = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, val);
        pstmt.setString(2, tid);
        pstmt.executeUpdate();
        conn.close();
        return true;
    }

    public static boolean addHouseMaster(HouseMaster houseMaster) throws SQLException, ClassNotFoundException {
        String id = houseMaster.getId();
        String name = houseMaster.getName();
        String password = houseMaster.getPassword();
        char sex = houseMaster.getSex();
        String dormitoryId = houseMaster.getDormitoryId();
        String phoneNumber = houseMaster.getPhoneNumber();
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://182.42.117.228:3306/campus_dormitory?useUnicode=true&characterEncoding=utf-8";
        Connection conn = DriverManager.getConnection(url, "wzk", "2013040431");
        String sql = "insert into 宿管信息表 values(?,?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
        pstmt.setString(2, name);
        pstmt.setString(3, password);
        pstmt.setString(4, sex + "");
        pstmt.setString(5, dormitoryId);
        pstmt.setString(6, phoneNumber);
        pstmt.executeUpdate();
        conn.close();
        return true;
    }
}


