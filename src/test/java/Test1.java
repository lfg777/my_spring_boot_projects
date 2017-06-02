import com.lfg.MyApplication;
import com.lfg.service.TestForCacheable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

/**
 * Created by lifengguang on 2017/6/1.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyApplication.class)
@WebAppConfiguration
public class Test1 {


    @Resource
    private TestForCacheable testForCacheable;

    @Test
    public void test1(){
        String test = testForCacheable.test(3);
        System.out.println(test);
    }

}
