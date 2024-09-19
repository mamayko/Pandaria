package com.javarush.animals;

import com.javarush.island.Location;
import com.javarush.island.Pandaria;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal implements Runnable,CanEat,Dying,Movable,Reproduction, Aging{
    private int locationId;
    private double weight;
    private int speed;
    private int x;
    private int y;
    private int age;
    private String[] parameters;
    public double getWeight(){
        return this.weight;
    }

}
