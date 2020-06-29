package com.jay.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// <bean id="user" class="com.jay.pojo"/>
@Component
@Scope(value = "singleton")
public class User {

    // <property name="name" value="Jay"/>
    @Value("Jay")
    public String name;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
