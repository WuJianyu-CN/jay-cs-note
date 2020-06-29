package com.jay.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class IdUtilsTest {

    @Test
    public void testId() {
        String id = IdUtils.getId();
        System.out.println(id);
    }
}