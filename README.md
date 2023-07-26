# Java Streams

---

## Project
This project contains the majority of the business logic in the `DaytonaSouthAfricaDealerships` file, with its associated 
test file (`DaytonaSouthAfricaDealershipsTest`) calling the business logic.

---

## Group Practical
>Range Rover have just released their new Range Rover Entelar in July 2023.
> 
>In anticipation of potential customers coming to Johannesburg to view the new model, Daytona South Africa have decided 
to move all their Range Rover models to the Johannesburg dealership. 

### Your task:
A skeleton method called `consolidateHighValueRangeRoverStock` has been created in the `DaytonaSouthAfricaDealerships` 
file. This method has a new list of Range Rovers called `rangeRoverStock`. 

You are required to update the logic in this method to achieve the following:

#### 1) Requirements
* Create a Parallel Stream of the `showroom` list of Cars (has already been defined at the top of the file).
* Filter for `RANGE_ROVER`.
* Use the map function to update the location to `JOHANNESBURG`.
* Use the map function to call the `ValetService.performFullWash`.
* Use Collect to collect these vehicles in a new List and assign this to `rangeRoverStock`.
* Return `rangeRoverStock`

#### 2) Outputs
* `rangeRoverStock` must contain a new list of Cars with:
  * Make: `RANGE_ROVER` 
  * Location: `JOHANNESBURG`
  * isValeted: `TRUE`

#### 3) Unit Tests
* Write unit tests to ensure that the returned `rangeRoverStock` contains Cars with:
  * Make: `RANGE_ROVER`
  * Location: `JOHANNESBURG`
  * isValeted: `TRUE`

#### 4) NOTE
For the purpose of the practical, the `showroom` member variable is declared FINAL and STATIC - 
the expectation is to create a new list of cars.
