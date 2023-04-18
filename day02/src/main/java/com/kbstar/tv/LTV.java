package com.kbstar.tv;

import com.kbstar.frame.TV;

public class LTV implements TV {
    @Override
    public void turnOn() {
        System.out.println("LTV Turn on");
    }

    @Override
    public void turnOff() {
        System.out.println("LTV Turn off");
    }
}
