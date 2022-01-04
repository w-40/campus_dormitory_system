package nuc.ss.service;

import nuc.ss.dao.SystemController_DormManage_JDBC;
import nuc.ss.dao.SystemController_StudentServiceManage_JDBC;
import nuc.ss.domain.Dorm;
import nuc.ss.domain.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public class SystemController_StudentServiceManage_Service {
    public static ArrayList<Dorm> searchNotFullDorm() {
        ArrayList<Dorm> NotFullDormArrayList = new ArrayList<Dorm>();
        try {
            NotFullDormArrayList = SystemController_StudentServiceManage_JDBC.searchNotFullDorm();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return NotFullDormArrayList;
    }

    public static ArrayList<Student> searchNotHaveDormStudent() {
        ArrayList<Student> NotHaveDormStudent = new ArrayList<Student>();
        try {
            NotHaveDormStudent = SystemController_StudentServiceManage_JDBC.searchNotHaveDormStudent();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return NotHaveDormStudent;
    }
}
