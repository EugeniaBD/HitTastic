package com;

import java.util.ArrayList;
import java.util.List;

public class PointOfInterest {
    private int id;
    private String name;
    private String location;
    private PointOfInterestType type;
    private List<Comment> comments;
    private int likes;

    public PointOfInterest(int id, String name, String location, PointOfInterestType type, List<Comment> comments, int likes) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.type = type;
        this.comments = comments;
        this.likes = likes;
    }

    public PointOfInterest(int id, String name, String location, PointOfInterestType type) {
        this(id, name, location, type, new ArrayList<Comment>(), new Double(Math.random()).intValue());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public PointOfInterestType getType() {
        return type;
    }

    public void setType(PointOfInterestType type) {
        this.type = type;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public int getLikes() {
        return likes;
    }

    public void increaseLikes() {
        this.likes++;
    }
    
    
    
    
}
