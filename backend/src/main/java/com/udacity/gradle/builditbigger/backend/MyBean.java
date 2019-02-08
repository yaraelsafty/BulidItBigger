package com.udacity.gradle.builditbigger.backend;

import com.example.jokylib.MyJoks;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private MyJoks myJoks;

    public MyBean() {
        myJoks = new MyJoks();
    }

    public String getJoke() {
        return MyJoks.getRandomJoke();
    }
}