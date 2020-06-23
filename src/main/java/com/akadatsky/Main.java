package com.akadatsky;

import com.akadatsky.design.ConnectedFour;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Game start: ");

        ConnectedFour engine = new ConnectedFour(8);
        engine.move(1);
        engine.move(2);
        engine.move(1);
        engine.move(2);
        engine.move(1);
        engine.move(2);
        engine.move(1);
        engine.move(2);
    }

}
