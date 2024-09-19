package com.javarush.island;

import com.javarush.animals.*;

import java.util.List;

public class AnimalsInformation {

    public static int getNumberRabbit(List<Animal> animals){
        int number = 0;
        for (int i = 0; i < animals.size(); i++) {
            if(animals.get(i) instanceof Rabbit)
                number++;
        }
        return number;
    }
    public static int getNumberHorse(List<Animal> animals){
        int number = 0;
        for (int i = 0; i < animals.size(); i++) {
            if(animals.get(i) instanceof Horse)
                number++;
        }
        return number;
    }
    public static int getNumberInsects(List<Animal> animals){
        int number = 0;
        for (int i = 0; i < animals.size(); i++) {
            if(animals.get(i) instanceof Insects)
                number++;
        }
        return number;
    }
    public static int getNumberDeer(List<Animal> animals){
        int number = 0;
        for (int i = 0; i < animals.size(); i++) {
            if(animals.get(i) instanceof Deer)
                number++;
        }
        return number;
    }
}
