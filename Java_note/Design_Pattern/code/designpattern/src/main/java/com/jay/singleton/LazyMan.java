package com.jay.singleton;

// lazy singleton

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * 1. allocate memory
 * 2. process constructor, initialize object
 * 3. point this object to allocated memory in step1
 * <p>
 * 123
 * 132 A
 * B
 */
public class LazyMan {

    private static boolean jay = false;

    private LazyMan() {
        synchronized (LazyMan.class) {

            if (!jay) {
                jay = true;
            } else {
                throw new RuntimeException("Don't using reflection to get Instance!");
            }
        }
    }

    private volatile static LazyMan lazyMan;

    // double lock
    public static LazyMan getInstance() {
        if (lazyMan == null) {
            synchronized (LazyMan.class) {
                if (lazyMan == null) {
                    lazyMan = new LazyMan();    // not an atomic operation
                }
            }
        }

        return lazyMan;
    }

    // reflect
    public static void main(String[] args) throws Exception {
//        LazyMan instance1 = LazyMan.getInstance();

        Field jay = LazyMan.class.getDeclaredField("jay");
        jay.setAccessible(true);

        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        LazyMan instance1 = declaredConstructor.newInstance();

        jay.set(instance1, false);

        LazyMan instance2 = declaredConstructor.newInstance();

        System.out.println(instance1);
        System.out.println(instance2);
    }
}
