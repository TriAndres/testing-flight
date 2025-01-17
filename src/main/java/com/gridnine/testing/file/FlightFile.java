package com.gridnine.testing.file;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.repository.FlightRepositoryImpl;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightFile extends FlightRepositoryImpl {
    private final String file;

    public FlightFile(String file) {
        this.file = file;
    }

    public void saveF() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            int count = 0;
            for (Flight flight : getFlights()) {
                for (Segment segment : flight.getSegments()) {
                    writer.write(segment.getDepartureDate() + "/" + segment.getArrivalDate());
                    count++;
                    if (count == flight.getSegments().size()) {
                        writer.write("\n");
                        count = 0;
                    } else {
                        writer.write("/");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Flight> getFlights() {
        return super.getFlights();
    }

    @Override
    public void save(Flight flight) {
        super.save(flight);
        saveF();
    }

    public static FlightFile loadFromFile(String file) {
        FlightFile flightFile = new FlightFile(file);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split("/");
                List<Segment> segs = new ArrayList<>(row.length / 2);
                for (int i = 0; i < row.length - 1; i += 2) {
                    segs.add(new Segment(LocalDateTime.parse(row[i]), LocalDateTime.parse(row[i + 1])));
                }
                flightFile.save(new Flight(segs));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return flightFile;
    }
}