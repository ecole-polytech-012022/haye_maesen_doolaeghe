package com.polytech.eventmanager.service;

import com.polytech.eventmanager.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    public List<User> getAllUsers() {
        User user1 = new User();
        user1.setName("user1");
        user1.setEmail("mail@test.com");

        User user2 = new User();
        user2.setName("user2");
        user2.setEmail("mail2@test.com");

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);

        return list;
    }

}
