package com.app.yeelighttwitchintegration.service;

import com.app.yeelighttwitchintegration.socket.client.YeelightClient;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class YeelightIntegrationServiceTest {

    @Autowired
    private YeelightClient yeelightClient;

    @BeforeAll
    void init() {
        yeelightClient.startConnection("192.168.1.70", 55443);
    }

    @AfterAll
    void close() {
        yeelightClient.stopConnection();
    }

    @Test
    void setPowerOnTest() {
        yeelightClient.setPowerOn();
    }

    @Test
    void setPowerOffTest() {
        yeelightClient.setPowerOff();
    }

}