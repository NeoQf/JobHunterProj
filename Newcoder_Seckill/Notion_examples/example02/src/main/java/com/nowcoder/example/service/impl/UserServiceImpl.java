package com.nowcoder.example.service.impl;

import com.nowcoder.example.dao.UserDao;
import com.nowcoder.example.entity.User;
import com.nowcoder.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
//@Scope("prototype")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(int id) {
//        Integer.valueOf("abc");
        return userDao.findById(id);
    }

    @PostConstruct
    public void init() {
        System.out.println("init UserServiceImpl");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy UserServiceImpl");
    }

}
