package com.gridnine.testing.repository;

import com.gridnine.testing.model.Flight;

import java.util.List;

public interface FlightRepository {
    List<Flight> getFlights();

    void save(Flight flight);
}