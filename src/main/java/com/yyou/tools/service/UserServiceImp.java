package com.yyou.tools.service;

import com.yyou.data.HttpMessage;
import com.yyou.tools.dto.user.UpdateUserDto;
import com.yyou.tools.dto.user.UserDto;
import com.yyou.tools.entity.User;
import com.yyou.tools.dao.UserDao;
import com.yyou.tools.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImp implements IUserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private IdGenerator idGenerator;
    @Override
    public User getUserById(long uuid) {
        User user = userDao.getUserById(uuid);
        return user;
    }

    @Override
    public HttpMessage addUser(UserDto userDto) {
        long id = idGenerator.getId();
        User user = new User();
        user.setId(id);
        user.setDesc(userDto.getDescription());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        int count = userDao.addUser(user);
        return count == 1 ? HttpMessage.OK : new HttpMessage(-1, "新建失败");
    }

    @Override

    public HttpMessage updateUser(long id,UpdateUserDto userDto) {
        int count = updateUserInteranl(id,userDto);
        return count == 1 ? HttpMessage.OK : new HttpMessage(-1, "更新失败");
    }

    @Transactional
     int updateUserInteranl(long id,UpdateUserDto userDto){
        User user = getUserById(id);
        if(user==null){
            return 0;
        }
        User userUpdate = new User(userDto.getName(),userDto.getDescription());
        userUpdate.setId(id);
        return  userDao.updateUser(userUpdate);
    }
}
