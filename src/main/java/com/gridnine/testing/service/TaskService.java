package com.gridnine.testing.service;

import com.gridnine.testing.file.FlightFile;

public class TaskService {
    private final FlightFile flightFile;

    public TaskService(FlightFile flightFile) {
        this.flightFile = flightFile;
    }

    public void lesson1() {
        System.out.println("1.\tВылет до текущего момента времени");
    }

    public void lesson2() {
        System.out.println("2.\tИмеются сегменты с датой прилёта раньше даты вылета");
    }

    public void lesson3() {
        System.out.println("3.\tОбщее время, проведённое на земле превышает два часа (время на земле — это интервал\n" +
                "\tмежду прилётом одного сегмента и вылетом следующего за ним)");
    }
}
