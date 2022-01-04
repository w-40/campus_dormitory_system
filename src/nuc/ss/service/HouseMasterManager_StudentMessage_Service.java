package nuc.ss.service;
/**
 * @author 籍乃博，王志凯修复bug
 * @description 学生留言管理业务层
 */

import java.sql.SQLException;
import java.util.ArrayList;

import nuc.ss.dao.HouseMasterManager_StudentMessage_JDBC;
import nuc.ss.domain.Student;

public class HouseMasterManager_StudentMessage_Service {
    public static ArrayList<Student> searchStudentMessage() {
        ArrayList<Student> stl = new ArrayList<Student>();
        try {
            stl = HouseMasterManager_StudentMessage_JDBC.searchStudentMessage();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return stl;
    }

    public static String deleteStudentMessage(String tid, String message) {
        try {
            HouseMasterManager_StudentMessage_JDBC.deleteStudentMessage(tid, message);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tid;
    }
}
