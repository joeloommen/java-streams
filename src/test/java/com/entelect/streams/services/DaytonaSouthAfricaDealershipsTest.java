package com.entelect.streams.services;

import com.entelect.streams.models.Car;
import com.entelect.streams.models.Colour;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class DaytonaSouthAfricaDealershipsTest {

    @Mock
    ValetService valetService;

    @InjectMocks
    DaytonaSouthAfricaDealerships daytonaSouthAfricaDealerships;

    @Test
    void getCarsByRedColour() {
        List<Car> redCarStock = daytonaSouthAfricaDealerships.getCarsByColour(Colour.RED);

        assertEquals(redCarStock.getClass(), ArrayList.class);
        redCarStock.forEach(car -> assertEquals(Colour.RED, car.getColour()));
    }

    @Test
    void consolidateHighValueRangeRoverStock() {
    }
}