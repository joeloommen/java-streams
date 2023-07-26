package com.entelect.streams.services;

import com.entelect.streams.models.Car;
import org.springframework.stereotype.Service;

@Service
public class ValetService {

    public Car performFullWash(Car car) {
        car.setIsValeted(true);
        return car;
    }
}
