package com.tpe.service;

import com.tpe.domain.Hotel;
import com.tpe.repository.HotelRepository;

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
        System.out.println("The Hotel is saved successfully!");
    }
}
