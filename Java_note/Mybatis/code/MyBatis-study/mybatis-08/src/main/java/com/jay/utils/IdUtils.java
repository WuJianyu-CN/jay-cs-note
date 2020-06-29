package com.jay.utils;

import java.util.UUID;

public class IdUtils {


    public static String getId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
