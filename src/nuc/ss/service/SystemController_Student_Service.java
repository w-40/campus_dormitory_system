package nuc.ss.service;
/**
 * @author 段福泉
 */
import java.sql.SQLException;
import java.util.ArrayList;

import nuc.ss.dao.Login_JDBC;
import nuc.ss.dao.SystemController_Student_JDBC;
import nuc.ss.domain.Student;
import nuc.ss.domain.StudentViolationOfDiscipline;

public class SystemController_Student_Service {
	public static String Studentname(String username) throws SQLException, ClassNotFoundException {
        String name;
        name = Login_JDBC.studentName(username);
        return name;
    }
	
	public static Student Student(String username) throws SQLException, ClassNotFoundException {
        Student st = SystemController_Student_JDBC.student(username);
        return st;
    }
	
	public static ArrayList studentViolation(String username) throws SQLException, ClassNotFoundException {
		ArrayList<StudentViolationOfDiscipline> stlist = SystemController_Student_JDBC.studentViolation(username);
        return stlist;
    }
	
	public static boolean addMessage(Student st) throws SQLException, ClassNotFoundException {
		SystemController_Student_JDBC.addMessage(st);
        return true;
    }

}
