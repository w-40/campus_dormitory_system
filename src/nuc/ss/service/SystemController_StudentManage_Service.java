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
    public static ArrayList<Student> searchStudent() {
        ArrayList<Student> studentsArrayList = new ArrayList<Student>();
        try {
            studentsArrayList = SystemController_StudentManage_JDBC.searchStudent();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return studentsArrayList;
    }

    public static String deleteStudent(String tid) {
        try {
            SystemController_StudentManage_JDBC.deleteStudent(tid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tid;
    }

    public static boolean updateStudent(String val, String tid, ArrayList<String> tableHeadList, int column) {
        try {
            SystemController_StudentManage_JDBC.updateStudent(val, tid, tableHeadList, column);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }


    public static boolean addStudent(Student Student) {
        try {
            SystemController_StudentManage_JDBC.addStudent(Student);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }
}
