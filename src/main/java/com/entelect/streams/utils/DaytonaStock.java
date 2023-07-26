package com.entelect.streams.utils;

import com.entelect.streams.models.Car;
import com.entelect.streams.models.Colour;
import com.entelect.streams.models.Location;
import com.entelect.streams.models.Make;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public final class DaytonaStock {

    public static int totalAstonMartins;
    public static int totalBentley;
    public static int totalFerrari;
    public static int totalLamborghini;
    public static int totalRangeRover;
    public static int totalRollsRoyce;
    public static int totalDaytonaStock;

    public static List<Car> populateAstonMartin() {
        Car am1 = Car.builder()
                .make(Make.ASTON_MARTIN)
                .colour(Colour.WHITE)
                .modelName("DB11")
                .cylinders(8)
                .location(Location.JOHANNESBURG)
                .build();

        Car am2 = Car.builder()
                .make(Make.ASTON_MARTIN)
                .colour(Colour.RED)
                .modelName("DB12")
                .cylinders(8)
                .location(Location.CAPE_TOWN)
                .build();

        Car am3 = Car.builder()
                .make(Make.ASTON_MARTIN)
                .colour(Colour.ORANGE)
                .modelName("DBX")
                .cylinders(8)
                .location(Location.DURBAN)
                .build();

        totalAstonMartins = 3;
        return List.of(am1, am2, am3);
    }

    public static List<Car> populateBentley() {
        Car bentley1 = Car.builder()
                .make(Make.BENTLEY)
                .colour(Colour.BLACK)
                .modelName("Continental GT")
                .cylinders(8)
                .location(Location.DURBAN)
                .build();

        Car bentley2 = Car.builder()
                .make(Make.BENTLEY)
                .colour(Colour.SILVER)
                .modelName("Continental GTC")
                .cylinders(12)
                .location(Location.JOHANNESBURG)
                .build();

        totalBentley = 2;
        return List.of(bentley1, bentley2);
    }
    public static List<Car> populateFerrari() {
        Car ferrari1 = Car.builder()
                .make(Make.FERRARI)
                .colour(Colour.RED)
                .modelName("488")
                .cylinders(12)
                .location(Location.CAPE_TOWN)
                .build();

        totalFerrari = 1;
        return List.of(ferrari1);
    }
    public static List<Car> populateLamborghini() {
        Car lambo1 = Car.builder()
                .make(Make.LAMBORGHINI)
                .colour(Colour.BLACK)
                .modelName("Huracan")
                .cylinders(10)
                .location(Location.JOHANNESBURG)
                .build();

        Car lambo2 = Car.builder()
                .make(Make.LAMBORGHINI)
                .colour(Colour.BLUE)
                .modelName("Revuelto")
                .cylinders(12)
                .location(Location.CAPE_TOWN)
                .build();

        Car lambo3 = Car.builder()
                .make(Make.LAMBORGHINI)
                .colour(Colour.YELLOW)
                .modelName("Urus")
                .cylinders(8)
                .location(Location.JOHANNESBURG)
                .build();

        Car lambo4 = Car.builder()
                .make(Make.LAMBORGHINI)
                .colour(Colour.GREEN)
                .modelName("Huracan STO")
                .cylinders(10)
                .location(Location.DURBAN)
                .build();

        totalLamborghini = 4;
        return List.of(lambo1, lambo2, lambo3, lambo4);
    }
    public static List<Car> populateRangeRover() {
        Car rr1 = Car.builder()
                .make(Make.RANGE_ROVER)
                .colour(Colour.SILVER)
                .modelName("Sport")
                .cylinders(8)
                .location(Location.JOHANNESBURG)
                .build();

        Car rr2 = Car.builder()
                .make(Make.RANGE_ROVER)
                .colour(Colour.BLACK)
                .modelName("Autobiography")
                .cylinders(8)
                .location(Location.CAPE_TOWN)
                .build();

        Car rr3 = Car.builder()
                .make(Make.RANGE_ROVER)
                .colour(Colour.WHITE)
                .modelName("Autobiography")
                .cylinders(6)
                .location(Location.CAPE_TOWN)
                .build();

        Car rr4 = Car.builder()
                .make(Make.RANGE_ROVER)
                .colour(Colour.BLACK)
                .modelName("Velar")
                .cylinders(4)
                .location(Location.JOHANNESBURG)
                .build();

        Car rr5 = Car.builder()
                .make(Make.RANGE_ROVER)
                .colour(Colour.WHITE)
                .modelName("Velar")
                .cylinders(4)
                .location(Location.DURBAN)
                .build();

        Car rr6 = Car.builder()
                .make(Make.RANGE_ROVER)
                .colour(Colour.WHITE)
                .modelName("Velar")
                .cylinders(6)
                .location(Location.CAPE_TOWN)
                .build();

        totalRangeRover = 6;
        return List.of(rr1, rr2, rr3, rr4, rr5, rr6);
    }
    public static List<Car> populateRollsRoyce() {
        Car rolls1 = Car.builder()
                .make(Make.ROLLS_ROYCE)
                .colour(Colour.BLACK)
                .modelName("Ghost")
                .cylinders(12)
                .location(Location.CAPE_TOWN)
                .build();

        Car rolls2 = Car.builder()
                .make(Make.ROLLS_ROYCE)
                .colour(Colour.WHITE)
                .modelName("Ghost")
                .cylinders(12)
                .location(Location.JOHANNESBURG)
                .build();

        Car rolls3 = Car.builder()
                .make(Make.ROLLS_ROYCE)
                .colour(Colour.BLACK)
                .modelName("Phantom")
                .cylinders(12)
                .location(Location.JOHANNESBURG)
                .build();

        totalRollsRoyce = 3;
        return List.of(rolls1, rolls2, rolls3);
    }
    public static List<Car> populateShowroom() {
        List<Car> showroom = new ArrayList<>();

        showroom.addAll(populateAstonMartin());
        showroom.addAll(populateBentley());
        showroom.addAll(populateFerrari());
        showroom.addAll(populateLamborghini());
        showroom.addAll(populateRangeRover());
        showroom.addAll(populateRollsRoyce());

        totalDaytonaStock = showroom.size();
        return showroom;
    }
}
