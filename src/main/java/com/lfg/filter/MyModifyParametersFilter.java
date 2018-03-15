package com.lfg.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lifengguang on 2018/3/15.
 */
@WebFilter
public class MyModifyParametersFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        MyModifyParametersWrapper modifyParametersWrapper = new MyModifyParametersWrapper(httpServletRequest);
        filterChain.doFilter(modifyParametersWrapper,httpServletResponse);

    }
}
