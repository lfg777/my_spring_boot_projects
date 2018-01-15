import com.lfg.MyApplication;
import com.lfg.classLoader.MyClassLoader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by lifengguang on 2018/1/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyApplication.class)
@WebAppConfiguration
public class MyClassLoaderTest {

    @Test
    public void test() {
        MyClassLoader myl = new MyClassLoader(null,"C:\\Users\\lifengguang\\Desktop\\");
        try {
            Class<?> clazz = myl.loadClass("com.lfg.classLoader.MainDemo");
            Method sayHello = clazz.getDeclaredMethod("sayHello");
            Object o = clazz.newInstance();
            sayHello.invoke(o);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


    }
}
