package com.tpe.service;

import com.tpe.domain.Hotel;
import com.tpe.exception.HotelNotFoundException;
import com.tpe.repository.HotelRepository;

import java.util.List;
import java.util.Scanner;

public class HotelService {
    private Scanner scanner = new Scanner(System.in);
    private final HotelRepository hotelRepository;
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    //    TASK 1-c:
    public void saveHotel() {

        Hotel newHotel = new Hotel();

        System.out.println("Enter Hotel Name:");
        newHotel.setName(scanner.nextLine());

        System.out.println("Enter Hotel Location:");
        newHotel.setLocation(scanner.nextLine());

        hotelRepository.save(newHotel);
    }

//    TASK 2-c: Display the hotel found by ID
    public Hotel findHotelById() {

        System.out.println("Enter Hotel ID:");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Hotel foundHotel = hotelRepository.findById(id);

        try {
            if (foundHotel != null) {
                System.out.println("=========================================================");
                System.out.println(foundHotel);
                System.out.println("=========================================================");
            } else {
                throw new HotelNotFoundException("Hotel not found by the ID: " + id);
            }
        } catch (HotelNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return foundHotel;
    }

//    TASK 3-c: List of all Hotels
    public void getAllHotels() {
        List<Hotel> allHotels = hotelRepository.findAll();

        if (allHotels.isEmpty()) {
            System.out.println("=========== All Hotels ===========");

            for (Hotel hotel: allHotels) {
                System.out.println(hotel);
            }
            System.out.println("==================================");
        } else {
            System.out.println("There are no Hotels!");
        }
    }

//    TASK 7-b:
    public void deleteById() {

        Hotel foundHotel = findHotelById();

        if (foundHotel != null) {
            System.out.println(foundHotel);
            System.out.println("Are you sure that you wanna delete this hotel?");
            System.out.println("Please choose Y (YES) or N (NO)");
            String select = scanner.nextLine();

            if (select.equalsIgnoreCase("y")) {
                hotelRepository.delete(foundHotel);
            } else {
                System.out.println("Deletion cancelled!");
            }
        }
    }
}
