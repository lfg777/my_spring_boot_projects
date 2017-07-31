import com.lfg.beans.ConfigruationApplication;
import com.lfg.beans.WatchServiceFilterDemo;

/**
 * Created by lifengguang on 2017/7/31.
 */
public class WatchServiceTest {

    private static final String FILE_PATH = "D:/lfg/a.properties";

    public static void main(String[] args) {
        WatchServiceFilterDemo listner = new WatchServiceFilterDemo(FILE_PATH);
        try {
            new Thread(listner).start();
            while (true) {
                Thread.sleep(2000l);
                System.out.println(ConfigruationApplication.getInstance()
                       .getConfig("testKey"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
