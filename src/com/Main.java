package com;

import java.util.Scanner;

public class Main {
    
    private static Scanner scanner;
    
    private static String[] menu = {
        "Search Point of Interest by Type",
        "Search Point of Interest by Location",
        "Exit"
    };


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        PointOfInterestConsoleService pointOfInterestConsoleService = new PointOfInterestConsoleService(scanner);
        int selectedMenu;
        
        menu:
        while(true){
            System.out.println("Select the following menu");        
            for (int i = 0; i < menu.length; i++) {
                System.out.printf("%d. %s\n", i+1, menu[i]);
            }
            System.out.printf("Enter the menu Index or Enter %d or any number to exit from menu: ", menu.length);
            try {
                selectedMenu = scanner.nextInt(); scanner.nextLine();
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
            
            switch(selectedMenu) {
                case 1:
                    pointOfInterestConsoleService.searchByType();
                    break;
                case 2:
                    pointOfInterestConsoleService.searchByLocation();
                    break;
                default:
                    break menu;
            }    
        }
        System.out.println("Program Exited");
    }    
}
