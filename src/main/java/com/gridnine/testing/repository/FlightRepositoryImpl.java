package com.gridnine.testing.repository;

import com.gridnine.testing.model.Flight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightRepositoryImpl implements FlightRepository {
    private final Map<Long, Flight> flights = new HashMap<>();

    @Override
    public List<Flight> getFlights() {
        return new ArrayList<>(flights.values());
    }

    @Override
    public void save(Flight flight) {
        flights.put(getNextId(), flight);
    }

    private long getNextId() {
        long currentMaxId = flights.keySet()
                .stream()
                .mapToLong(id -> id)
                .max()
                .orElse(0);
        return ++currentMaxId;
    }
}