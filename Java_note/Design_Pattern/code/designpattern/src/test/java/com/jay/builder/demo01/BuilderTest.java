package com.jay.builder.demo01;

import org.junit.Test;

public class BuilderTest {

    @Test
    public void test1() {
        Director director = new Director();

        Product build = director.build(new Worker());
        System.out.println(build);
    }
}