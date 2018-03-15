package com.lfg.filter;

import com.alibaba.druid.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Enumeration;
import java.util.Map;
import java.util.Vector;

/**
 * Created by lifengguang on 2018/3/15.
 */
public class MyModifyParametersWrapper extends HttpServletRequestWrapper {

    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    private Map<String, String[]> parameterMap;

    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request The request to wrap
     * @throws IllegalArgumentException if the request is null
     */
    public MyModifyParametersWrapper(HttpServletRequest request) {
        super(request);
        parameterMap = request.getParameterMap();
    }

    // 重写几个HttpServletRequestWrapper中的方法
    /**
     * 获取所有参数名
     *
     * @return 返回所有参数名
     */
    @Override
    public Enumeration<String> getParameterNames() {
        Vector<String> vector = new Vector<String>(parameterMap.keySet());
        return vector.elements();
    }

    /**
     * 获取指定参数名的值，如果有重复的参数名，则返回第一个的值 接收一般变量 ，如text类型
     *
     * @param name
     *            指定参数名
     * @return 指定参数名的值
     */
    @Override
    public String getParameter(String name) {
        String[] results = parameterMap.get(name);
        if (results == null || results.length <= 0)
            return null;
        else {
            System.out.println("修改之前： " + results[0]);
            return modify(results[0]);
        }
    }

    @Override
    public String[] getParameterValues(String name) {

        String[] params = parameterMap.get(name);
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        int res = params.length;
        for (int i=0;i<res;i++) {
            LOGGER.info("修改前：" + params[i]);
            LOGGER.info("修改后：" + modify(params[i]));
            params[i] = modify(params[i]);
        }
        return params;

    }

    private String modify(String param) {
        return "after-"+param;
    }
}
