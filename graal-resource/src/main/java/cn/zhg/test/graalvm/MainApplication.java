package cn.zhg.test.graalvm;

import java.io.InputStream;

/**
 * @author zhhaogen
 */
public class MainApplication {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try (InputStream is = MainApplication.class.getResourceAsStream("/a.txt")) {
            byte[] datas = new byte[2048];
            int leng = is.read(datas);
            System.out.println("读取内容:" + new String(datas, 0, leng));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
