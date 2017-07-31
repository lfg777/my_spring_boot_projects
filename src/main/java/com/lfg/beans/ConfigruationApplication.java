package com.lfg.beans;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by lifengguang on 2017/7/31.
 */
public class ConfigruationApplication {

    private static final ConfigruationApplication ca = new ConfigruationApplication();

    public static ConfigruationApplication getInstance() {
        return ca;
    }

    private static final Properties p = new Properties();

    public void initlize(String file) {
        InputStream in = null;

        try {
            in = new FileInputStream(file);
            p.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getConfig(String key) {
        return p.get(key).toString();
    }
}
