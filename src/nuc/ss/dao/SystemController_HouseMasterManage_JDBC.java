package nuc.ss.dao;
/**
 * @author 王志凯，卫黎明
 * @description 宿管信息表数据访问层
 * searchHouseMaster()：利用JDBC从数据库中查询数据，并将数据用学生对象封装，再用ArrayList集合封装后传给宿管管理业务层
 *
 *
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
        Connection con = DriverManager.getConnection("jdbc:mysql://182.42.117.228:3306/campus_dormitory", "wzk", "2013040431");

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
            dormitoryId = rs.getString("管理宿舍楼号");
            ; //管理宿舍楼号
            phoneNumber = rs.getString("联系电话");
            ; //联系电话
            hs = new HouseMaster(id, password, name, sex, dormitoryId, phoneNumber);
            houseMasterslist.add(hs);
        }
        // 7.释放资源
        con.close();
        stat.close();
        rs.close();
        return houseMasterslist;
    }
}
