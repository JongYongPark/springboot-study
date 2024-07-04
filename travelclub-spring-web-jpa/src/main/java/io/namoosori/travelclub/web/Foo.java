package io.namoosori.travelclub.web;

import java.util.Objects;

public class Foo {
    private Bar bar;

    Foo(){
        System.out.println("Foo constructor");
        if(this.bar == null){
            System.out.println("this.bar : null");
        }
        else{
            System.out.println("this.bar : " + this.bar);
        }
    }
    // 생성자에서 new Bar() 를 통해 Bar instance를 생성하지 않고 DI에 맞긴다.
    public void setBar(Bar bar) {
        System.out.println("Foo setBar()");
        this.bar = bar;
    }
    public void say(){
        System.out.println("Foo say(). call bar.say()");
        this.bar.say();
    }
}

