package nuc.ss.controller;
/**
 * @author 王志凯
 * @description 登录控制层，接收界面上的数据，将数据发送到登录业务层，并接收登录业务层的执行结果，传递到LoginFrame
 */

import nuc.ss.service.Service_Login;


public class Login_Controller {
    public static boolean systemControllerLogin(String username, String password) throws Exception {
        boolean flag = Service_Login.systemControllerLogin(username, password);
        return flag;
    }
    public static boolean dormitoryControllerLogin(String username, String password) throws Exception {
        boolean flag = Service_Login.dormitoryControllerLogin(username, password);
        return flag;
    }
    public static boolean studentLogin(String username, String password) throws Exception {
        boolean flag = Service_Login.studentLogin(username, password);
        return flag;
    }


}
