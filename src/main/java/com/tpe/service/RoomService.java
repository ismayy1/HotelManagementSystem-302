package com.tpe.service;

import com.tpe.domain.Hotel;
import com.tpe.domain.Room;
import com.tpe.exception.RoomNotFoundException;
import com.tpe.repository.RoomRepository;

import java.util.List;
import java.util.Scanner;

public class RoomService {
    Scanner scanner = new Scanner(System.in);
    private final HotelService hotelService;
    private final RoomRepository roomRepository;

    public RoomService(HotelService hotelService, RoomRepository roomRepository) {
        this.hotelService = hotelService;
        this.roomRepository = roomRepository;
    }
//    TASK 4-b:
    public void saveRoom() {
        Room newRoom = new Room();

        System.out.println("Enter room number:");
        newRoom.setNumber(scanner.nextLine());

        System.out.println("Enter room capacity:");
        newRoom.setCapacity(scanner.nextInt());
        scanner.nextLine();

        Hotel foundHotel = hotelService.findHotelById();

        if(foundHotel != null) {
            newRoom.setHotel(foundHotel);
            //foundHotel.getRooms().add(newRoom); is NOT required due to the mappedBy attribute.
            roomRepository.save(newRoom);
        } else {
            System.out.println("Failed to save the room!");
        }
        roomRepository.save(newRoom);
    }

//    TASK 5-b: Print the room and return it. Use custom exception
    public Room findRoomById() {

        System.out.println("Enter Room ID:");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Room room = roomRepository.findById(id);

        try{
            if (room != null) {
                System.out.println("======================================");
                System.out.println(room);
                System.out.println("======================================");
            }else {
                throw new RoomNotFoundException("Room not found by the ID: " + id);
            }
        } catch (RoomNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return room;
    }

    //TASK 6-b
    public void getAllRooms() {
        List<Room> rooms = roomRepository.findAll();

        if (!rooms.isEmpty()){
            System.out.println("========== ALL ROOMS ==========");
            for (Room room : rooms){
                System.out.println(room);
            }
            System.out.println("================================");
        }else {
            System.out.println("There are no rooms.");
        }
    }

//    TASK 8-b
    public void deleteRoomById() {

        Room room = findRoomById();

        if (room != null) {
            roomRepository.delete(room);
        }
    }
}
