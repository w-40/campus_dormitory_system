package nuc.ss.controller;
/**
 * @author 王志凯
 * @description 学生服务管理控制层
 */

import nuc.ss.domain.Dorm;
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
}
