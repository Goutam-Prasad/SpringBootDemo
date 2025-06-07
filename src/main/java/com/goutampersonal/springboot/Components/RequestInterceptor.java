package com.goutampersonal.springboot.Components;

import jakarta.annotation.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class RequestInterceptor implements HandlerInterceptor {
    /**
     * Handler interceptor has three methods
     * preHandler
     * postHandler
     * afterCompletion
     * these 3 has to be overridden
     * prehandle runs before the function
     * postHandle runs after the function execution finishes
     * afterCompletion is like finally block weather success or error this will run
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler){
        System.out.println("Request "+request.toString());
        System.out.println("Response "+response.toString());
        System.out.println("Inside pre request handler interceptor");
        return true;

    }

    @Override
    public void postHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("✅ [postHandle] Request URI: " + request.getRequestURI());
        if (modelAndView != null) {
            System.out.println("✅ [postHandle] View Name: " + modelAndView.getViewName());
        }
    }

    @Override
    public void afterCompletion(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            @Nullable Exception ex) throws Exception {
        System.out.println("🏁 [afterCompletion] Request URI: " + request.getRequestURI());
        if (ex != null) {
            System.out.println("❌ [afterCompletion] Exception: " + ex.getMessage());
        }
    }

}
