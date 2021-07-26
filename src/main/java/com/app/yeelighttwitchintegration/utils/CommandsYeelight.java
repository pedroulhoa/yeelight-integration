package com.app.yeelighttwitchintegration.utils;

public class CommandsYeelight {

    public static String POWER_ON = "\"set_power\",\"params\":[\"on\", \"sudden\", 10]";
    public static String POWER_OFF = "\"set_power\",\"params\":[\"off\", \"sudden\", 10]";
    public static String COLOR_FLOW = "\"start_cf\",\"params\":[4, 2, \"1000, 2, 2700, 100, 500, 1, 255, 10, 5000, 7, 0,0, 500, 2, 5000, 1\"]";
}
