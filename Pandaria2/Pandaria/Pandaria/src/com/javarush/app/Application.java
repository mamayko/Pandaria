package com.javarush.app;

import com.javarush.controller.MainController;
import com.javarush.island.Pandaria;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Application {
    private final MainController mainController;

    public Application(MainController mainController) {
        this.mainController = mainController;
    }
    public void run() {
        String[] parameters = mainController.getView().getParameters();

        Pandaria pandaria = new Pandaria(parameters);
        pandaria.create();

        ScheduledExecutorService mainExecutor = Executors.newScheduledThreadPool(1);
        mainExecutor.scheduleAtFixedRate(pandaria, 0,5, TimeUnit.SECONDS);
    }
}
