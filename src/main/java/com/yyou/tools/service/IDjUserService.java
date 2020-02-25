package com.yyou.tools.service;

import com.yyou.tools.entity.IDJUser;

import java.util.List;

public interface IDjUserService {
    IDJUser getUser(int id);

    List<IDJUser> getAll();
}
