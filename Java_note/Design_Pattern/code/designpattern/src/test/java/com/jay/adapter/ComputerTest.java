package com.jay.adapter;

import org.junit.Test;

public class ComputerTest {

    @Test
    public void test1() {
        Computer computer = new Computer();
        Cable cable = new Cable();
        Adapter adapter = new Adapter();

        computer.net(adapter);
    }

    @Test
    public void test2() {
        Computer computer = new Computer();
        Cable cable = new Cable();
        Adapter2 adapter2 = new Adapter2(cable);

        computer.net(adapter2);
    }
}