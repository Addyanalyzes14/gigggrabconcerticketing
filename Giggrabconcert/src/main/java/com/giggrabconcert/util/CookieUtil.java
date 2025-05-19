package com.giggrabconcert.util;



import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Arrays;

/**
 * Utility class for managing cookies in a web application.
 * Provides methods to add, retrieve, and delete cookies.
 */
public class CookieUtil {

    /**
     * Adds a cookie with the specified name, value, and maximum age.
     *
     * @param response the HttpServletResponse to add the cookie to
     * @param name     the name of the cookie
     * @param value    the value of the cookie
     * @param maxAge   the maximum age of the cookie in seconds
     */
    public static void addCookie(HttpServletResponse response, String eventName, String value,int maxAge) {
        Cookie cookie = new Cookie(eventName, value);
        cookie.setMaxAge(maxAge);
        cookie.setPath("/"); // Make cookie available to the entire application
        response.addCookie(cookie);
    }

    /**
     * Retrieves a cookie by its name from the HttpServletRequest.
     *
     * @param request the HttpServletRequest to get the cookie from
     * @param name    the name of the cookie to retrieve
     * @return the Cookie object if found, otherwise null
     */
    public static Cookie getCookie(HttpServletRequest request, String eventName) {
        if (request.getCookies() != null) {
            return Arrays.stream(request.getCookies())
                    .filter(cookie -> eventName.equals(cookie.getName()))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Deletes a cookie by setting its max age to 0.
     *
     * @param response the HttpServletResponse to add the deletion cookie to
     * @param name     the name of the cookie to delete
     */
    public static void deleteCookie(HttpServletResponse response, String eventName) {
        Cookie cookie = new Cookie(eventName, null);
        cookie.setMaxAge(0);
        cookie.setPath("/"); // Make cookie available to the entire application
        response.addCookie(cookie);
    }
}