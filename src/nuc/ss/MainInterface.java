package nuc.ss;


import nuc.ss.view.LoginFrame;

import java.awt.*;

/**
 * @author 王志凯
 * @description 程序主入口
 * @
 */
public class MainInterface {
    public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        //LoginFrame window = new LoginFrame();
                        //HouserMasterFrame hmf = new HouserMasterFrame(frame);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
    }
}
