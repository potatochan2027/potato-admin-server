package com.potato.commonpro;

import com.potato.commonpro.model.SUser;
import com.potato.commonpro.service.SUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

@SpringBootTest
class CommonProApplicationTests {

    @Autowired
    SUserService sUserService;

    @Test
    void contextLoads() {
        SUser sUser=new SUser();
        sUser.setUsername("test1");
        sUser.setPassword("Potato2021");
        sUserService.add(sUser);
    }

}
