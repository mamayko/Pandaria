package com.javarush.view;

import com.javarush.island.Location;

import java.util.Scanner;

import static com.javarush.constants.ApplicationCompetitionConstants.*;

public class ConsoleView implements View {
    @Override
    public String[] getParameters() {
        // TODO finish method
        // parameter 0 & 1 = island size;
        // parameter 2 = розмір дня в секундах
        //param 3 = обєм рослин в клітинці
        //парам 4 = 1 - повільно  10- швидко
        //швидкість росту рослин (у відсотковому співвідношені)
        String[] parameters = new String[5];
        Scanner scanner = new Scanner(System.in);
        System.out.println(HELLO);
        System.out.println(SIZE);
        parameters[0] = scanner.nextLine();
        parameters[1] = scanner.nextLine();
        parameters[2] = "0";
        parameters[3] = "50.0";
        parameters[4] = "10";
        System.out.println(SUCCESS + parameters[0] + "*" + parameters[1]);

        return parameters;

    }
}
