package nuc.ss.dao;

import nuc.ss.domain.Dorm;

import java.sql.*;
import java.util.ArrayList;

public class SystemController_StudentServiceManage_JDBC {
    public static ArrayList searchNotFullDorm() throws SQLException, ClassNotFoundException {
        ArrayList<Dorm> Dormlist = new ArrayList<Dorm>();
        int id ;//宿舍号
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
        String sql = "SELECT * \n"
                + "FROM 宿舍信息表 \n"
                + "WHERE 人数 != 6 ";
        ResultSet rs = stat.executeQuery(sql);
        // 6.处理结果
        while (rs.next()) {
            id = rs.getInt("宿舍号");  //宿舍号
            dormitory = rs.getString("宿舍楼号");//宿舍楼名称
            num=rs.getInt("人数");
            hs = new Dorm(id,dormitory,num);
            Dormlist.add(hs);
        }
        // 7.释放资源
        con.close();
        stat.close();
        rs.close();
        return Dormlist;
    }
}
