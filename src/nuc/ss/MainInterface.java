package nuc.ss;

import nuc.ss.view.LoginFrame;

import java.awt.*;

/**
 * @author wzk
 * @description 程序主入口
 * @
 */
public class MainInterface {
    public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        LoginFrame window = new LoginFrame();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
    }
}
