package com.jay.prototype.demo01;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * client: clone
 */
public class BiliBili {
    public static void main(String[] args) throws CloneNotSupportedException {
//        LocalDateTime dateTime = LocalDateTime.now();
        Date date = new Date();
        Video v1 = new Video("jayVedio", date);
        // v2 is v1's clone
        Video v2 = (Video) v1.clone();
        System.out.println("v1 => " + v1);
        System.out.println("v2 => " + v2);

        System.out.println("===============================");
        date.setTime(1234567);

        System.out.println("v1 => " + v1);
        System.out.println("v2 => " + v2);
    }
}

/*
        System.out.println("v1 hashCode => " + v1.hashCode());
        System.out.println("v2 => " + v2);
        System.out.println("v1 hashCode => " + v2.hashCode());
 */