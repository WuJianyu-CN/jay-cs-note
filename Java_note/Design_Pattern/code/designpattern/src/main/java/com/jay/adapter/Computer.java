package com.jay.adapter;

/**
 * client: can't fix the Cable
 */
public class Computer {

    // computer should connect a adapter
    public void net(NetToUsb adapter) {
        adapter.handleRequest();
    }
}
