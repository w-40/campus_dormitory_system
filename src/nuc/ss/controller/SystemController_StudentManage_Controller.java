package nuc.ss.controller;

import nuc.ss.domain.HouseMaster;
import nuc.ss.domain.Student;
import nuc.ss.service.SystemController_HouseMasterManage_Service;
import nuc.ss.service.SystemController_StudentManage_Service;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author hsystart
 * @create 2021-12-27 19:38
 */
public class SystemController_StudentManage_Controller {
    public static ArrayList<Student> searchStudentMaster() throws SQLException, ClassNotFoundException {
        ArrayList<Student> studentsArrayList = new ArrayList<Student>();
        studentsArrayList = SystemController_StudentManage_Service.searchStudent();
        return studentsArrayList;
    }


    public static void deleteStudent(String tid) throws SQLException, ClassNotFoundException {
        SystemController_StudentManage_Service.deleteStudent(tid);
    }
    public static boolean updateStudent(String val, String tid, ArrayList<String> tableHeadList, int column) throws SQLException, ClassNotFoundException {
        SystemController_StudentManage_Service.updateStudent(val,tid,tableHeadList,column);
        return true;
    }

    public static boolean addStudent(Student Student) throws SQLException, ClassNotFoundException{
        SystemController_StudentManage_Service.addStudent(Student);
        return true;
    }
}
