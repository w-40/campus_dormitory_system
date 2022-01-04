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
    public static ArrayList<StudentViolationOfDiscipline> searchStudentViolatinOfDiscipline() throws SQLException, ClassNotFoundException {
        ArrayList<StudentViolationOfDiscipline> svod = new ArrayList<StudentViolationOfDiscipline>();
        svod = HouseMasterManager_StudentViolatinOfDiscipline_JDBC.searchStudentViolatinOfDiscipline();
        return svod;
    }

    public static String deleteStudentViolatinOfDiscipline(String tid) throws SQLException, ClassNotFoundException {
        HouseMasterManager_StudentViolatinOfDiscipline_JDBC.deleteStudentViolationOfDiscipline(tid);
        return tid;
    }

    public static boolean updateStudentViolatinOfDiscipline(String val, String tid, ArrayList<String> tableHeadList, int column) throws SQLException, ClassNotFoundException {
        HouseMasterManager_StudentViolatinOfDiscipline_JDBC.updateStudentViolationOfDiscipline(val, tid, tableHeadList, column);
        return true;
    }

    public static boolean addStudentViolatinOfDiscipline(StudentViolationOfDiscipline svod) throws SQLException, ClassNotFoundException {
        HouseMasterManager_StudentViolatinOfDiscipline_JDBC.addStudentViolationOfDiscipline(svod);
        return true;
    }
}
