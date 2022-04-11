package com.nowcoder.example.dao.impl;

import com.nowcoder.example.dao.UserDao;
import com.nowcoder.example.entity.User;
import org.springframework.stereotype.Repository;

//@Repository
public class UserDaoJdbcImpl implements UserDao {
    @Override
    public User findById(int id) {
        System.out.println("select with jdbc.");
        User user = new User();
        user.setId(id);
        user.setUsername("user-" + id);
        user.setPassword("123456");
        return user;
    }
}
