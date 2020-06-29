package com.jay.singleton;

import java.lang.reflect.Constructor;

public enum EnumSingle {

    INSTANCE;

    public EnumSingle getInstance() {
        return INSTANCE;
    }

}

class Test {
    public static void main(String[] args) throws Exception {
        EnumSingle instance1 = EnumSingle.INSTANCE;
        Constructor<EnumSingle> constructor = EnumSingle.class.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        EnumSingle enumSingle = constructor.newInstance();


        System.out.println(instance1);
        System.out.println(enumSingle);

    }
}
