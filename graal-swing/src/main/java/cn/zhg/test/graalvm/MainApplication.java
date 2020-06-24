package cn.zhg.test.graalvm;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author zhhaogen
 */
public class MainApplication {

    /**
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("测试");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.add(new JLabel("当前时间:" + System.currentTimeMillis()));
        frame.setVisible(true);
    }
}
