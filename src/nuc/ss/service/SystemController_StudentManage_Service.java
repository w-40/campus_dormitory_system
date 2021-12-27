package nuc.ss.service;

import nuc.ss.dao.SystemController_StudentManage_JDBC;
import nuc.ss.domain.Student;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author hsystart
 * @create 2021-12-27 19:37
 */
public class SystemController_StudentManage_Service {
    public static ArrayList<Student> searchStudent() throws SQLException, ClassNotFoundException {
        ArrayList<Student> studentsArrayList = new ArrayList<Student>();
        studentsArrayList = SystemController_StudentManage_JDBC.searchStudent();
        return studentsArrayList;
    }

    public static String deleteStudent(String tid) throws SQLException, ClassNotFoundException {
        SystemController_StudentManage_JDBC.deleteStudent(tid);
        return tid;
    }
    public static boolean updateStudent(String val, String tid, ArrayList<String> tableHeadList, int column) throws SQLException, ClassNotFoundException {
        SystemController_StudentManage_JDBC.updateStudent(val,tid,tableHeadList,column);
        return true;
    }

    public static boolean addStudent(Student Student) throws SQLException, ClassNotFoundException{
        SystemController_StudentManage_JDBC.addStudent(Student);
        return true;
    }
}
