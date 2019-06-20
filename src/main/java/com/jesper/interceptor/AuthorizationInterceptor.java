package com.jesper.interceptor;

import com.google.gson.Gson;
import com.jesper.model.ResultSet;
import com.jesper.token.AuthIgnore;
import com.jesper.token.TokenManager;
import com.jesper.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * 权限校验器
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {


    @Autowired
    private TokenManager tokenManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        AuthIgnore annotation;
        if (handler instanceof HandlerMethod) {
           annotation = ((HandlerMethod) handler).getMethodAnnotation(AuthIgnore.class);
        } else {
            return true;
        }

        if(null != annotation) {
            return true;
        }

        String token = request.getHeader(Constant.USER_TOKEN);
        if(StringUtils.isEmpty(token)) {
            token = request.getParameter(Constant.USER_TOKEN);
        }
        if(StringUtils.isEmpty(token)) {
            Object obj = request.getAttribute(Constant.USER_TOKEN);
            if(null != obj) {
                token = obj.toString();
            }
        }

        if(StringUtils.isEmpty(token)) { //
            this.writeErrorResult(response, "请登录后操作");
            return false;
        }

        if(!tokenManager.isUserLogin(token)) {
            this.writeErrorResult(response, "token已失效，请重新登录");
            return false;
        }

        return true;
        // return super.preHandle(request, response, handler);
    }

    private void writeErrorResult (HttpServletResponse response, String msg) {
        try {
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/json;charset=utf-8");
            PrintWriter out = response.getWriter();
            ResultSet rs =ResultSet.Failure_Auth(msg);
            Gson gson = new Gson();
            String result = gson.toJson(rs);

            out.write(result);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
