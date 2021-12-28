package nuc.ss.service;
/**
 * @author 籍乃博，王志凯修复bug
 * @description 学生留言管理业务层
 * 
 */
import java.sql.SQLException;
import java.util.ArrayList;

import nuc.ss.dao.HouseMasterManager_StudentMessage_JDBC;
import nuc.ss.domain.Student;

public class HouseMasterManager_StudentMessage_Service {
	 public static ArrayList<Student> searchStudentMessage() throws SQLException, ClassNotFoundException {
	        ArrayList<Student> stl = new ArrayList<Student>();
	        stl =HouseMasterManager_StudentMessage_JDBC.searchStudentMessage();
	        return stl;
	    }
	 
	    public static String deleteStudentMessage(String tid,String message) throws SQLException, ClassNotFoundException {
	    	HouseMasterManager_StudentMessage_JDBC.deleteStudentMessage(tid,message);
	    	return tid;
	    }
}
