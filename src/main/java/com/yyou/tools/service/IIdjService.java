package com.yyou.tools.service;

import com.yyou.tools.exception.HttpRequestException;

import java.io.IOException;

public interface IIdjService {
    String login(String username,String password)
            throws HttpRequestException,IOException;
}
