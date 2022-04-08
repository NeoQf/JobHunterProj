package com.nowcoder.example;

import com.nowcoder.example.dao.UserDao;
import com.nowcoder.example.entity.User;
import com.nowcoder.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@SpringBootTest
class ExampleApplicationTests implements ApplicationContextAware {

	// ApplicationContext extends BeanFactory
	// BeanFactory -> Spring Framework Developer
	// ApplicationContext -> plain Developer
	private ApplicationContext applicationContext;

	@Autowired
	private UserService userService;

	@Test
	public void testUserService() {
		User user = userService.getUser(1);
		System.out.println(user);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Test
	public void testApplicationContext() {
		UserDao dao1 = applicationContext.getBean(UserDao.class);
		System.out.println(dao1.findById(161));

		UserDao dao2 = (UserDao) applicationContext.getBean("userDaoHibernateImpl");
		System.out.println(dao2.findById(162));

		UserDao dao3 = applicationContext.getBean("userDaoHibernateImpl", UserDao.class);
		System.out.println(dao3.findById(163));
	}

}
