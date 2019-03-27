import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fg.Li
 * 2019/3/20:11:21
 * <p>
 **/
public class DemoTest {

    @Test
    public void test() {
        Map map = new HashMap();
        map.put("123", 123);
        System.out.println(map.get("123"));
        System.out.println(map.get("null"));
    }

}
