package nuc.ss.service;
/**
 * @author 王志凯，段福泉
 * @description 宿管管理业务层：
 * searchHouseMaster()：将接收到的ArrayList对象传给宿管管理控制层
 * deleteHouseMaster(String tid)：接收宿舍管理控制层界面数据，传递到数据访问层
 * updateHouseMaster(String val,String tid, ArrayList<String> tableHeadList,int column)：接收宿舍管理控制层界面数据，传递到数据访问层
 * addHouseMaster(HouseMaster houseMaster)：接收宿舍管理控制层界面数据，传递到数据访问层
 */
import nuc.ss.dao.SystemController_HouseMasterManage_JDBC;
import nuc.ss.controller.SystemController_HouseMasterManage_Controller;
import nuc.ss.domain.HouseMaster;

import java.sql.SQLException;
import java.util.ArrayList;

public class SystemController_HouseMasterManage_Service {

    public static ArrayList<HouseMaster> searchHouseMaster() throws SQLException, ClassNotFoundException {
        ArrayList<HouseMaster> houseMasterArrayList = new ArrayList<HouseMaster>();
        houseMasterArrayList = SystemController_HouseMasterManage_JDBC.searchHouseMaster();
        return houseMasterArrayList;
    }

    public static String deleteHouseMaster(String tid) throws SQLException, ClassNotFoundException {
        SystemController_HouseMasterManage_JDBC.deleteHouseMaster(tid);
    	return tid;
    }
    public static boolean updateHouseMaster(String val,String tid, ArrayList<String> tableHeadList,int column) throws SQLException, ClassNotFoundException {
        SystemController_HouseMasterManage_JDBC.updateHouseMaster(val,tid,tableHeadList,column);
        return true;
    }

    public static boolean addHouseMaster(HouseMaster houseMaster) throws SQLException, ClassNotFoundException{
        SystemController_HouseMasterManage_JDBC.addHouseMaster(houseMaster);
        return true;
    }
}
