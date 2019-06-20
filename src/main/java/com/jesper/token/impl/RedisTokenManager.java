package com.jesper.token.impl;

import com.jesper.model.User;
import com.jesper.redis.RedisService;
import com.jesper.token.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component(value = "tokenManager")
public class RedisTokenManager implements TokenManager {

    @Autowired
    private RedisService redisService;

    private TokenKeyPrefix keyPrefix = TokenKeyPrefix.getInstance();

    @Override
    public String getToken(User user) {
        String token = UUID.randomUUID().toString();

        redisService.set(keyPrefix, token, user);
        return token;
    }

    @Override
    public void refreshUserToken(String token) {
        if(redisService.exists(keyPrefix, token)) {
            User user = this.getUserByToken(token);
            this.loginOff(token);
            redisService.set(keyPrefix, token, user);
        }
    }

    @Override
    public void loginOff(String token) {
        redisService.delete(keyPrefix, token);
    }

    @Override
    public User getUserByToken(String token) {
        User user = redisService.get(keyPrefix, token, User.class);
        return user;
    }

    @Override
    public boolean isUserLogin(String token) {
        redisService.get(keyPrefix, token, User.class);
        return redisService != null;
    }
}
