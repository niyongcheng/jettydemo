package com.niyongcheng.jettydemo.service;

import com.niyongcheng.jettydemo.annotation.AutoIdempotent;
import com.niyongcheng.jettydemo.contract.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

@Component
public class AutoIdempotentInterceptor implements HandlerInterceptor {
    private final TokenService tokenService;

    @Autowired
    public AutoIdempotentInterceptor(TokenService tokenService){
        this.tokenService = tokenService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!(handler instanceof HandlerMethod)){
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        AutoIdempotent methodAnnotation = method.getAnnotation(AutoIdempotent.class);
        if(methodAnnotation != null){
            try{
                return tokenService.checkToken(request);
            }
            catch (Exception ex){
                throw  ex;
            }
        }
        //
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    private void writeReturnJson(HttpServletResponse response,String json) throws Exception{
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        try{
            writer = response.getWriter();
            writer.print(json);
        }
        catch (IOException ex){

        }finally {
            if(writer != null){
                writer.close();
            }
        }
    }
}
