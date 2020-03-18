package com.yyou.tools.service;

import com.yyou.data.HttpMessage;
import com.yyou.tools.dto.idj.AddIdjUserDto;
import com.yyou.tools.dto.idj.UpdateIdjUserDto;
import com.yyou.tools.entity.IDJUser;

import java.util.List;

public interface IDjUserService {
    IDJUser getUser(long id);

    List<IDJUser> getAll();

    void addIdjUser(AddIdjUserDto idjUser);

    void updateIdjUser(long id, UpdateIdjUserDto idjUserDto);
}
