package com.javaer.jwtdemo.controller.intercepter;

import com.javaer.jwtdemo.service.Token;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IpIntercepter implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("--------------");
        System.out.println("我拦截了url：" + request.getRequestURI());
        String authorization = request.getHeader("authorization");
        String token = authorization.replace("Bearer ","");

        if (null == authorization|| "".equals(authorization) ){
            System.out.println("authorization为空");
            return false;
        }else{
            System.out.println("放行" + token); //Bearer 123456

            boolean b = Token.verify(token);
            System.out.println(b);
            if(!b){
                System.out.println("登录失败");
                return false;
            }
            String userName1 = Token.getToken(token,"username");
            System.out.println(userName1);
        }
        System.out.println("--------------");
        return true;
    }
}
