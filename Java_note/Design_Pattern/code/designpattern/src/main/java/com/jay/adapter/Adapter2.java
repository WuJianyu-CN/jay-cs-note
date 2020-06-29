package com.jay.adapter;

/**
 * real adapter: connect usb and cable
 * 1. extend (class adapter)
 * 2. composition (object adapter, most used)
 */
public class Adapter2 implements NetToUsb {

    private Cable cable;

    public Adapter2(Cable cable) {
        this.cable = cable;
    }

    public Adapter2() {
    }

    @Override
    public void handleRequest() {
        cable.request();
    }
}
