package com.example.spring_boot_introduction_spring_boot.chpater07;

public class MyTLUtility {

    public String hello(String name) {
        return "Hello, <b>" + name + "!</b>";
    }

    public String prevUrl(int num) {
        return "/page/" + (num > 1 ? num - 1 : 1);
    }

    public String nextUrl(int num) {
        return "/page/" + (num + 1);
    }
}
