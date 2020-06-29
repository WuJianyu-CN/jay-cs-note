package com.jay.builder2;

import com.jay.builder.demo01.Director;
import com.jay.builder.demo01.Product;
import com.jay.builder.demo01.Worker;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuilderTest {

    @Test
    public void test1() {
        Director director = new Director();
        Product product = director.build(new Worker());

        System.out.println(product);
    }

}