package com.javarush.controller;

import com.javarush.view.View;

public class MainController {
    private View view;

    public MainController(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }
}
