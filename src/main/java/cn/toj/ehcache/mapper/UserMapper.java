package cn.toj.ehcache.mapper;

import cn.toj.ehcache.domain.User;

import java.util.List;

public interface UserMapper {

    int addUser(User user);

    List<User> getUsersByName(String userName);
}
