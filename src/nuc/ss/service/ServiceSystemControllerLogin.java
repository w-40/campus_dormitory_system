package nuc.ss.service;

import nuc.ss.dao.JDBC_SystemController;

public class ServiceSystemControllerLogin {
    public static boolean SystemControllerLogin(String username, String password) throws Exception {
        boolean flag = JDBC_SystemController.SystemControllerLogin(username, password);
        return flag;
    }
}
