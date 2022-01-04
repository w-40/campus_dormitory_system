package nuc.ss.controller;
/**
 * @author 籍乃博，王志凯修复bug
 */
import java.sql.SQLException;
import java.util.ArrayList;
import nuc.ss.domain.Student;
import nuc.ss.service.HouseMasterManager_StudentMessage_Service;
import nuc.ss.service.HouseMasterManager_StudentViolatinOfDiscipline_Service;

public class HouseMasterManager_StudentMessage_Controller {
    public static ArrayList<Student> searchStudentMessage(String username) throws SQLException, ClassNotFoundException {
        ArrayList<Student> stl = new ArrayList<Student>();
        stl = HouseMasterManager_StudentMessage_Service.searchStudentMessage(username);
        return stl;
    }

    public static void deleteStudentMessage(String tid, String message) throws SQLException, ClassNotFoundException {
        HouseMasterManager_StudentMessage_Service.deleteStudentMessage(tid, message);
    }
}
