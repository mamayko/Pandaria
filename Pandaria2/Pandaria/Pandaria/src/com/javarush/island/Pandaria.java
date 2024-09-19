package com.javarush.island;

import com.javarush.animals.*;
import org.w3c.dom.ls.LSOutput;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.javarush.constants.ApplicationCompetitionConstants.*;

public class Pandaria implements Runnable{
    private static int days;
    private static final List<Location> locations = new ArrayList<>();
    private static String[] parameters;


    public Pandaria(String[] parameters) {
        this.parameters = parameters;
    }

    public void create() {
        for (int i = 0; i < (Integer.parseInt(parameters[0]) * Integer.parseInt(parameters[1])); i++) {
            locations.add(new Location(parameters));
            days = 1;

        }

    }
    public void print(){
        for (int i = 0; i < Integer.parseInt(parameters[0]) * Integer.parseInt(parameters[1]); i++) {
            System.out.println(locations.get(i));
        }
    }

    public static String[] getParameters() {
        return parameters;
    }

    public static List<Location> getLocations() {
        return locations;
    }

    public static int getDays() {
        return days;
    }

    public static void setDays(int days) {
        Pandaria.days = days;
    }

    @Override
    public void run() {
        ExecutorService es = Executors.newFixedThreadPool(4);
        System.out.println(DAYINFO + days);

        for (int i = 0; i < locations.size(); i++) {
            locations.get(i).getPlant().run();
            for (int j = 0; j < locations.get(i).getAnimals().size(); j++) {
                es.execute(locations.get(i).getAnimals().get(j));
            }
        }
        System.out.println(PLANTSINFOMESSAGE + Plants.getAllVolumePlants());
        System.out.println(RABBITINFOMESSAGE + Rabbit.count);
        System.out.println(SQUIRRELSINFOMESSAGE + Squirrel.count);
        System.out.println(WOLFINFOMESSAGE + Wolf.count);
        System.out.println(SHEEPINFOMESSAGE + Sheep.count);
        System.out.println(PANDAINFOMESSAGE + Panda.count);
        System.out.println(MOUSEINFOMESSAGE + Mouse.count);
        System.out.println(LYNXINFOMESSAGE + Lynx.count);
        System.out.println(INSECTSINFOMESSAGE + Insects.count);
        System.out.println(HORSEINFOMESSAGE + Horse.count);
        System.out.println(GOATINFOMESSAGE + Goat.count);
        System.out.println(FOXINFOMESSAGE + Fox.count);
        System.out.println(EAGLEINFOMESSAGE + Eagle.count);
        System.out.println(DUCKINFOMESSAGE + Duck.count);
        System.out.println(DEERINFOMESSAGE + Deer.count);
        System.out.println(BUFFALOINFOMESSAGE + Buffalo.count);
        System.out.println(BOARINFOMESSAGE + Boar.count);
        System.out.println(BEARINFOMESSAGE + Bear.count);
        days++;

    }
}
