package com.igate.labs;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CarStreamSolutions {

    static List<Car> cars = CarRepository.getCars();
    static List<Owner> owners = CarRepository.getOwners();

    // 1. List names of owners currently having no cars
    public static void ownersWithNoCars() {

        List<String> result = owners.stream()
                .filter(o -> o.getCars() == null || o.getCars().isEmpty())
                .map(Owner::getName)
                .collect(Collectors.toList());

        System.out.println("Owners having no cars:" + result);
    }

    // 2. Map of owner name and number of cars owned

    public static void ownerCarCountMap() {

        Map<String, Integer> map = owners.stream()
                .collect(Collectors.toMap(
                        Owner::getName,
                        o -> o.getCars() == null ? 0 : o.getCars().size()
                ));

        System.out.println("Owner -> Car Count Map:");
        map.forEach((name, count) ->
                System.out.println(name + " -> " + count));
    }

    // 3. List cars not owned by anyone
    public static void carsWithNoOwner() {

        List<Car> ownedCars = owners.stream()
                .filter(o -> o.getCars() != null)
                .flatMap(o -> o.getCars().stream())
                .collect(Collectors.toList());

        List<Car> result = cars.stream()
                .filter(car -> !ownedCars.contains(car))
                .collect(Collectors.toList());

        System.out.println("Cars not owned by anyone:");
        result.forEach(System.out::println);
    }
}

