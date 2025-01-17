package com.gridnine.testing.service;

import com.gridnine.testing.file.FlightFile;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private final FlightFile flightFile;

    public TaskService(FlightFile flightFile) {
        this.flightFile = flightFile;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void lesson1() {
        System.out.println("1.\tВылет до текущего момента времени");
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime dateTime = LocalDateTime.now();
        String time = dateTime.format(fmt);
        System.out.println("Текущее время: " + time);
        for (Flight flight : flightFile.getFlights()) {
            for (Segment segment : flight.getSegments()) {
                if (sorted(dateTime,segment)) {
                    System.out.print("\t" + segment);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private boolean sorted(LocalDateTime dateTime,Segment segment) {
        return dateTime.isBefore(segment.getDepartureDate());
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void lesson2() {
        System.out.println("2.\tИмеются сегменты с датой прилёта раньше даты вылета");
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void lesson3() {
        System.out.println("3.\tОбщее время, проведённое на земле превышает два часа (время на земле — это интервал\n" +
                "\tмежду прилётом одного сегмента и вылетом следующего за ним)");
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
}