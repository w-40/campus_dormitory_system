package nuc.ss.dao;

import nuc.ss.domain.Visitor;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author 娄靖彬
 */
public class SystemController_VisitorManage_JDBC {
    public static ArrayList searchVisitor() throws SQLException, ClassNotFoundException {
        ArrayList<Visitor> visitorslist = new ArrayList<Visitor>();
        String visitMatters = null;//来访事宜
        String tel = null;//联系方式
        String name = null; //姓名
        String time = null; //来访时间
        String identity = null; //身份

        Visitor vd = null;
        // 1.导入jar包
        // 2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");//MySQL5版本后可以省略注册步骤
        // 3.获取连接
        Connection con = DriverManager.getConnection("jdbc:mysql://182.42.117.228:3306/campus_dormitory?useUnicode=true&characterEncoding=utf-8", "wzk", "2013040431");

        // 4.获取执行者对象
        Statement stat = con.createStatement();

        // 5. 执行sql语句，并且接收结果
        String sql = "SELECT * FROM 访客信息表 ORDER BY 来访时间";
        ResultSet rs = stat.executeQuery(sql);
        // 6.处理结果
        while (rs.next()) {
            name = rs.getString("姓名");
            tel = rs.getString("联系方式");
            time = rs.getString("来访时间");
            visitMatters = rs.getString("来访事宜");
            identity = rs.getString("身份"); //性别
            vd = new Visitor(name, tel, time, visitMatters, identity);
            visitorslist.add(vd);
        }
        // 7.释放资源
        con.close();
        stat.close();
        rs.close();
        return visitorslist;
    }

//    public static boolean deleteVisitor(String tid) throws SQLException, ClassNotFoundException {
//        ArrayList<Visitor> visitorslist = new ArrayList<Visitor>();
//        String visitMatters = null;//来访事宜
//        String tel = null;//联系方式
//        String name = null; //姓名
//        String time = null; //来访时间
//        String identity = null; //身份
//        Visitor vd = null;
//        // 2.注册驱动
//        Class.forName("com.mysql.jdbc.Driver");
//        String url = "jdbc:mysql://182.42.117.228:3306/campus_dormitory?useUnicode=true&characterEncoding=utf-8";
//        Connection con = DriverManager.getConnection(url, "wzk", "2013040431");
//        String sql = "DELETE FROM 访客信息表 WHERE 姓名=?";
//        PreparedStatement pstmt = con.prepareStatement(sql);
//        pstmt.setString(1, tid);
//        pstmt.executeUpdate();//执行删除SQL语句，数据库中即删掉一条记录
//        // 释放资源
//        con.close();
//        return true;
//    }

    public static boolean updateVisitor(String val, String tid, ArrayList<String> tableHeadList, int column) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://182.42.117.228:3306/campus_dormitory?useUnicode=true&characterEncoding=utf-8";
        Connection conn = DriverManager.getConnection(url, "wzk", "2013040431");
        String sql = "UPDATE 访客信息表 SET " + tableHeadList.get(column) + " = ? WHERE 姓名 = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, val);
        pstmt.setString(2, tid);
        pstmt.executeUpdate();
        conn.close();
        return true;
    }

    public static boolean addVisitor(Visitor Visitor) throws SQLException, ClassNotFoundException {
        String tel = Visitor.getTel();
        String visitMatters = Visitor.getVisitMatters();
        String name = Visitor.getName();
        String identity = Visitor.getIdentity();
        String time = Visitor.getTime();
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://182.42.117.228:3306/campus_dormitory?useUnicode=true&characterEncoding=utf-8";
        Connection conn = DriverManager.getConnection(url, "wzk", "2013040431");
        String sql = "insert into 访客信息表 values(?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, tel);
        pstmt.setString(3, time);
        pstmt.setString(4, visitMatters);
        pstmt.setString(5, identity);
        pstmt.executeUpdate();
        conn.close();
        return true;
    }
}
