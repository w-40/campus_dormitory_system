package nuc.ss.service;

import nuc.ss.dao.SystemController_DormManage_JDBC;
import nuc.ss.dao.SystemController_StudentServiceManage_JDBC;
import nuc.ss.domain.Dorm;
import nuc.ss.domain.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public class SystemController_StudentServiceManage_Service {
    public static ArrayList<Dorm> searchNotFullDorm() throws SQLException, ClassNotFoundException {
        ArrayList<Dorm> NotFullDormArrayList = new ArrayList<Dorm>();
        NotFullDormArrayList = SystemController_StudentServiceManage_JDBC.searchNotFullDorm();
        return NotFullDormArrayList;
    }

    public static ArrayList<Student> searchNotHaveDormStudent() throws SQLException, ClassNotFoundException {
        ArrayList<Student> NotHaveDormStudent = new ArrayList<Student>();
        NotHaveDormStudent = SystemController_StudentServiceManage_JDBC.searchNotHaveDormStudent();
        return NotHaveDormStudent;
    }

    public static void updateStudentDrom(String val, String tid, int column) {
        SystemController_StudentServiceManage_JDBC.updateStudentDrom(val, tid, column);
    }
}
