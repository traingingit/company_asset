package com.example.company_asset.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestUserDetailService {

    @Autowired
    MyUserDetailService myUserDetailService;

    @Test
    public void testLoadUserByName()
    {
        User u=new User("anuj","password",new ArrayList<>());
        assertEquals(u,myUserDetailService.loadUserByUsername("anuj"));
    }

}
