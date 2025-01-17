package com.gridnine.testing;

import static com.gridnine.testing.controiller.FlightController.flightService;
import static com.gridnine.testing.controiller.FlightController.taskService;
import static com.gridnine.testing.methods.console.Console.getInteger;

public class Main {
    public static void main(String[] args) {
        new Main().game();
    }

    public void game() {
        int num;
        do {
            num = menu();
            select(num);
        } while (num != 0);
    }

    private void select(int num) {
        switch (num) {
            case 1:
                flightService().create();
                System.out.println("Записано.");
                break;
            case 2:
                flightService().show();
                System.out.println("Вывод списка.");
                break;
            case 3:
                taskService().lesson1();
                System.out.println("Вывод задачи 1.");
                break;
            case 4:
                taskService().lesson2();
                System.out.println("Вывод задачи 2.");
                break;
            case 5:
                taskService().lesson3();
                System.out.println("Вывод задачи 3.");
                break;
            default:
                if (num == 0) {
                    System.out.println("Выход из программы.");
                } else {
                    System.out.println("Выбирите действия из меню.");
                }
                break;
        }
    }

    private int menu() {
        System.out.println("\n\tВыбирите действие:" +
                "\n\t1 - записать полёт." +
                "\n\t2 - вывести список." +
                "\n\t3 - задачаN1." +
                "\n\t4 - задачаN2." +
                "\n\t5 - задачаN3." +
                "\n\t0 - выйти из программы.");
        return getInteger();
    }

}