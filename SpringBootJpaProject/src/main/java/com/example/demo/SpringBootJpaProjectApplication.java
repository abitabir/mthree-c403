package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.example.demo.dao.UserRepositary;
import com.example.demo.entities.User;

@SpringBootApplication
public class SpringBootJpaProjectApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBootJpaProjectApplication.class, args);
        UserRepositary userRepositary = context.getBean(UserRepositary.class);

        User u1 = new User();
        u1.setName("Abir");
        u1.setCity("UK");
        u1.setStatus("Developer");

        User user1 = userRepositary.save(u1);
        System.out.println(user1);

        User u2 = new User();
        u2.setName("Abir2");
        u2.setCity("UK2");
        u2.setStatus("Devloper2");

        User u3 = new User();
        u3.setName("Abir3");
        u3.setCity("UK3");
        u3.setStatus("Devloper3");

        List<User> userList = List.of(u2, u3);
        Iterable<User> iterableUsers = userRepositary.saveAll(userList);

        for (User user : iterableUsers) {
            System.out.println(user);
        }

        Optional<User> optional = userRepositary.findById(1);
        User us1 = optional.get();

        System.out.println("Before Update");
        System.out.println(us1);

        us1.setName("Aysu");
        us1.setStatus("Hacker");
        System.out.println("After Update");
        System.out.println(us1);

        userRepositary.save(us1);

        userRepositary.deleteById(3);
        System.out.println("User deleted");
    }

}
