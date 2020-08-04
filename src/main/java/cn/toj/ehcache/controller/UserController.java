package cn.toj.ehcache.controller;

import cn.toj.ehcache.domain.User;
import cn.toj.ehcache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    CacheManager cacheManager;

    @PostMapping("/insert")
    public String addUser(@RequestBody User user) {

        System.out.println(userService.addUser(user));
        return "Insert success.";

    }

    @PostMapping("/select")
    public List<User> geUsersByName(@RequestBody User user ) {
        System.out.println( "-------------------------------------------" );
        System.out.println("call /getusersbyname");
        System.out.println(cacheManager.toString());
        List<User> users = userService.getUsersByName( user.getUsername() );
        return users;
    }

}
