package com.lfg.beans;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by lifengguang on 2017/6/2.
 */

/**
 * 针对HTTP协议的POST请求
 * 表单自动填写
 * 不考虑验证码识别
 * 不考虑https类型的协议
 */
public class FormPoster {

    private URL url;
    private QueryString queryString=new QueryString() ;
    /**
     * 构造函数
     * @param url 统一资源位置符号
     */
    public FormPoster(URL url) {
        if(!url.getProtocol().toLowerCase().startsWith("http")) {
            System.err.println("Post只用于http协议！");
            return;
        }
        this.url=url;
    }
    /**
     *  添加参数-值对
     * @param name 参数名称
     * @param value 参数值
     */
    public void add(String name,String value) {
        queryString.add(name, value);
    }

    /**
     * 获取URL
     * @return URL
     */
    public URL getURL() {
        return url;
    }
    /**
     *  获取网站相应的输入流
     * @return 输入流
     * @throws Exception 无法连接异常
     */
    public InputStream post() throws Exception {
        URLConnection openConnection = url.openConnection();
        openConnection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        openConnection.setDoOutput(true);
        OutputStream outputStream = openConnection.getOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream,"UTF-8");
        outputStreamWriter.write(queryString.toString());
        outputStreamWriter.write("\r\n");
        outputStreamWriter.flush();
        outputStreamWriter.close(); //刷新关闭流很重要，只有关闭了，才能获取输入流
        return openConnection.getInputStream();
    }
}
