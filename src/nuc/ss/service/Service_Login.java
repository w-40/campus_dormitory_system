package nuc.ss.service;
/**
 * @author 王志凯
 * @description 登录业务层，接收登录控制层的数据，将数据发送到数据访问层，并接收数据访问层的执行结果
 */
import nuc.ss.dao.Login_JDBC;


public class Service_Login {
    public static boolean SystemControllerLogin(String username, String password) throws Exception {
        boolean flag = Login_JDBC.SystemControllerLogin(username, password);
        return flag;
    }
}
