package com.jesper.token;

import com.jesper.model.User;

public interface TokenManager {

    /**
     * 创建token
     * @param user
     * @return
     */
    String getToken(User user);

    /**
     * 刷新用户
     * @param token
     */
    void refreshUserToken(String token);

    /**
     * 用户退出登录
     * @param token
     */
    void loginOff(String token);

    /**
     * 获取用户信息
     * @param token
     * @return
     */
    User getUserByToken(String token);

    /**
     * 判断用户是否登录
     * @param token
     * @return
     */
    boolean isUserLogin(String token);

}
