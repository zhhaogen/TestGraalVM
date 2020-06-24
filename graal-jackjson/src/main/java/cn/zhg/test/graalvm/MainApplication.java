package cn.zhg.test.graalvm;

import java.io.File;
import java.util.Scanner;
import com.fasterxml.jackson.databind.ObjectMapper;
import cn.zhg.test.graalvm.model.User;

/**
 * @author zhhaogen
 */
public class MainApplication {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            final File file;
            if (args == null || args.length == 0) {
                System.out.println("请输入文件路径:");
                Scanner sc = new Scanner(System.in);
                file = new File(sc.nextLine());
            } else {
                file = new File(args[0]);
            }
            if (!file.exists()) {
                System.err.println(file.getCanonicalPath() + "文件不存在!");
                return;
            }
            ObjectMapper mapper = new ObjectMapper();
            User item = mapper.readValue(file, User.class);
            String json = mapper.writeValueAsString(item);
            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
