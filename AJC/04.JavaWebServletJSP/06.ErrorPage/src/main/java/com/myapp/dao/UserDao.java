package com.myapp.dao;

import com.myapp.model.User;

import java.util.*;

public class UserDao {
    Map<String, User> users = new HashMap<String, User>() {
        {
            put("Jack", new User("John", "Jack", 2000));
            put("Bob", new User("Bob", "Dilan", 3000));
            put("Alicia", new User("Alicia", "Keys", 4000));
        }
    };

    public User findUser(String id) {
        return users.get(id);
    }
    public List returnUserList(){
        List<String> keys = new ArrayList<>(users.keySet());
        return keys;
    }

    public Collection<User> returnUserList2(){
        return users.values();
    }


}