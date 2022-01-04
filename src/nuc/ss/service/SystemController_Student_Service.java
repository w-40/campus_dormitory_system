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
    public static String Studentname(String username) {
        String name = null;
        try {
            name = Login_JDBC.studentName(username);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return name;
    }

    public static Student Student(String username) {
        Student st = null;
        try {
            st = SystemController_Student_JDBC.student(username);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return st;
    }

    public static ArrayList studentViolation(String username) {
        ArrayList<StudentViolationOfDiscipline> stlist = null;
        try {
            stlist = SystemController_Student_JDBC.studentViolation(username);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return stlist;
    }

    public static boolean addMessage(Student st) {
        try {
            SystemController_Student_JDBC.addMessage(st);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean updatePassword(String username, String password)  {
        try {
            SystemController_Student_JDBC.updatePassword(username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean updateNum(String username, String num)  {
        try {
            SystemController_Student_JDBC.updateNum(username, num);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

}
