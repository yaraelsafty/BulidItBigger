package com.example.jokylib;

import java.util.Random;

public class MyJoks {
    private String[] jokes;
    private Random random;

    public MyJoks() {
        jokes = new String[]{
                "Programmer is a machine that turns coffee into code" ,
                "Q: What's Object Oriented way to become walthy? A: Inheritance",
                "Q: QWhy did the programmer quite his job? A: Because he didn't get arrays",
                "Q: What do  computers and Air conditions have in common? They both become useless when you open windows",
                "A real programmer count from 0",
                "Why do Java developers wear glasses? Because they can't C#"
        };


        random = new Random();
    }

    public String[] getJokes() {
        return jokes;
    }

    public String getRandomJoke() {
        System.out.println("random Joke"+jokes[random.nextInt(jokes.length)]);
        return jokes[random.nextInt(jokes.length)];
    }

}
