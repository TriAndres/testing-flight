package com.gridnine.testing;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.LocalDateTime;
import java.util.List;

import static com.gridnine.testing.testing.FlightBuilder.createFlight;
import static com.gridnine.testing.testing.FlightBuilder.createFlights;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите дату вылета:");
        LocalDateTime time1 = LocalDateTime.now().minusDays(5);
        System.out.println("Введите дату прилёта:");
        LocalDateTime time2 = LocalDateTime.now().plusDays(5);
        Segment segment1 = new Segment(time1, time2);
        Flight flight = new Flight(List.of(segment1));
        System.out.println(flight);

        for (Segment segment : flight.getSegments()) {
            createFlight(segment.getArrivalDate(),segment.getArrivalDate());
            System.out.println(createFlights());
        }
    }
}
