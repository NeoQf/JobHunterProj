# 1 功能
&nbsp;&nbsp;如图是spring、spring MVC、spring boot的简单功能概要。<br/>
&nbsp;&nbsp;<img src="img.png" width = "600" height = "450" alt="" />

# 2 springBoot 
## 2.1 构建项目


# 3 spring
## 3.1 IOC实现可插拔（对spring的理解）
1. 例如：接口UserDao；
2. 其实现类UserDaoHibernateImpl与UserDaoJdbcImpl；
3. 只使用其中一个，那么只能对其中一个加@Repository注解；
4. 或者两个都加，但是这样的话要选择优先级，那么可以对其中要使用的那个加上@Primary注解。
5. 总结：从这里我学到了spring调用接口方法，其实调用了其实现类的方法，只不过是用了@Repository进行Bean的自动管理。

## 3.2 IOC管理哪些Bean
问题：为什么entity下的User类就不使用IOC（@Repository等Bean的注解）进行Bean的管理？
1. IOC一般用于管理**可复用的、不变的**类；不可复用的、易变的类不适用IOC进行管理。<br/>
   如dao和service，它们都是单例的，只需要实例化一次即可反复使用，因为那些类中没有数据，没有直接的成员变量，只是一个逻辑，这种逻辑是可以复用的，像这种可以复用的、一般可以单例的，我们都可以使用IOC进行管理。
   package com.nowcoder.example.dao.impl;<br/>
   如，UserDaoJdbcImpl.java：
    ```java
    package com.nowcoder.example.dao.impl;
    
    import com.nowcoder.example.dao.UserDao;
    import com.nowcoder.example.entity.User;
    import org.springframework.stereotype.Repository;
    
    @Repository
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
    ```

2. User是封装数据的实体。<br/>
   它在程序中需要有多个实例，例如：有10000个用户，就需要10000个user。
   一般来说，频繁发生变化，且需要很多实例的类，都不使用IOC进行管理。<br/>
    如，User.java：
    ```java
    package com.nowcoder.example.entity;
    
    public class User {
    
        private Integer id;
        private String username;
        private String password;
        // getter、setter以及toString方法略...
    }
    ```
