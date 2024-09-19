package com.javarush.animals;

import com.javarush.island.Location;
import com.javarush.island.Pandaria;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.javarush.constants.ApplicationCompetitionConstants.PLANTSINFOMESSAGE;

public class Plants implements Runnable{
    private volatile double plantsVolume;
    private static int speedPlantsVolume;
    private static double allVolumePlants;


    public Plants() {

    }

    public Plants(double plantsVolume, int speedPlants) {
        this.plantsVolume = plantsVolume;
        this.speedPlantsVolume = speedPlants;
        allVolumePlants += this.plantsVolume;
    }

    public void setPlantsVolume(double plantsVolume) {
        this.plantsVolume = speedPlantsVolume + plantsVolume;

        if(this.plantsVolume > 100.0)
            this.plantsVolume = 100.0;
        if(this.plantsVolume < 0.0)
            this.plantsVolume = 0.0;

    }

    public double getPlantsVolume() {
        return plantsVolume;
    }

    @Override
    public void run() {

        setPlantsVolume(plantsVolume);

        setAllVolumePlants();




    }

    public static double getAllVolumePlants() {
        return allVolumePlants;
    }

    public static void setAllVolumePlants() {
        List<Location> locations = Pandaria.getLocations();
        double allPlantsVolume = 0;
        for (int i = 0; i < locations.size(); i++) {
            allPlantsVolume += locations.get(i).getPlant().getPlantsVolume();

        }
        Plants.allVolumePlants = allPlantsVolume / locations.size();

    }
}
