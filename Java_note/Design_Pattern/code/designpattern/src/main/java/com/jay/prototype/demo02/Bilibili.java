package com.jay.prototype.demo02;

import java.util.Date;

public class Bilibili {

    public static void main(String[] args) throws CloneNotSupportedException {
        Date date = new Date();
        Video v1 = new Video("jayVideo", date);
        Video v2 = (Video) v1.clone();

        System.out.println("v1 => " + v1);
        System.out.println("v2 => " + v2);

        System.out.println("===============================");
        date.setTime(1234567);

        System.out.println("v1 => " + v1);
        System.out.println("v2 => " + v2);
    }
}
