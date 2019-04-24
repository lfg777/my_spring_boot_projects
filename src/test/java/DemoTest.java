import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fg.Li
 * 2019/3/20:11:21
 * <p>
 **/
public class DemoTest {

    @Test
    public void test() {
        String s1 = new String("a")+new String("b");
        String s2 = s1.intern();
        String s3 = "ab";
        /*System.out.println(s1 == s2);//true
        System.out.println(s2 == s3);//true
        System.out.println(s1 == s3);//true*/

        byteArraysToString();
        genericity();


    }

    public static void byteArraysToString() {
        String source = "1242134235123423233";
        try {
            byte[] byteData = source.getBytes("UTF-8");
            String target = new String(byteData);
            System.out.println(target);
            System.out.println(target.equals(source));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    public static void genericity() {
        List<String> l1 = new ArrayList<String>();
        List<Integer> l2 = new ArrayList<Integer>();
        System.out.println(l1.getClass() == l2.getClass());
    }

}
