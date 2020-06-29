package com.jay.builder.demo02;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void test1() {
        Worker worker = new Worker();
        Product product = worker.buildA("chips").getProduct();
        System.out.println(product);
    }
}