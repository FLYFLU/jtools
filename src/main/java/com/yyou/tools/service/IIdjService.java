package com.yyou.tools.service;

import com.yyou.data.HttpMessage;

public interface IIdjService {
    HttpMessage login(String username,String password);
}
