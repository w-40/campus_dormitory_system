package nuc.ss.controller;

import nuc.ss.domain.Dorm;
import nuc.ss.domain.Dormitory;
import nuc.ss.service.SystemController_DormManage_Service;
import nuc.ss.service.SystemController_DormitoryManage_Service;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author hsystart，王志凯
 * @create 2021-12-28 18:33
 */
public class SystemController_DormManage_Controller {
    public static ArrayList<Dorm> searchDorm() throws SQLException, ClassNotFoundException {
        ArrayList<Dorm> DormArrayList = new ArrayList<Dorm>();
        DormArrayList = SystemController_DormManage_Service.searchDorm();
        return DormArrayList ;
    }


    public static boolean deleteDorm(String tid) throws SQLException, ClassNotFoundException {
        SystemController_DormManage_Service.deleteDorm(tid);
        return true;
    }
    public static boolean updateDorm(String val, String tid, ArrayList<String> tableHeadList, int column) throws SQLException, ClassNotFoundException {
        SystemController_DormManage_Service.updateDorm(val,tid,tableHeadList,column);
        return true;
    }

    public static boolean addDorm(Dorm Dorm) throws SQLException, ClassNotFoundException{
        SystemController_DormManage_Service.addDorm(Dorm);
        return true;
    }
}
