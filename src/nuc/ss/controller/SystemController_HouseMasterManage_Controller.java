package nuc.ss.controller;
/**
 * @author 王志凯
 * @description 宿管管理控制层
 * searchHouseMaster()：接收到的ArrayList对象传给宿管管理界面
 *
 *
 */

import nuc.ss.dao.SystemController_HouseMasterManage_JDBC;
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
}
