package cn.toj.ehcache.service;

import cn.toj.ehcache.domain.User;
import cn.toj.ehcache.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int addUser( User user ) {
        return userMapper.addUser(user);
    }

    @Cacheable(value = "user", key = "#userName")
    public List<User> getUsersByName(String userName ) {
        List<User> users = userMapper.getUsersByName( userName );
        System.out.println( "从数据库读取，而非读取缓存！" );
        return users;
    }
}
