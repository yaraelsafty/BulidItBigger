package com.example.jokylib;

import java.util.Random;

public final  class MyJoks {
    private final static String[] JOKES = new String[]{
            "Programmer is a machine that turns coffee into code" ,
            "Q: What's Object Oriented way to become walthy? A: Inheritance",
            "Q: QWhy did the programmer quite his job? A: Because he didn't get arrays",
            "Q: What do  computers and Air conditions have in common? They both become useless when you open windows",
            "A real programmer count from 0",
            "Why do Java developers wear glasses? Because they can't C#"
    };


    private final static Random RANDOM = new Random();

    public static String getRandomJoke() {
        return JOKES[RANDOM.nextInt(JOKES.length)];
    }
}
