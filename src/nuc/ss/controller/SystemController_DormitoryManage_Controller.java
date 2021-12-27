package nuc.ss.controller;
/**
 * @author 王志凯,卫黎明
 * @description 宿舍楼管理控制层
 * searchHouseMaster()：接收到的ArrayList对象传给宿舍楼管理界面
 * deleteHouseMaster(String tid)：接收图形化用户界面数据，传递到宿舍管理业务层
 * updateHouseMaster(String val,String tid, ArrayList<String> tableHeadList,int column)：接收图形化用户界面数据，传递到宿舍管理业务层
 * addHouseMaster(HouseMaster houseMaster)：接收图形化用户界面数据，传递到宿舍管理业务层
 */

import nuc.ss.dao.SystemController_DormitoryManage_JDBC;
import nuc.ss.domain.Dormitory;
import nuc.ss.service.SystemController_DormitoryManage_Service;


import java.sql.SQLException;
import java.util.ArrayList;

public class SystemController_DormitoryManage_Controller {
    public static ArrayList<Dormitory> searchDormitory() throws SQLException, ClassNotFoundException {
        ArrayList<Dormitory> dormitoryArrayList = new ArrayList<Dormitory>();
        dormitoryArrayList = SystemController_DormitoryManage_Service.searchDormitory();
        return dormitoryArrayList ;
    }


    public static void deleteDormitory(String tid) throws SQLException, ClassNotFoundException {
        SystemController_DormitoryManage_Service.deleteDormitory(tid);
    }
    public static boolean updateDormitory(String val,String tid, ArrayList<String> tableHeadList,int column) throws SQLException, ClassNotFoundException {
        SystemController_DormitoryManage_Service.updateDormitory(val,tid,tableHeadList,column);
        return true;
    }

    public static boolean addDormitory(Dormitory dormitory) throws SQLException, ClassNotFoundException{
        SystemController_DormitoryManage_Service.addDormitory(dormitory);
        return true;
    }
}
