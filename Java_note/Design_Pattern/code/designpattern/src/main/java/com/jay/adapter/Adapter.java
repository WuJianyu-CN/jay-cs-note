package com.jay.adapter;

/**
 * real adapter: connect usb and cable
 * 1. extend (class adapter)
 * 2. composition (object adapter, most used)
 */
public class Adapter extends Cable implements NetToUsb {

    @Override
    public void handleRequest() {
        super.request();
    }
}
