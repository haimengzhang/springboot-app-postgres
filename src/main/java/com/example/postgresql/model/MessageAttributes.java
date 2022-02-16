package com.example.postgresql.model;

import javax.persistence.Embeddable;

@Embeddable
public class MessageAttributes {

    String foo;

    String bar;

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    public String getBar() {
        return bar;
    }

    public void setBar(String bar) {
        this.bar = bar;
    }

}
