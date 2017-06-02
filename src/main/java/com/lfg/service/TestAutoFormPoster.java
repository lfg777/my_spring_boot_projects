package com.lfg.service;

import com.lfg.beans.FormPoster;

import java.io.*;
import java.net.URL;

/**
 * Created by lifengguang on 2017/6/2.
 */
public class TestAutoFormPoster {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://p.ppdai.com/member.php?mod=logging&action=login&referer=http%3A%2F%2Fp.ppdai.com%2Fhome.php");
        FormPoster formPoster = new FormPoster(url);
        /**
         * 以下是测试华为招聘网站登陆界面
         */
        formPoster.add("actionFlag", "loginAuthenticate");
        formPoster.add("lang", "zh");
        formPoster.add("redirect", "http://p.ppdai.com/member.php?mod=logging&action=login&referer=http%3A%2F%2Fp.ppdai.com%2Fhome.php");
        formPoster.add("uid", "lifengguang");
        formPoster.add("password", "Zaq12wsx");
        InputStream inputStream = formPoster.post();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        File file=new File("outfile");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"UTF-8");
        int c;
        while((c=inputStreamReader.read())!=-1) {
            System.out.print((char)c);
            outputStreamWriter.write((char)c);
        }
        inputStream.close();
        outputStreamWriter.close();
        System.out.println();
    }
}
