package com.wcg.test;

import com.wcg.SpringBootFireApplication;
import com.wcg.entity.User;
import com.wcg.service.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author chengangw
 * @date 4/8/2017 5:20 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootFireApplication.class)
public class SpringBootFireApplicationTest {
    @Autowired
    UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        userRepository.deleteAll();
    }

    @Test
    public void test() throws Exception {
        userRepository.save(new User(2L, "bbb", "223344"));
        userRepository.save(new User(3L, "ccc", "3344555"));
        userRepository.save(new User(4L, "ddd", "44455666"));
        Assert.assertEquals(3, userRepository.findAll().size());

        User user = userRepository.findOne(2L);
        userRepository.delete(user);
        Assert.assertEquals(2, userRepository.findAll().size());

        User user1 = userRepository.findByUsername("ccc");
        userRepository.delete(user1);
        Assert.assertEquals(1, userRepository.findAll().size());

    }
}
