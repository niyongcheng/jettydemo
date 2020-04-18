package com.niyongcheng.jettydemo.contract.impl;

import com.niyongcheng.jettydemo.contract.TokenService;
import com.niyongcheng.jettydemo.service.RedisService;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Service
public class TokenServiceImpl implements TokenService {
    private final RedisService redisService;
    private static final String TOKEN_PREFIX = "token";
    private static final String TOKEN_NAME = "token_id";

    @Autowired
    public TokenServiceImpl(RedisService redisService){
        this.redisService = redisService;
    }

    @Override
    public String createToken() {
        String str = UUID.randomUUID().toString();
        StringBuilder token = new StringBuilder();

        try{
            token.append(TOKEN_PREFIX).append(str);
            redisService.setEx(token.toString(),token.toString(),10000L);
            boolean notEmpty = StringUtil.isNullOrEmpty(String.valueOf(token));
            if(notEmpty){
                return token.toString();
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean checkToken(HttpServletRequest request) throws Exception {
        String token = request.getHeader(TOKEN_NAME);
        if(StringUtil.isNullOrEmpty(token)){
            token = request.getParameter(TOKEN_NAME);
            if(StringUtil.isNullOrEmpty(token)){
                throw new Exception();
            }
        }

        if(!redisService.exists(token)){

        }

        boolean remove = redisService.remove(token.toString());
        if(!remove){
            throw new Exception();
        }

        return true;
    }
}
