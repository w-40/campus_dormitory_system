package nuc.ss;
/**
 * @author 王志凯
 * @description 程序主入口
 */
import nuc.ss.view.LoginFrame;
import java.awt.*;

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
