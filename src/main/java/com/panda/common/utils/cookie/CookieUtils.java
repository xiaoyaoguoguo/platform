package com.panda.common.utils.cookie;

import com.panda.common.utils.SessionUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author jamie
 * @ClassName: CookieUtils
 * @Description: cookie工具类
 * @data 2019-01-07 16:49
 **/
public class CookieUtils {
    public CookieUtils() {
    }

    public static void set(String key, String value) {
        HttpServletResponse response = SessionUtils.getRes();
        Cookie cookie = new Cookie(key, value);
        cookie.setPath("/");
        cookie.setMaxAge(31104000);
        response.addCookie(cookie);
    }

    public static void setSid(String key, String value) {
        HttpServletResponse response = SessionUtils.getRes();
        StringBuilder buffer = new StringBuilder();
        buffer.append(key).append("=").append(value).append(";");
        buffer.append("path=").append("/").append(";");
        buffer.append("HttpOnly;");
        response.addHeader("Set-Cookie", buffer.toString());
    }

    public static void setSSLSid(String key, String value) {
        HttpServletResponse response = SessionUtils.getRes();
        StringBuilder buffer = new StringBuilder();
        buffer.append(key).append("=").append(value).append(";");
        buffer.append("path=").append("/").append(";");
        buffer.append("Secure;");
        buffer.append("HttpOnly;");
        response.addHeader("Set-Cookie", buffer.toString());
    }

    public static void setPersistSid(String key, String value) {
        HttpServletResponse response = SessionUtils.getRes();
        StringBuilder buffer = new StringBuilder();
        buffer.append(key).append("=").append(value).append(";");
        buffer.append("path=").append("/").append(";");
        buffer.append("Secure;");
        buffer.append("HttpOnly;");
        Calendar cd = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE,dd-MMM-yy HH:mm:ss 'GMT' ", Locale.US);
        cd.add(5, 1);
        buffer.append("expires=" + sdf.format(cd.getTime()) + ";");
        response.addHeader("Set-Cookie", buffer.toString());
    }

    public static void remove(String key) {
        HttpServletResponse response = SessionUtils.getRes();
        Cookie cookie = new Cookie(key, (String) null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    public static String get(String key) {
        Map<String, Cookie> cookieMap = ReadCookieMap();
        if (cookieMap.containsKey(key)) {
            Cookie cookie = (Cookie) cookieMap.get(key);
            return cookie.getValue();
        } else {
            return null;
        }
    }

    public static Integer getMaxAge(String key) {
        Map<String, Cookie> cookieMap = ReadCookieMap();
        if (cookieMap.containsKey(key)) {
            Cookie cookie = (Cookie) cookieMap.get(key);
            return cookie.getMaxAge();
        } else {
            return null;
        }
    }

    private static Map<String, Cookie> ReadCookieMap() {
        Map<String, Cookie> cookieMap = new HashMap();
        Cookie[] cookies = SessionUtils.getReq().getCookies();
        if (null != cookies) {
            Cookie[] var2 = cookies;
            int var3 = cookies.length;

            for (int var4 = 0; var4 < var3; ++var4) {
                Cookie cookie = var2[var4];
                cookieMap.put(cookie.getName(), cookie);
            }
        }

        return cookieMap;
    }
}
