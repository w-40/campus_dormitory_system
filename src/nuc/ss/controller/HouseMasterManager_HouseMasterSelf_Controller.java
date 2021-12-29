package nuc.ss.controller;
/**
 * @author 籍乃博
 * @description 
 * 
 */
import java.sql.SQLException;

import nuc.ss.domain.HouseMaster;
import nuc.ss.service.HouseMasterManager_HouseMasterSelf_Service;

public class HouseMasterManager_HouseMasterSelf_Controller {

    public static HouseMaster searchHouseMasterSelf(String id) throws SQLException, ClassNotFoundException {
        HouseMaster hm =new HouseMaster();
        hm = HouseMasterManager_HouseMasterSelf_Service.searchHouseMasterSelf(id);
        return hm;
    }

}
