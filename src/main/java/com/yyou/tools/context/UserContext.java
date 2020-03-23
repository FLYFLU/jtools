package com.yyou.tools.context;

import com.yyou.tools.entity.User;

//优雅储存用户信息
public class UserContext {

    private static ThreadLocal<User> loginUser = new ThreadLocal<>();

    public static User getLoginUser() {
        return loginUser.get();
    }

    public static void setLoginUser(User loginUser) {
        UserContext.loginUser.set(loginUser);
    }
}
