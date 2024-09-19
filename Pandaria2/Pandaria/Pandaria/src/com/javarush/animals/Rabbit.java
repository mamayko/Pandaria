package com.javarush.animals;

import com.javarush.island.Location;
import com.javarush.island.Pandaria;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Rabbit extends Herbivorous{
    public static int count;
    private int locationId;
    private double weight = 2.0;
    private int speed = 2;
    private int x;
    private int y;
    private int age;
    private String[] parameters;
    List<Location> locations = Pandaria.getLocations();


    public Rabbit(int id) {

        this.locationId = id;
        this.age = 0;
        count++;

    }

    public int getX() {
        List<Location> locations = Pandaria.getLocations();

        return locations.get(locationId).getX();
    }

    public int getY() {
        List<Location> locations = Pandaria.getLocations();

        return locations.get(locationId).getY();

    }




    @Override
    public void eat() {
        List<Location> locations = Pandaria.getLocations();
        Plants plant = locations.get(locationId).getPlant();
        double plantVolume = plant.getPlantsVolume();
        plant.setPlantsVolume(plantVolume - 10.0012);
        setWeight(getWeight() + 60);

    }

    @Override
    public void canDie() {
        if(this.weight < 120) {
            List<Location> locations = Pandaria.getLocations();
            List<Animal> animals = locations.get(locationId).getAnimals();
            animals.remove(this);
        }
        if(this.age > 50){
            List<Location> locations = Pandaria.getLocations();
            List<Animal> animals = locations.get(locationId).getAnimals();
            animals.remove(this);
        }

    }

    @Override
    public void move() {

            int moves = ThreadLocalRandom.current().nextInt(speed);
            setWeight(getWeight() - (moves * (getWeight() / 25)));

            List<Animal> animals = locations.get(locationId).getAnimals();
            for (int i = 0; i < moves; i++) {
                int direction = ThreadLocalRandom.current().nextInt(4);
                if (locations.get(locationId).getAnimals().indexOf(this) > 0 && locations.get(locationId).getAnimals().indexOf(this) < locations.get(locationId).getAnimals().size()) {
                    Animal clone = locations.get(locationId).getAnimals().get(locations.get(locationId).getAnimals().indexOf(this));
                    try {
                        if (direction == 0) {

                            int nLocationId = locationId - Integer.parseInt(Pandaria.getParameters()[0]);
                            if (nLocationId < 0) {
                                i--;
                                continue;
                            } else {
                                animals.remove(this);
                                List<Animal> animalsN = locations.get(nLocationId).getAnimals();
                                animalsN.add(clone);
                            }

                        }
                        if (direction == 2) {
                            int nLocationId = locationId + Integer.parseInt(Pandaria.getParameters()[0]);
                            if (nLocationId > Integer.parseInt(Pandaria.getParameters()[1]) * Integer.parseInt(Pandaria.getParameters()[0])) {
                                i--;
                                continue;
                            } else {
                                animals.remove(this);
                                List<Animal> animalsN = locations.get(nLocationId).getAnimals();
                                animalsN.add(clone);
                            }
                        }
                        if (direction == 1) {
                            int nLocationId = locationId - 1;
                            if ((nLocationId % Integer.parseInt(Pandaria.getParameters()[0])) == 0) {
                                i--;
                                continue;
                            } else {
                                animals.remove(this);
                                List<Animal> animalsN = locations.get(nLocationId).getAnimals();
                                animalsN.add(clone);
                            }
                        }
                        if (direction == 3) {
                            int nLocationId = locationId + 1;
                            if ((locationId % Integer.parseInt(Pandaria.getParameters()[0])) == 0) {
                                i--;
                                continue;
                            } else {
                                animals.remove(this);
                                List<Animal> animalsN = locations.get(nLocationId).getAnimals();
                                animalsN.add(clone);
                            }
                        }
                    } catch (RuntimeException excep) {

                    }
                }

        }
    }

    @Override
    public void Reproduction() {
        List<Location> locations = Pandaria.getLocations();
        List<Animal> animals = locations.get(locationId).getAnimals();
        for (int i = 0; i < animals.size(); i++) {
            if(animals.get(i) instanceof Rabbit && animals.get(i) != this){
                animals.add(new Rabbit(this.locationId));
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
            eat();
            move();
            Reproduction();
            aging();
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

    public double eateble(Predator predator, int posibility) {

        if (predator instanceof Wolf) {
            if (posibility < 60){
                Rabbit.count--;
                return getWeight();
            }

        }
        if (predator instanceof Fox) {
            if(posibility < 70) {
                Rabbit.count--;
                return getWeight();
            }
        }
        if (predator instanceof Lynx) {
            if(posibility < 80) {
                Rabbit.count--;
                return getWeight();
            }
        }
        if (predator instanceof Bear) {
            if(posibility < 80) {
                Rabbit.count--;
                return getWeight();
            }
        }
        if (predator instanceof Eagle) {
            if(posibility < 90) {
                Rabbit.count--;
                return getWeight();
            }
        }
        return 0;
    }
}
