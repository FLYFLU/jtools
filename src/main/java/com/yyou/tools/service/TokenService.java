package com.yyou.tools.service;

import com.yyou.tools.util.IAccessValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface TokenService {
    String getToken(long id,String password);
}
