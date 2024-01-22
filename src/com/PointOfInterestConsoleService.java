package com;

import java.util.List;
import java.util.Scanner;

public class PointOfInterestConsoleService {
    private Scanner scanner;
    private PointOfInterestService pointOfInterestService;

    public PointOfInterestConsoleService(Scanner scanner, PointOfInterestService pointOfInterestService) {
        this.scanner = scanner;
        this.pointOfInterestService = pointOfInterestService;
    }

    PointOfInterestConsoleService(Scanner scanner) {
        this(scanner, new PointOfInterestService());
    }

    
    public void searchByType(){
        while(true){
            System.out.println("Select Point of Interest Type");
            final PointOfInterestType[] values = PointOfInterestType.values();
            final int length = values.length;
            System.out.println("0. Exit");
            for (int i = 0; i < length; i++) {
                System.out.println(String.format("%d. %s", i+1, values[i]));
            }
            try {
                int option = scanner.nextInt();
                if(option == 0 || option > length){
                    break;
                }

                PointOfInterestType type = values[option-1];
                List<PointOfInterest> pointOfInterests = pointOfInterestService.seacrhByType(type);
                iteratePointOfInterests(pointOfInterests);                
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
            
        }
    }

    public void searchByLocation() {
        while(true){
            System.out.println("Enter the location to search or type 'exit' to exit");
            String searchLocation = scanner.nextLine();            
            if(searchLocation.equals("exit")){
                break;
            }            
            List<PointOfInterest> pointOfInterests = pointOfInterestService.searchByLocation(searchLocation);
            if(pointOfInterests.isEmpty()){
                System.out.println("Not Point of interest found, try again");
            } else {
                iteratePointOfInterests(pointOfInterests);
            }
        }
    }

    private int iteratePointOfInterests(List<PointOfInterest> pointOfInterests) {
        System.out.println("ID\t Name\t\t\t\t\t Type\t\t\t Comments\t Likes\t Location");
        for (int i = 0; i < pointOfInterests.size(); i++) {
            PointOfInterest poi = pointOfInterests.get(i);
            System.out.println(String.format(
                    "%d\t %s\t\t %s\t\t\t %d\t\t %d\t %s", 
                    poi.getId(), 
                    poi.getName(), 
                    poi.getType(), 
                    poi.getComments().size(), 
                    poi.getLikes(),
                    poi.getLocation()
            ));
        }
        System.out.println("Select Id of Point of Interest to add/update the comment or like, or enter 0 to exit");
        try {
            int option = scanner.nextInt();
            if(option < 1) {
                return -1;
            }
            
            findById(option);
            
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    private int findById(int id) {
        PointOfInterest poi = pointOfInterestService.findById(id);
        if(poi == null){
            System.out.println("No Record found");
            return 1;
        }
        showPointOfInterest(poi);
        showComments(poi);        
        mainloop:
        while(true){
            System.out.println("0. Exit");
            System.out.println("1. Add the comment");
            System.out.println("2. Update the comment");
            System.out.println("3. Like the Point of Interest");
            try {
                int option = scanner.nextInt();
                scanner.nextLine();
                switch(option){
                    case 1:
                        addComment(poi);
                        showComments(poi);
                        break;
                    case 2:
                        updateComment(poi);
                        showComments(poi);
                        break;
                    case 3:
                        likePointOfInterest(poi);
                        showPointOfInterest(poi);
                        break;
                    default:
                        break mainloop;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }            
        }
        return 0;
    }

    private void addComment(PointOfInterest poi) {
        System.out.print("Enter your comment: ");
        String comment = scanner.nextLine();
        int id = poi.getComments().stream().map(Comment::getId).max(Integer::compare).orElse(0);
        poi.getComments().add(new Comment(++id, "default user", comment));
        System.out.println("commment added");
    }

    private void updateComment(PointOfInterest poi) {
        if (poi.getComments().isEmpty()) {
            System.out.println("No comments available. Please add a comment before updating.");
            return;
        }

        Comment comment = null;
        while (comment == null) {
            System.out.print("Select the comment id to update: ");
            int id = scanner.nextInt();
            scanner.nextLine();  // consume the newline character

            comment = poi.getComments().stream()
                    .filter(c -> c.getId() == id)
                    .findFirst()
                    .orElse(null);

            if (comment == null) {
                System.out.println("Invalid comment id selected. Try again.");
            } else {
                System.out.println("Enter your updated comment:");
                String commentString = scanner.nextLine();
                comment.update(commentString);
                System.out.println("Comment updated.");
            }
        }
    }



    private void likePointOfInterest(PointOfInterest poi) {
        poi.increaseLikes();
    }

    private void showComments(PointOfInterest poi) {
        if(poi.getComments().isEmpty()){
            System.out.println("Not Comments");
        } else {
            System.out.println("Comments:");
            System.out.println("Id\t User\t\t Created At\t\t\t Updated At\t\t\t Comment");
            poi.getComments().stream().forEach(c -> {
                System.out.println(String.format("%d\t %s\t %s\t %s\t %s\t", c.getId(), c.getUser(), c.getCreatedAt(), c.getUpdatedat(), c.getComment()));
            });        
        }

    }

    private void showPointOfInterest(PointOfInterest poi) {
        System.out.println("ID\t Name\t\t\t\t Likes\t Type\t Location");
        System.out.println(String.format("%d\t %s\t %d\t %s\t %s", poi.getId(), poi.getName(), poi.getLikes(), poi.getType(), poi.getLocation()));
    }
    
}
