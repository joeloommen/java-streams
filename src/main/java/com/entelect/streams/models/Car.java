package com.entelect.streams.models;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Car {
    Make make;
    Colour colour;
    String modelName;
    int cylinders;
    Location location;
    Boolean isValeted;
}
