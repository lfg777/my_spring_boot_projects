package com.lfg.beans;

import java.net.URLEncoder;

/**
 *
 * 由于网络上HTTP的POST请求需要进行编码
 * 以此来适应不同的操作系统
 * 编码成统一的ASCII字符
 * 本类对Query语句进行URL编码
 * 键值对中间用=连接
 * 不同的键值对用&连接
 *
 * Created by lifengguang on 2017/6/2.
 */
public class QueryString {

    private StringBuilder query=new StringBuilder();
    private String charset="UTF-8";
    /**
     * 无参默认构造函数
     */
    public QueryString() {
    }
    /**
     *  同步添加键值对
     * @param name 参数名称
     * @param value 参数值
     */
    public synchronized void add(String name,String value) {
        query.append('&');
        encode(name,value);
    }
    /**
     * 同步进行URL编码
     * @param name 参数名称
     * @param value 参数值
     */
    private synchronized void encode(String name,String value) {
        try {
            query.append(URLEncoder.encode(name, charset));
            query.append('=');
            query.append(URLEncoder.encode(value,charset));
        } catch (Exception ex) {
            System.err.println("Bad VM can't support "+charset);
        }
    }
    /**
     * 同步获取查询字符串
     * @return 字符串
     */
    public synchronized String getQuery() {
        return query.toString();
    }
    /**
     * 覆盖toString()方法
     */
    public String toString() {
        return getQuery();
    }
}
