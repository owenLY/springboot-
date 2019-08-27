package com.ly;

public class HelloServer {
    private String name;
    private Integer age;

    public HelloServer(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void say(String message){
        System.err.println("["+name+"---"+age+"]:\t"+message);
    }
}
