package com.entelect.streams.services;

import com.entelect.streams.models.Car;
import com.entelect.streams.models.Colour;
import com.entelect.streams.models.Make;
import com.entelect.streams.utils.DaytonaStock;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StreamDemo {

    private final List<Car> demoShowroom = DaytonaStock.populateShowroom();

    // 1) CREATION (Sequential and Parallel)
    public void sequentialStream() {
        System.out.printf("------------------%nSequential Streams%n------------------%n");

        Stream<Car> sequentialStreamApi = Stream.of(Car.builder()
                .make(Make.FERRARI)
                .build());

        Stream<Car> sequentialStreamCollectionInterface = DaytonaStock.populateFerrari()
                .stream();

        sequentialStreamApi.forEach(car -> System.out.printf("Stream API: %s%n", car.getMake()));
        sequentialStreamCollectionInterface.forEach(car -> System.out.printf("Collection Interface: %s%n", car.getMake()));

    }
    public void parallelStreams() {
        System.out.printf("------------------%nParallel Streams%n------------------%n");
        Car car1 = Car.builder()
                .make(Make.ASTON_MARTIN)
                .modelName("1")
                .build();

        Car car2 = Car.builder()
                .make(Make.ASTON_MARTIN)
                .modelName("2")
                .build();

        Car car3 = Car.builder()
                .make(Make.ASTON_MARTIN)
                .modelName("3")
                .build();

        System.out.printf("%n1) Stream API%n%n");
        Stream.of(car1, car2, car3).parallel()
                        .forEach(car -> System.out.printf("%s %s --> %s%n", car.getMake(), car.getModelName(), Thread.currentThread().getName()));


        System.out.printf("%n2) Collection Interface%n%n");
        demoShowroom.parallelStream()
                .forEach(car -> System.out.printf("%s %s (%s) --> %s%n", car.getMake(), car.getModelName(), car.getLocation(),Thread.currentThread().getName()));
    }


    // 2) OPERATIONS
    public void filterCarsByColour(Colour colour) {
        System.out.printf("-------%n%s%n-------%n", colour.name());
        demoShowroom.stream()
                .filter(car -> colour.equals(car.getColour()))
                .forEach(colourCar -> System.out.printf("%s %s (%s)%n", colourCar.getMake(), colourCar.getModelName(), colourCar.getLocation()));

        System.out.printf("%n");
    }

    public List<Car> modifyRangeRoverCars(int numberOfCylinders) {
        return DaytonaStock.populateRangeRover().stream()
                .filter(car -> car.getCylinders() == 4)
                .map(car -> upgradeEngine(car, numberOfCylinders))
                .collect(Collectors.toList());
    }

    private Car upgradeEngine(Car car, int numberOfCylinders) {
        car.setCylinders(numberOfCylinders);
        return car;
    }


    // 3) Presentation Example
    public void customizeLamborghiniStock(Colour colour) {
        demoShowroom.stream()
                .filter(car -> (Make.LAMBORGHINI).equals(car.getMake()))
                .map(car -> resprayBodyColour(car, colour))
                .forEach(colourCar ->System.out.printf("%s %s (%s)%n", colourCar.getMake(), colourCar.getModelName(), colourCar.getColour()));
    }

    private Car resprayBodyColour(Car car, Colour colour) {
        car.setColour(colour);

        return car;
    }
}
