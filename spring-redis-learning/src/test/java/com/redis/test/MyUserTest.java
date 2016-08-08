package com.redis.test;

/**
 * Created by Lingfeng on 2016/8/5.
 */
/*@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RedisApplication.class)
@WebAppConfiguration
@DirtiesContext
public class MyUserTest {

    @Autowired
    private MyUserRepository myUserRepository;


    @Test
    public void test() {
        MyUser user = new MyUser("lfwang", 26);
        String key = "my:user:lfwang";

        myUserRepository.set(key, user);
        MyUser myUser = myUserRepository.get(key);

        System.out.printf("my user: %s", myUser);
        System.out.println();
    }
}*/
