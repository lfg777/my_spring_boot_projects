package com.lfg.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by lifengguang on 2017/6/2.
 */
@Service
public class WebPageGrab {

    public String getWebPageContent(String url,String strPostRequest,int maxLength){
        // 读取结果网页
        StringBuffer buffer = new StringBuffer();
        System.setProperty("sun.net.client.defaultConnectTimeout", "5000");
        System.setProperty("sun.net.client.defaultReadTimeout", "5000");
        try {
            URL newUrl = new URL(url);
            HttpURLConnection hConnect = (HttpURLConnection) newUrl
                    .openConnection();
            // POST方式的额外数据
            if (strPostRequest.length() > 0) {
                hConnect.setDoOutput(true);
                OutputStreamWriter out = new OutputStreamWriter(hConnect
                        .getOutputStream());
                out.write(strPostRequest);
                out.flush();
                out.close();
            }
            // 读取内容
            BufferedReader rd = new BufferedReader(new InputStreamReader(
                    hConnect.getInputStream()));
            int ch;
            for (int length = 0; (ch = rd.read()) > -1
                    && (maxLength <= 0 || length < maxLength); length++)
                buffer.append((char) ch);
            String s = buffer.toString();
            s.replaceAll("//&[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "");
            System.out.println(s);
            /*String openStr = "http://p.ppdai.com/member.php?mod=logging&action=login&referer=http%3A%2F%2Fp.ppdai.com%2Fhome.php%3Fmod%3Dspacecp%26ac%3Dprofile%26op%3Dpassword";
            Runtime.getRuntime().exec("cmd /c start" + openStr);*/


            rd.close();
            hConnect.disconnect();
            return buffer.toString().trim();
        } catch (Exception e) {
            // return "错误:读取网页失败！";
            //
            return null;
        }
    }

    public static void main(String[] args) {
        WebPageGrab w = new WebPageGrab();
        String webPageContent = w.getWebPageContent("http://p.ppdai.com/member.php?mod=logging&action=login&referer=http%3A%2F%2Fp.ppdai.com%2Fhome.php%3Fmod%3Dspacecp%26ac%3Dprofile%26op%3Dpassword", "", 0);
        System.out.println(webPageContent);
    }


}
