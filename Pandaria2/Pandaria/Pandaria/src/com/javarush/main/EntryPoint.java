package com.javarush.main;

import com.javarush.app.Application;

import com.javarush.controller.MainController;
import com.javarush.island.Location;
import com.javarush.island.Pandaria;
import com.javarush.view.ConsoleView;
import com.javarush.view.View;

import java.util.List;
import java.util.concurrent.*;

public class EntryPoint {
    public static void main(String[] args) {

        View view = new ConsoleView();
        MainController mainController = new MainController(view);
        Application application = new Application(mainController);
        application.run();







    }
}