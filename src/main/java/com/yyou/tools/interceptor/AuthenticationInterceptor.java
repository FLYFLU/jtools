package com.yyou.tools.interceptor;

import com.yyou.tools.annotations.AllowToken;
import com.yyou.tools.context.UserContext;
import com.yyou.tools.entity.User;
import com.yyou.tools.exception.AuthenticationException;
import com.yyou.tools.service.IUserService;
import com.yyou.tools.util.IAccessValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    private IUserService userService;
    @Autowired
    private IAccessValidator accessValidator;

    private final static String AUTHOR_HEAER__KEY = "Authorization";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        方法
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        AllowToken allowTokenAnnotation = handlerMethod.getMethod().getAnnotation(AllowToken.class);
        if(allowTokenAnnotation!=null && !allowTokenAnnotation.required()){
            return true;
        }
        String token = request.getHeader(AUTHOR_HEAER__KEY);
        if(StringUtils.isEmpty(token)){
            throw new AuthenticationException();
//            return false;
        }
        String userIdLong = accessValidator.getAccessKey(token);
        long userId = Long.valueOf(userIdLong);
        User user = userService.getUserById(userId);
        if( user ==null){
            throw new AuthenticationException();
        }
        UserContext.setLoginUser(user);
        return true;
    }
}
