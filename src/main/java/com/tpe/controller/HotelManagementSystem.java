package com.tpe.controller;

import com.tpe.config.HibernateUtils;
import com.tpe.domain.Guest;
import com.tpe.repository.HotelRepository;
import com.tpe.repository.RoomRepository;
import com.tpe.service.GuestService;
import com.tpe.service.HotelService;
import com.tpe.service.RoomService;

import java.util.Scanner;

public class HotelManagementSystem {

    private static Scanner scanner = new Scanner(System.in);

    public static void displayHotelManagementSystemMenu(){

        HotelRepository hotelRepository = new HotelRepository();
        HotelService hotelService = new HotelService(hotelRepository);

        RoomRepository roomRepository = new RoomRepository();
        RoomService roomService = new RoomService(hotelService, roomRepository);

        GuestService guestService = new GuestService();

        boolean exit = false; //If exit is false, while condition is NOT false, so, true.

        while(!exit){
            System.out.println("========== HOTEL MANAGEMENT SYSTEM ==========");
            System.out.println("1 - Hotel Operations");
            System.out.println("2 - Room Operations");
            System.out.println("3 - Guest Operations");
            System.out.println("4 - Reservation Operations");
            System.out.println("0 - Exit");
            System.out.println("Please enter an option:");

            int choice = scanner.nextInt();
            scanner.nextLine(); //Clears the newline character in the input buffer if it exists.

            switch (choice){
                case 1:
                    displayHotelOperationsMenu(hotelService);
                    break;
                case 2:
                    displayRoomOperationsMenu(roomService);
                    break;
                case 3:
                    displayGuestOperationsMenu(guestService);
                    break;
                case 4:
                    displayReservationOperationsMenu();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Have a nice day!");
                    HibernateUtils.shutDown(); //We close the SessionFactory when we are done with the app.
                    break;
                default:
                    System.out.println("Invalid choice, please choose a valid option.");
                    break;
            }
        }
    }

    //hotel operations
    private static void displayHotelOperationsMenu(HotelService hotelService) {

        //HotelService service = new HotelService();
        System.out.println("Hotel Operation Menu");

        boolean exit = false;
        while (!exit) {
            System.out.println("==== Hotel Operations ====");
            System.out.println("1 - Add a new hotel");
            System.out.println("2 - Find Hotel By ID");
            System.out.println("3 - Delete Hotel By ID");
            System.out.println("4 - Find All Hotels");
            System.out.println("5 - Update Hotel By ID");
            System.out.println("0 - Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    //TASK 1-a: Saving a hotel
                    hotelService.saveHotel();
                    break;
                case 2:
                    //TASK 2-a: Find a hotel
                    hotelService.findHotelById();
                    break;
                case 3:
//                    TASK 7-a: Delete Hotel By ID
                    hotelService.deleteById();
                    break;
                case 4:
                    //TASK 3-a: Find all hotels
                    hotelService.getAllHotels();
                    break;
                case 5:
                    break;
                case 0:
                    exit = true;
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    //room operations
    private static void displayRoomOperationsMenu(RoomService roomService) {
        //RoomService service = new RoomService();
        System.out.println("Room Operation Menu");
        boolean exit = false;
        while (!exit) {
            System.out.println("==== Room Operations ====");
            System.out.println("1 - Add a new room");
            System.out.println("2 - Find Room By ID");
            System.out.println("3 - Delete Room By ID");
            System.out.println("4 - Find All Rooms");
            System.out.println("0 - Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    //TASK 4-a Add a room
                    roomService.saveRoom();
                    break;
                case 2:
                    //TASK 5-a: Find Room By ID
                    roomService.findRoomById();
                    break;
                case 3:
//                    TASK 8-a: Delete Room By ID
                    roomService.deleteRoomById();
                    break;
                case 4:
                    //TASK 6-a: Find all the rooms
                    roomService.getAllRooms();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    //guest operations
    private static void displayGuestOperationsMenu(GuestService guestService) {
        System.out.println("Guest Operation Menu");

        boolean exit = false;
        while (!exit) {
            System.out.println("==== Guest Operations ====");
            System.out.println("1 - Add a new guest");
            System.out.println("2 - Find Guest By ID");
            System.out.println("3 - Delete Guest By ID");
            System.out.println("4 - Find All Guests");
            System.out.println("0 - Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    break;
                case 2:
//                    TASK 9-a: Find Guest By ID
                    guestService.findGuestById();
                    break;
                case 3:
                    break;
                case 4:
//                    TASK 10-a: Find All Guests
                    guestService.findAllGuests();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    //reservation operations
    private static void displayReservationOperationsMenu() {
        System.out.println("Reservation Operation Menu");

        boolean exit = false;
        while (!exit) {
            System.out.println("==== Reservation Operations ====");
            System.out.println("1 - Add a new reservation");
            System.out.println("2 - Find Reservation By ID");
            System.out.println("3 - Find All Reservations");
            System.out.println("4 - Delete Reservation By ID");
            System.out.println("0 - Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    exit = true;
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
