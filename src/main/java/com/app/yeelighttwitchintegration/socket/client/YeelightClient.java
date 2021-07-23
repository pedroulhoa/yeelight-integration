package com.app.yeelighttwitchintegration.socket.client;

import com.app.yeelighttwitchintegration.utils.CommandsYeelight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.Socket;

@Component
public class YeelightClient {

    Logger logger = LoggerFactory.getLogger(YeelightClient.class);

    private Socket client;
    private DataOutputStream out;
    private BufferedReader in;

    public void startConnection(String ip, int port) {
        try {
            client = new Socket(ip, port);
            out = new DataOutputStream(client.getOutputStream());
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    public String sendMessage(String msg) {
        String resp = "NONE";
        try {
            out.writeBytes("{\"id\":0,\"method\":" + msg + "}" + "\r\n");
            resp = in.readLine();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return resp;
    }

    public void setPowerOn() {
        sendMessage(CommandsYeelight.POWER_ON);
    }

    public void setPowerOff() {
        sendMessage(CommandsYeelight.POWER_OFF);
    }

    public void stopConnection() {
        try {
            in.close();
            out.close();
            client.close();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

}
