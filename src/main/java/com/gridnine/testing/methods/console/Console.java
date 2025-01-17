package com.gridnine.testing.methods.console;

import java.util.Scanner;

public class Console {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getInteger() {
        int a;
        while (true) {
            if (scanner.hasNextInt()) {
                a = scanner.nextInt();
                break;
            } else {
                scanner.nextLine();
            }
        }
        return a;
    }
}