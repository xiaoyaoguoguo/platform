package com.panda.common.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author jamie
 * @ClassName: SessionUtils
 * @Description: session工具类
 * @data 2019-01-07 16:51
 **/
public class SessionUtils {
    private static ThreadLocal<HttpServletRequest> reqLocal = new ThreadLocal();
    private static ThreadLocal<HttpServletResponse> resLocal = new ThreadLocal();

    public SessionUtils() {
    }

    public static HttpSession getSession() {
//        return reqLocal.get() != null ? ((HttpServletRequest)reqLocal.get()).getSession() : null;
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getSession();
    }

    public static HttpServletRequest getReq() {
//        return (HttpServletRequest)reqLocal.get();
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public static void setReq(HttpServletRequest request) {
        reqLocal.set(request);
    }

    public static HttpServletResponse getRes() {
//        return (HttpServletResponse)resLocal.get();
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    public static void setRes(HttpServletResponse res) {
        resLocal.set(res);
    }
}
