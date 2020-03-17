package com.yyou.tools.mapper;

import com.yyou.tools.dto.idj.AddIdjUserDto;
import com.yyou.tools.entity.IDJUser;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

//添加componentModel=spring才会注入
@Mapper(componentModel="spring")
public interface IdjUserMapper {
//    IdjUserMapper INSTANCE = Mappers.getMapper( IdjUserMapper.class );

//    @Mapping(target = "targetProperty",source = "sourceProperty")
//@Mapping(ignore = true)
    IDJUser dto2Entity(AddIdjUserDto addIdjUserDto);

}
