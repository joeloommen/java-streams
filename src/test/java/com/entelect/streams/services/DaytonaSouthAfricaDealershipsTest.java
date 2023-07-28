package com.entelect.streams.services;

import com.entelect.streams.models.Car;
import com.entelect.streams.models.Colour;
import com.entelect.streams.models.Location;
import com.entelect.streams.models.Make;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

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
    void givenListOfCars_whenConsolidateHighValueRangeRoverStock_thenCorrectListReturned() {
        // Given
        when(valetService.performFullWash(any())).thenReturn(any());

        // When
        List<Car> cars = daytonaSouthAfricaDealerships.consolidateHighValueRangeRoverStock();

        // Then
        for (Car car : cars) {
            assertEquals(car.getMake(), Make.RANGE_ROVER);
            assertEquals(car.getLocation(), Location.JOHANNESBURG);
            verify(valetService, times(1)).performFullWash(car);
        }
    }
}