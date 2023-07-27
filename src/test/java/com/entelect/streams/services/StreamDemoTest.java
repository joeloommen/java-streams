package com.entelect.streams.services;

import com.entelect.streams.models.Car;
import com.entelect.streams.models.Colour;
import com.entelect.streams.utils.DaytonaStock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class StreamDemoTest {

    @InjectMocks
    private StreamDemo streamDemo;

    @Test
    public void createSequentialStreams() {
        streamDemo.sequentialStream();
    }
    @Test
    public void createParallelStreams() {
        streamDemo.parallelStreams();
    }

    @Test
    public void filterCarsByColourShouldLogANewListOfColourCars() {
        for (Colour colour: Colour.values()) {
            streamDemo.filterCarsByColour(colour);
        }
    }

    @Test
    public void modifyRangeRoverCarsShouldUpgradeEngine() {
        int numberOfCylinders = 6;
        List<Car> expectedModifiedRangeRovers = streamDemo.modifyRangeRoverCars(numberOfCylinders);

        assertEquals(ArrayList.class, expectedModifiedRangeRovers.getClass());
        expectedModifiedRangeRovers.forEach(car -> assertEquals(numberOfCylinders, car.getCylinders()));
    }

    @Test
    public void customizeLamborghiniStockShouldChangeColour() {
        System.out.printf("--------------%nOriginal Colours%n--------------%n");
        DaytonaStock.populateLamborghini().forEach(car -> System.out.printf("%s %s (%s)%n", car.getMake(), car.getModelName(), car.getColour()) );

        System.out.printf("%n--------------%nResprayed Colours%n--------------%n");
        streamDemo.customizeLamborghiniStock(Colour.BLACK);
    }
}