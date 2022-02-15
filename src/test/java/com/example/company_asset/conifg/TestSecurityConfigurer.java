package com.example.company_asset.conifg;



import com.example.company_asset.config.SecurityConfigurer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TestSecurityConfigurer {
    @Autowired
    SecurityConfigurer securityConfigurer;

    @Test
    public void authenticationManagerBeanTest() throws Exception {
        final AuthenticationManager authenticationManager=securityConfigurer.authenticationManagerBean();
        assertNotNull(authenticationManager);
    }

    @Test
    public  void passwordEncoderTest()
    {
        final NoOpPasswordEncoder encoder= (NoOpPasswordEncoder) securityConfigurer.passwordEncoder();
        final String encodedPassword=encoder.encode("password");
        assertEquals("password",encodedPassword);
    }

}
