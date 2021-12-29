package nuc.ss.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import nuc.ss.domain.HouseMaster;

/**
 * 
 * @author 籍乃博
 * @description 宿舍管理员——个人账户管理数据访问层
 *
 */
public class HouseMasterManager_HouseMasterSelf_JDBC {

	 public static HouseMaster searchStudentMessage(String tid) throws SQLException, ClassNotFoundException {
	        
		    String id;  //工号
		    String name; //姓名
		    char sex; //性别
		    String dormitoryId; //管理的宿舍楼号
		    String phoneNumber; //联系电话
	        
	        HouseMaster hm = null;
	        
            HouseMaster st = null;
	        // 1.导入jar包
	        // 2.注册驱动
	        Class.forName("com.mysql.jdbc.Driver");//MySQL5版本后可以省略注册步骤
	        // 3.获取连接
	        Connection con = DriverManager.getConnection("jdbc:mysql://182.42.117.228:3306/campus_dormitory?useUnicode=true&characterEncoding=utf-8", "jnb", "2013040432");

	        // 4.获取执行者对象
	        Statement stat = con.createStatement();

	        // 5. 执行sql语句，并且接收结果
	        String sql = "SELECT * FROM 宿管信息表 WHERE 工号 = ?";
	        PreparedStatement pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, tid);
	        ResultSet rs = pstmt.executeQuery();;
	        // 6.处理结果
	        while (rs.next()) {
	            id = rs.getString("工号");  //学号  
	            name = rs.getString("姓名");//姓名
	            sex = rs.getString("性别").charAt(0);
	            dormitoryId =rs.getString("管理宿舍楼号"); //管理的宿舍楼号
	            phoneNumber =rs.getString("联系电话");
	            st = new HouseMaster(id, name, sex, dormitoryId, phoneNumber);
	            hm = st;
	        }
	        // 7.释放资源
	        con.close();
	        stat.close();
	        rs.close();
	        return hm;
	    }
}
