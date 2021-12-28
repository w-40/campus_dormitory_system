package nuc.ss.controller;
/**
 * @author 段福泉
 */
import java.sql.SQLException;
import java.util.ArrayList;

import nuc.ss.domain.Student;
import nuc.ss.domain.StudentViolationOfDiscipline;
import nuc.ss.service.SystemController_Student_Service;

public class SystemController_Student_Controller {
	public static String Studentname(String username) throws SQLException, ClassNotFoundException {
        String name;
        name = SystemController_Student_Service.Studentname(username);
        return name;
    }
	
	public static Student student(String username) throws SQLException, ClassNotFoundException {
        Student st = SystemController_Student_Service.Student(username);
        return st;
    }
	
	public static ArrayList violation(String username) throws SQLException, ClassNotFoundException {
		ArrayList<StudentViolationOfDiscipline> stlist = SystemController_Student_Service.studentViolation(username);
        return stlist;
    }
	
	public static boolean addMessage(Student st) throws SQLException, ClassNotFoundException {
		SystemController_Student_Service.addMessage(st);
        return true;
    }

}
