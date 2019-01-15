package com.heleeos.blog.util;

import com.heleeos.blog.common.ConstantKey;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 *
 * Created by liyu on 2018/8/2.
 */
public class CookieUtil {

    /**
     * 从cookie中获取令牌
     */
    public static String getTokenFromCookie(HttpServletRequest request) {
        if(request.getCookies() == null) return null;
        return Arrays.stream(request.getCookies())
                .filter(cookie -> StringUtils.trimToNull(cookie.getValue()) != null)
                .filter(cookie -> cookie.getName().equals(ConstantKey.COOKIE_LOGIN_TOKEN_KEY))
                .findFirst()
                .map(Cookie::getValue).orElse(null);
    }

    /**
     * 保存令牌到cookie中
     *
     * @param token 令牌
     */
    public static void saveTokenToCookie(HttpServletResponse response, String token) {
        if (StringUtils.trimToNull(token) == null) return;
        Cookie cookie = new Cookie(ConstantKey.COOKIE_LOGIN_TOKEN_KEY, token);
        cookie.setMaxAge(3 * 24 * 60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * 移除Cookie中的令牌
     */
    public static void removeCookieToken(HttpServletResponse response) {
        Cookie cookie = new Cookie(ConstantKey.COOKIE_LOGIN_TOKEN_KEY, "");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
