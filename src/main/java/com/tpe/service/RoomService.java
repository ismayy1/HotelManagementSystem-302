package com.tpe.service;

import com.tpe.domain.Room;

import java.util.Scanner;

public class RoomService {

    Scanner scanner = new Scanner(System.in);

//    TASK 4-b:
    public void saveRoom() {
        Room newRoom = new Room();

        System.out.println("Enter room number:");
        newRoom.setNumber(scanner.nextLine());

        System.out.println("Enter room capacity:");
        newRoom.setCapacity(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Enter Hotel ID:");
    }
}
