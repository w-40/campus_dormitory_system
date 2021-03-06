package nuc.ss.service;
/**
 * @author 籍乃博
 * @description 学生违纪管理业务层;
 */
import java.sql.SQLException;
import java.util.ArrayList;

import nuc.ss.dao.HouseMasterManager_StudentViolatinOfDiscipline_JDBC;
import nuc.ss.domain.StudentViolationOfDiscipline;

public class HouseMasterManager_StudentViolatinOfDiscipline_Service {
    public static ArrayList<StudentViolationOfDiscipline> searchStudentViolatinOfDiscipline(String username) {
        ArrayList<StudentViolationOfDiscipline> svod = new ArrayList<StudentViolationOfDiscipline>();
        try {
            svod = HouseMasterManager_StudentViolatinOfDiscipline_JDBC.searchStudentViolatinOfDiscipline(username);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return svod;
    }

    public static String deleteStudentViolatinOfDiscipline(String tid,String time) {
        try {
            HouseMasterManager_StudentViolatinOfDiscipline_JDBC.deleteStudentViolationOfDiscipline(tid,time);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tid;
    }

    public static boolean updateStudentViolatinOfDiscipline(String val, String tid, ArrayList<String> tableHeadList, int column) {
        try {
            HouseMasterManager_StudentViolatinOfDiscipline_JDBC.updateStudentViolationOfDiscipline(val, tid, tableHeadList, column);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean addStudentViolatinOfDiscipline(StudentViolationOfDiscipline svod,String username) {
        try {
            HouseMasterManager_StudentViolatinOfDiscipline_JDBC.addStudentViolationOfDiscipline(svod,username);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }
}
