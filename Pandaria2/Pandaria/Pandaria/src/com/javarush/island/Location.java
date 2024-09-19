package com.javarush.island;

import com.javarush.animals.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class Location {
    private static int width = 1;
    private static int height = 1;
    private int x;
    private int y;

    private int id;
    private static int count;
    private Plants plant;

    private List<Animal> animals = new ArrayList<>();

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public Location(String[] parameters) {
        if(width <= Integer.parseInt(parameters[0])) {
            this.x = width;
            this.y = height;
            width++;
        }
        else{
            this.x = 1;
            width = 2;
            height++;
            this.y = height;

        }
        this.id = count++;

        this.plant = new Plants(Double.parseDouble(parameters[3]), Integer.parseInt(parameters[4]));

        for (int i = 0; i < ThreadLocalRandom.current().nextInt(30); i++) {
            animals.add(new Wolf(this.id));
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(150); i++) {
            animals.add(new Rabbit(this.id));
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(20); i++) {
            animals.add(new Horse(this.id));
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(20); i++) {
            animals.add(new Deer(this.id));
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(500); i++) {
            animals.add(new Mouse(this.id));
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(140); i++) {
            animals.add(new Goat(this.id));
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(50); i++) {
            animals.add(new Boar(this.id));
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(10); i++) {
            animals.add(new Buffalo(this.id));
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(140); i++) {
            animals.add(new Sheep(this.id));
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(200); i++) {
            animals.add(new Duck(this.id));
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(100, 1000); i++) {
            animals.add(new Insects(this.id));
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(5); i++) {
            animals.add(new Panda(this.id));
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(300); i++) {
            animals.add(new Mouse(this.id));
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(500); i++) {
            animals.add(new Squirrel(this.id));
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(30); i++) {
            animals.add(new Fox(this.id));
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(30); i++) {
            animals.add(new Lynx(this.id));
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(20); i++) {
            animals.add(new Eagle(this.id));
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(5); i++) {
            animals.add(new Bear(this.id));
        }



    }

    public Location() {

    }

    @Override
    public String toString() {
        return "x: " + this.x + " y: " + this.y + " id: " + this.id;
    }



    public int getLocationId() {
        return id;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public Plants getPlant() {
        return plant;
    }

    public void setPlant(Plants plant) {
        this.plant = plant;
    }

//    @Override
//    public void run() {
//
//        getPlant().run();
////        System.out.println("Rabbits in location ID " + getLocationId() + ":" + AnimalsInformation.getNumberRabbit(getAnimals()));
////        System.out.println("Horse in location " + AnimalsInformation.getNumberHorse(getAnimals()));
////        System.out.println("Deer in location " + AnimalsInformation.getNumberDeer(getAnimals()));
////        System.out.println("Insects in location " + AnimalsInformation.getNumberInsects(getAnimals()));
////        System.out.println(Wolf.count);
////        System.out.println("___________________________________________________________");
//
//    }


}
