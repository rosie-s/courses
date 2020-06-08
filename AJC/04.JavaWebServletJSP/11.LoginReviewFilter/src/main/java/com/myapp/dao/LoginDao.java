package com.myapp.dao;

import com.myapp.model.Login;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class LoginDao {
    Map<String, Login> loginMap = new HashMap<String, Login>() {
        {
            put("john", new Login("John@john.com", "12345"));
            put("bob", new Login("Bob@bob.com", "12345"));
            put("alicia", new Login("Alicia@alicia.com", "qwerty"));
            put("ro", new Login("ro@h.com", "ro"));
        }
    };

    public void addLogin(Login newLogin) {
        loginMap.put(newLogin.getKey(), newLogin);
    }

    public void removeLogin(String key) {
        loginMap.remove(key);
    }

    public Login findLogin(String key) {
        key = StringUtils.substringBefore(key, "@");
        return loginMap.get( key.toLowerCase());
    }

    public Collection<Login> returnLoginList() {
        return loginMap.values();
    }

    public boolean inDB(String email, String password) {
        Login login = new Login(email, password);
        if (loginMap.containsValue(login)){
            return true;
        } else{
            return false;
        }
    }
}

