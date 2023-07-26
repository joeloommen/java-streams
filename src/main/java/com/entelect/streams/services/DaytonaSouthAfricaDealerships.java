package com.entelect.streams.services;

import com.entelect.streams.models.Car;
import com.entelect.streams.models.Colour;
import com.entelect.streams.utils.DaytonaStock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DaytonaSouthAfricaDealerships {

    private final List<Car> showroom;
    private final ValetService valetService;


    public DaytonaSouthAfricaDealerships(ValetService valetService) {
        this.valetService = valetService;

        showroom = DaytonaStock.populateShowroom();
    }


    List<Car> getCarsByColour(Colour colour) {
        return showroom.stream()
                .filter(car -> colour.equals(car.getColour()))
                .peek(car -> System.out.printf("%s %s (%s)%n", car.getMake(), car.getModelName(), car.getLocation()))
                .collect(Collectors.toList());
    }


// 1) Presentation Example -
    public void customizeLamborghiniStock() {

    }

// 2) Practical - Group Exercise
    public List<Car> consolidateHighValueRangeRoverStock() {
        List<Car> rangeRoverStock = new ArrayList<>();

//        TODO - Convert the array to a parallel stream and apply the appropriate methods to:
//               1) Filter for all Range Rovers over R3 million
//               2) Update the Location to JOHANNESBURG with a map function.
//               3) Use a map function to set the full wash of the vehicle and set
//               4) Collect the data in a new List.

        return rangeRoverStock;
    }

}
