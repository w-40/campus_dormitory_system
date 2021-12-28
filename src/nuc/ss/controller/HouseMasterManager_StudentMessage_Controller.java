package nuc.ss.controller;
/**
 * @author 籍乃博
 */
import java.sql.SQLException;
import java.util.ArrayList;

import nuc.ss.domain.Student;
import nuc.ss.service.HouseMasterManager_StudentMessage_Service;
import nuc.ss.service.HouseMasterManager_StudentViolatinOfDiscipline_Service;

public class HouseMasterManager_StudentMessage_Controller {
    public static ArrayList<Student> searchStudentViolatinOfDiscipline() throws SQLException, ClassNotFoundException {
        ArrayList<Student> stl = new ArrayList<Student>();
        stl = HouseMasterManager_StudentMessage_Service.searchStudentMessage();
        return stl;
    }

    public static void deleteStudentViolatinOfDiscipline(String tid) throws SQLException, ClassNotFoundException {
    	HouseMasterManager_StudentMessage_Service.deleteStudentMessage(tid);
    }
}
