package com.gridnine.testing.service;

import com.gridnine.testing.file.FlightFile;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.gridnine.testing.methods.console.Console.getInteger;

public class FlightService {
    private final FlightFile flightFile;

    public FlightService(FlightFile flightFile) {
        this.flightFile = flightFile;
    }

    public void create() {
        int countBoarding;
        int count = 0;
        long day;
        long hours;
        List<Segment> segs = new ArrayList<>();
        System.out.println("Введите количество посадок за перелёт, учитывая пересадки: (от 1 до n-пересадок)");
        countBoarding = getInteger();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime dateTime = LocalDateTime.now();
        String time = dateTime.format(fmt);
        while (true) {
            System.out.println("\nТекущее время: " + time);
            System.out.println("\nВведите день посадки от текущего времени:");
            System.out.println("Пример: вчера -1 / сегодня 0 / завтра 1");
            day = getInteger();
            System.out.println("Введите час посадки от текущего времени:");
            System.out.println("Пример: час назад -1 / в этот час 0 / через час 1");
            hours = getInteger();
            LocalDateTime dateTime1 = hours(days(dateTime, day), hours);
            System.out.println("\nВведите день прилёта от текущего времени:");
            System.out.println("Пример: вчера -1 / сегодня 0 / завтра 1");
            day = getInteger();
            System.out.println("Введите час прилёта от текущего времени:");
            System.out.println("Пример: час назад -1 / в этот час 0 / через час 1");
            hours = getInteger();
            LocalDateTime dateTime2 = hours(days(dateTime, day), hours);
            segs.add(new Segment(dateTime1, dateTime2));
            count++;
            System.out.println("записано count" + count);
            if (count == countBoarding) {
                break;
            }
        }
        flightFile.save(new Flight(segs));
    }

    public void show() {
        for (Flight flight : flightFile.getFlights()) {
            System.out.println(flight);
        }
    }

    private LocalDateTime days(LocalDateTime dateTime, long day) {
        LocalDateTime dateTime2;
        if (day == 0) {
            dateTime2 = dateTime;
        } else if (day > 0) {
            dateTime2 = dateTime.plusDays(day);
        } else {
            dateTime2 = dateTime.minusDays(Math.abs(day));
        }
        return dateTime2;
    }

    private LocalDateTime hours(LocalDateTime dateTime, long hours) {
        LocalDateTime dateTime2;
        if (hours == 0) {
            dateTime2 = dateTime;
        } else if (hours > 0) {
            dateTime2 = dateTime.plusHours(hours);
        } else {
            dateTime2 = dateTime.minusHours(Math.abs(hours));
        }
        return dateTime2;
    }
}