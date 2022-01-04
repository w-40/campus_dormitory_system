package nuc.ss.controller;
/**
 * @author 王志凯, 段福泉
 * @description 宿管管理控制层
 * searchHouseMaster()：接收到的ArrayList对象传给宿管管理界面
 * deleteHouseMaster(String tid)：接收图形化用户界面数据，传递到宿舍管理业务层
 * updateHouseMaster(String val,String tid, ArrayList<String> tableHeadList,int column)：接收图形化用户界面数据，传递到宿舍管理业务层
 * addHouseMaster(HouseMaster houseMaster)：接收图形化用户界面数据，传递到宿舍管理业务层
 */
import nuc.ss.domain.HouseMaster;
import nuc.ss.service.SystemController_HouseMasterManage_Service;


import java.sql.SQLException;
import java.util.ArrayList;

public class SystemController_HouseMasterManage_Controller {
    public static ArrayList<HouseMaster> searchHouseMaster() throws SQLException, ClassNotFoundException {
        ArrayList<HouseMaster> houseMasterArrayList = new ArrayList<HouseMaster>();
        houseMasterArrayList = SystemController_HouseMasterManage_Service.searchHouseMaster();
        return houseMasterArrayList;
    }

    public static boolean deleteHouseMaster(String tid) throws SQLException, ClassNotFoundException {
        SystemController_HouseMasterManage_Service.deleteHouseMaster(tid);
        return true;
    }

    public static boolean updateHouseMaster(String val, String tid, ArrayList<String> tableHeadList, int column) throws SQLException, ClassNotFoundException {
        SystemController_HouseMasterManage_Service.updateHouseMaster(val, tid, tableHeadList, column);
        return true;
    }

    public static boolean updateSetHouseMaster(String val, String tid, ArrayList<String> tableHeadList, int column) throws SQLException, ClassNotFoundException {
        SystemController_HouseMasterManage_Service.updateHouseMaster(val, tid, tableHeadList, column);
        return true;
    }

    public static boolean addHouseMaster(HouseMaster houseMaster) throws SQLException, ClassNotFoundException {
        SystemController_HouseMasterManage_Service.addHouseMaster(houseMaster);
        return true;
    }
}
