package com.panda.framework.handler;


import com.alibaba.fastjson.JSON;
import com.panda.common.utils.auth.AuthUtils;
import com.panda.common.utils.redis.RedisDao;
import com.panda.common.utils.redis.RedisUtil;
import com.panda.common.utils.spring.SpringUtils;
import com.panda.framework.aspectj.lang.annotation.Auth;
import com.panda.framework.domain.JsonReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * @author jamie
 * @ClassName: SessionInterceptor
 * @Description: session拦截器
 * @data 2019-01-07 11:09
 **/
public class SessionInterceptor extends HandlerInterceptorAdapter {


    private static final Long EXP_TIME = 1800L;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /**判断方法上是否有权限注解**/
        if (handler instanceof HandlerMethod) {
            Method method = ((HandlerMethod) handler).getMethod();
            Auth auth = method.getAnnotation(Auth.class);
            ResponseBody responseBody = method.getAnnotation(ResponseBody.class);
            if (auth != null) {
                /**判断是否登录**/
                if (AuthUtils.getUser() == null) {
                    return noAuth(responseBody, request, response, null);
                } else {
                    /**重置Redis时间,同步session**/
                    RedisUtil redisUtil = SpringUtils.getBean("redisUtil");
                    redisUtil.expire(request.getSession().getId(), EXP_TIME);
                }
            }
        }
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    private boolean noAuth(ResponseBody responseBody, HttpServletRequest request, HttpServletResponse response, String userType) throws IOException {
        String referer = request.getHeader("referer");
        request.getSession().setAttribute("redirectUrl", referer);
        if (responseBody != null) {
            JsonReturn json = new JsonReturn(JsonReturn.CODE_NO_LOGIN, "用户未登录");
            response.setContentType("text/json; charset=UTF-8");
            PrintWriter pw = response.getWriter();
            pw.write(JSON.toJSONString(json));
            pw.flush();
            pw.close();
        }
        return false;
    }

}
