package com;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class PointOfInterestService {
    
    private List<PointOfInterest> pointOfInterests;

    public PointOfInterestService() {
        this.pointOfInterests = Arrays.asList(
                new PointOfInterest(1, "Dracula Castle         ", "Brasov, Romania   ", PointOfInterestType.Castle),
                new PointOfInterest(2, "Peles Castle           ", "Cluj, Romania     ", PointOfInterestType.Castle),
                new PointOfInterest(3, "Corvin Castle          ", "Hunedoara, Romania ", PointOfInterestType.Castle),
                new PointOfInterest(4, "Biertan Fortified Church", "Sibiu, Romania    ", PointOfInterestType.Church),
                new PointOfInterest(5, "Stavropoleos Church     ", "Bucharest, Romania", PointOfInterestType.Church),
                new PointOfInterest(6, "Merry Cemetery           ", "Maramures, Romania", PointOfInterestType.Monument),
                new PointOfInterest(7, "Palace of the Parliament ", "Bucharest, Romania", PointOfInterestType.Monument),
                new PointOfInterest(8, "Sibiu Lutheran Cathedral ", "Sibiu, Romania     ", PointOfInterestType.Church),
                new PointOfInterest(9, "National College CN      ", "Sibiu, Romania     ", PointOfInterestType.School),
                new PointOfInterest(10, "St Ecaterina College     ", "Bucharest, Romania ", PointOfInterestType.School)
        );
    }

    
    public List<PointOfInterest> seacrhByType(PointOfInterestType type){
        return this.pointOfInterests.stream().filter(i -> i.getType().equals(type)).collect(Collectors.toList());
    }

    public List<PointOfInterest> searchByLocation(String location){
        return this.pointOfInterests.stream().filter(i -> i.getLocation().contains(location)).collect(Collectors.toList());
    }
    
    public PointOfInterest findById(int id) {
        return this.pointOfInterests.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
    }

    
}
