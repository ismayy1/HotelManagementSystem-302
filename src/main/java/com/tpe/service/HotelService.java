package com.tpe.service;

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

    }
}
