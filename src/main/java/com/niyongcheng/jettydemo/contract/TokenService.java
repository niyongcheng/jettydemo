package com.niyongcheng.jettydemo.contract;

import javax.servlet.http.HttpServletRequest;

public interface TokenService {
    String createToken();
    boolean checkToken(HttpServletRequest request) throws Exception;
}
