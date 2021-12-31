package nuc.ss.controller;
/**
 * @author 王志凯
 * @description 学生服务管理控制层
 */

import nuc.ss.domain.Dorm;
import nuc.ss.domain.Student;
import nuc.ss.service.SystemController_DormManage_Service;
import nuc.ss.service.SystemController_StudentServiceManage_Service;

import java.sql.SQLException;
import java.util.ArrayList;

public class SystemController_StudentServiceManage_Controller {
    public static ArrayList<Dorm> searchNotFullDorm() throws SQLException, ClassNotFoundException {
        ArrayList<Dorm> NotFullDormArrayList = new ArrayList<Dorm>();
        NotFullDormArrayList = SystemController_StudentServiceManage_Service.searchNotFullDorm();
        return NotFullDormArrayList;
    }

    public static ArrayList<Student> searchNotHaveDormStudent() throws SQLException, ClassNotFoundException {
        ArrayList<Student> NotHaveDormStudent = new ArrayList<Student>();
        NotHaveDormStudent = SystemController_StudentServiceManage_Service.searchNotHaveDormStudent();
        return NotHaveDormStudent;
    }

    public static boolean updateStudentDrom(String val, String tid, ArrayList<String> tableHeadList, int column) {
        SystemController_StudentServiceManage_Service.updateStudentDrom(val, tid, column);
        return true;
    }
}
