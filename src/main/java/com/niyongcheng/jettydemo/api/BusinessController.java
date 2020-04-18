package com.niyongcheng.jettydemo.api;

import com.niyongcheng.jettydemo.annotation.AutoIdempotent;
import com.niyongcheng.jettydemo.contract.TokenService;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class BusinessController {
    private final TokenService tokenService;
    //private final TestSe

    @Autowired
    public BusinessController(TokenService tokenService){
        this.tokenService = tokenService;
    }

    @RequestMapping(value = "token", method = RequestMethod.POST,consumes = MediaType.ALL_VALUE,
    produces = MediaType.ALL_VALUE)
    public String getToken(){
        String token = tokenService.createToken();
        if(StringUtil.isNullOrEmpty(token)){

        }
        return StringUtil.EMPTY_STRING;
    }

    @AutoIdempotent
    @RequestMapping(value = "test/Idempotence", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE,
            produces = MediaType.ALL_VALUE)
    public String testIdempotence(){

        return StringUtil.EMPTY_STRING;
    }
}
