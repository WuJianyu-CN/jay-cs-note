package com.jay.bridge;

import org.junit.Test;

import static org.junit.Assert.*;

public class BridgeTest {

    @Test
    public void test1() {
        // Apple laptop
        Computer computer = new Laptop(new Apple());
        computer.info();

        // Dell DeskTop
        Computer computer2 = new Desktop(new Dell());
        computer2.info();
    }

}