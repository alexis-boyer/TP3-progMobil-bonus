package com.example.listplanete;

import java.util.ArrayList;

public class data {
    public static ArrayList<Planet> planets = new ArrayList<Planet>();
    public static String[] taillePlanetes = {"4900", "12000", "12800", "6800", "144000", "120000", "52000", "50000", "2300"};
    public static  boolean auth = false;

    public static void initialize(){
        planets = new ArrayList<Planet>();
        planets.add(new Planet("Mercure", "4900"));
        planets.add(new Planet("Venus", "12000"));
        planets.add(new Planet("Terre", "12800"));
        planets.add(new Planet("Mars", "6800"));
        planets.add(new Planet("Jupiter", "144000"));
        planets.add(new Planet("Saturne", "120000"));
        planets.add(new Planet("Uranus", "52000"));
        planets.add(new Planet("Neptune", "50000"));
        planets.add(new Planet("Pluton", "2300"));
    }
}
