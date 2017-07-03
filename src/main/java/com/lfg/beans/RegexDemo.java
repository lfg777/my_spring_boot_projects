package com.lfg.beans;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lifengguang on 2017/6/30.
 */
public class RegexDemo {

    public static void main(String[] args) {

        String target = "41022119890116223X";

        String regex = "^\\d{6}(\\d{8})\\d{1}$|^\\d{6}(\\d{8})\\d{4}$|^\\d{6}(\\d{8})(\\d{3}(X|x))$";

        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(target);

        System.out.println(matcher.matches());

    }


}
