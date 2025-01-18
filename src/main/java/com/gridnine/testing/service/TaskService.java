package com.gridnine.testing.service;

import com.gridnine.testing.file.FlightFile;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

public class TaskService {
    private final FlightFile flightFile;

    public TaskService(FlightFile flightFile) {
        this.flightFile = flightFile;
    }

    public void lesson1() {
        System.out.println("1.\tВылет до текущего момента времени");

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime dateTime = LocalDateTime.now();
        String time = dateTime.format(fmt);
        System.out.println("Текущее время: " + time);

        for (Flight flight : flightFile.getFlights()) {
            for (Segment segment : flight.getSegments()) {
                if (dateTime.isBefore(segment.getDepartureDate())) {
                    System.out.print("\t" + segment);
                } else {
                    System.out.print(" Условие не выполнено. ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void lesson2() {
        System.out.println("2.\tИмеются сегменты с датой прилёта раньше даты вылета");

        for (Flight flight : flightFile.getFlights()) {
            for (Segment segment : flight.getSegments()) {
                if (segment.getDepartureDate().isAfter(segment.getArrivalDate())) {
                    System.out.print("\t" + segment);
                } else {
                    System.out.print(" Условие не выполнено. ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void lesson3() {
        System.out.println("3.\tОбщее время, проведённое на земле превышает два часа (время на земле — это интервал\n" +
                "\tмежду прилётом одного сегмента и вылетом следующего за ним)");

        for (Flight flight : flightFile.getFlights()) {
            for (Segment segment : flight.getSegments()) {
                long a1 =  segment.getDepartureDate().getHour();
                long a2 = segment.getArrivalDate().getHour();
                System.out.print("Вылет часов:" + a1 + " Прилёт часов:" + a2 + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}