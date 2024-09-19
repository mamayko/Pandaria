package com.javarush.animals;
import com.javarush.island.Location;
import com.javarush.island.Pandaria;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Insects extends Animal{
    public static int count;
    private int locationId;
    private double weight = 0.01;
    private int speed = 0;
    private int x;
    private int y;
    private int age;
    private String[] parameters;

    public Insects(int id) {
        this.locationId = id;
        this.age = 0;
        count++;
    }
    @Override
    public void eat() {

    }

    @Override
    public void canDie() {

        if(this.age > 3){
            List<Location> locations = Pandaria.getLocations();
            List<Animal> animals = locations.get(locationId).getAnimals();
            animals.remove(this);
        }

    }

    @Override
    public synchronized void move() {

    }

    @Override
    public void Reproduction() {
        List<Location> locations = Pandaria.getLocations();
        List<Animal> animals = locations.get(locationId).getAnimals();
        for (int i = 0; i < animals.size(); i++) {
            if(animals.get(i) instanceof Insects && animals.get(i) != this){
                animals.add(new Insects(this.locationId));
                break;
            }
        }
    }
    public void aging() {
        this.age++;
    }


    @Override
    public void run() {
        synchronized (Pandaria.getLocations().get(locationId)) {

            Reproduction();

            canDie();
            Pandaria.getLocations().get(locationId).notifyAll();
        }
    }

    public int getSpeed() {
        return speed;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

}
