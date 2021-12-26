package nuc.ss.controller;

import nuc.ss.service.ServiceSystemControllerLogin;


public class SystemControllerLogin {
    public static boolean systemControllerLogin(String username, String password) throws Exception {
        boolean flag = ServiceSystemControllerLogin.SystemControllerLogin(username, password);
        return flag;
    }


}
