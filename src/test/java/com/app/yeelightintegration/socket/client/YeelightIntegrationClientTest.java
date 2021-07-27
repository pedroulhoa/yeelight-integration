package com.app.yeelightintegration.socket.client;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class YeelightIntegrationClientTest {

    @Autowired
    private YeelightClient yeelightClient;

    @Value( "${yeelight.ip}" )
    private String ip;

    @Value( "${yeelight.port}" )
    private int port;

    @BeforeAll
    void init() {
        yeelightClient.startConnection(ip, port);
    }

    @AfterAll
    void close() {
        yeelightClient.stopConnection();
    }

    @Test
    void
    setPowerOnTest() {
        String response = yeelightClient.setPowerOn();
        System.out.println(response);
    }

    @Test
    void setPowerOffTest() {
        String respose = yeelightClient.setPowerOff();
        System.out.println(respose);
    }

    @Test
    void colorFlowTest() {
        String response = yeelightClient.colorFlowMode();
        System.out.println(response);
    }

}