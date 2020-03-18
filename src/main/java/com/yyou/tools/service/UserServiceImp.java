package com.yyou.tools.service;

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
    public void addUser(UserDto userDto) {
        long id = idGenerator.getId();
        User user = new User();
        user.setId(id);
        user.setDesc(userDto.getDescription());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        userDao.addUser(user);
    }

    @Override

    public void updateUser(long id,UpdateUserDto userDto) {
        updateUserInteranl(id,userDto);
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
