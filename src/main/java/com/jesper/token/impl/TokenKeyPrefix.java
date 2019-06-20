package com.jesper.token.impl;

import com.jesper.redis.KeyPrefix;

public class TokenKeyPrefix implements KeyPrefix {

    private int expireSeconds;

    private String prefix;

    public static TokenKeyPrefix getInstance() {
        return new TokenKeyPrefix();
    }

    private TokenKeyPrefix (){
        this.expireSeconds = 60*60*4; // 4个小时的过期时间
        this.prefix = "token_user_";
    }

    @Override
    public int expireSeconds() {
        return this.expireSeconds;
    }

    @Override
    public String getPrefix() {
        return this.prefix;
    }

}
