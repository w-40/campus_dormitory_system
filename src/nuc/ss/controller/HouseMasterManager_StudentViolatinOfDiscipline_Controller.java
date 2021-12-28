package nuc.ss.controller;

/**
 * @author 籍乃博
 * @description 学生违纪管理控制层
 */

import java.sql.SQLException;
import java.util.ArrayList;
import nuc.ss.domain.StudentViolationOfDiscipline;
import nuc.ss.service.HouseMasterManager_StudentViolatinOfDiscipline_Service;

public class HouseMasterManager_StudentViolatinOfDiscipline_Controller {
    public static ArrayList<StudentViolationOfDiscipline> searchStudentViolatinOfDiscipline() throws SQLException, ClassNotFoundException {
        ArrayList<StudentViolationOfDiscipline> svod = new ArrayList<StudentViolationOfDiscipline>();
        svod = HouseMasterManager_StudentViolatinOfDiscipline_Service.searchStudentViolatinOfDiscipline();
        return svod;
    }

    public static void deleteStudentViolatinOfDiscipline(String tid) throws SQLException, ClassNotFoundException {
    	HouseMasterManager_StudentViolatinOfDiscipline_Service.deleteStudentViolatinOfDiscipline(tid);
    }
    public static boolean updateStudentViolatinOfDiscipline(String val,String tid, ArrayList<String> tableHeadList,int column) throws SQLException, ClassNotFoundException {
    	HouseMasterManager_StudentViolatinOfDiscipline_Service.updateStudentViolatinOfDiscipline(val, tid, tableHeadList, column);
        return true;
    }

    public static boolean addHouseMaster(StudentViolationOfDiscipline svod) throws SQLException, ClassNotFoundException{
    	HouseMasterManager_StudentViolatinOfDiscipline_Service.addStudentViolatinOfDiscipline(svod);
        return true;
    }
}
