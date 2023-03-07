package com.mwhite;

import java.util.HashMap;
import java.util.Map;

public class myMaps {

    /**
     * Credit: Hashmap example from Udemy Java Masterclass by Tim Buchalka.
     * Maps contain a key value pair.
     * Create entries using put and access them using get.
     * Keys must be unique, the new value would be overwritten if you try to put another one.
     *
     * To determine if the key already exists use containsKey
     */
    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        languages.put("Java", "a compiled high level, object-oriented language.");
        languages.put("Python", "an interpreted, object-oriented language.");
        languages.put("Algol", "an algorithmic language.");
        languages.put("Basic", "Beginners All Purpose Symbolic Instruction Code.");
        languages.put("Lisp", "therein lies madness.");

        System.out.println(languages.get("Java"));

        if(languages.containsKey("Java")) {
            System.out.println("The key Java is already in the map.");
        } else {
            languages.put("Java", "this course is about Java.");
            System.out.println("Java Key and value added successfully.");
        }

        //loop through the contents and print their key : value
        for(String key : languages.keySet()) {
            System.out.println(key + " : " + languages.get(key));
        }
    }
}
