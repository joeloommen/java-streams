package com.entelect.streams.services;

import com.entelect.streams.models.Car;
import com.entelect.streams.models.Colour;
import com.entelect.streams.models.Location;
import com.entelect.streams.models.Make;
import com.entelect.streams.utils.DaytonaStock;
import org.springframework.stereotype.Service;

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
        return showroom
                .parallelStream()
                .filter(car -> car.getMake().equals(Make.RANGE_ROVER))
                .peek(car -> car.setLocation(Location.JOHANNESBURG))
                .peek(valetService::performFullWash).collect(Collectors.toList());
    }

}
