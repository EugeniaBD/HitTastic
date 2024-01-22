package com;

public enum PointOfInterestType {
    School("School"),
    Hospital("Hospital"),
    Restaurant("Restuarant"),
    Church("Church"),
    Monument("Monument"),
    Castle("Castle"),
    Coffee_Shop("Coffee_Shop"),
    Recreation("Recreation"),
    Hotel("Hotel");
    
    private final String title;

    

    //PointOfInterestType(String title) { this.title = title; }: 
//This is a constructor for the enum. When you declare an enum constant like School("School"), it calls this constructor with the specified title (e.g., "School") and assigns it to the title variable.
    PointOfInterestType(String title) {
        this.title = title;
    }
}
