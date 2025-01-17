package com.gridnine.testing.controiller;

import com.gridnine.testing.file.FlightFile;
import com.gridnine.testing.service.FlightService;
import com.gridnine.testing.service.TaskService;

public class FlightController {
    private final static String file = "src\\main\\java\\com\\gridnine\\testing\\file\\FlightFile.txt";
    private static final FlightFile flightFile = FlightFile.loadFromFile(file);

    public static FlightService flightService() {
        return new FlightService(flightFile);
    }

    public static TaskService taskService() {
        return new TaskService(flightFile);
    }
}