package com.tpe.service;

import com.tpe.domain.Address;
import com.tpe.domain.Guest;
import com.tpe.exception.GuestNotFoundException;
import com.tpe.exception.RoomNotFoundException;
import com.tpe.repository.GuestRepository;

import java.util.List;
import java.util.Scanner;

public class GuestService {
    Scanner scanner = new Scanner(System.in);
    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    //    TASK 13-b
    public void saveGuest() {
        Guest guest = new Guest();

        System.out.println("Enter guest Name:");
        guest.setName(scanner.nextLine());

        Address address = new Address();

        System.out.println("Enter guest street:");
        address.setStreet(scanner.nextLine());

        System.out.println("Enter guest city:");
        address.setCity(scanner.nextLine());

        System.out.println("Enter guest country:");
        address.setCountry(scanner.nextLine());

        System.out.println("Enter guest zipCode:");
        address.setZipCode(scanner.nextLine());

        guest.setAddress(address);

        guestRepository.save(guest);
//        System.out.println("Guest Saved successfully!");  // postPersist doest this for us
    }

//    TASK 9-b:
    public Guest findGuestById() {
        System.out.println("Enter Guest ID:");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Guest foundGuest = guestRepository.findById(id);

        try{
            if (foundGuest != null) {
                System.out.println("======================================");
                System.out.println(foundGuest);
                System.out.println("======================================");
            }else {
                throw new RoomNotFoundException("Guest not found by the ID: " + id);
            }
        } catch (GuestNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return foundGuest;
    }

//    TASK 10-b:
    public void getAllGuests() {
        List<Guest> guests = guestRepository.findAll();

        if (!guests.isEmpty()){
            System.out.println("========== ALL GUESTS ==========");
            for (Guest guest : guests){
                System.out.println(guest);
            }
            System.out.println("================================");
        }else {
            System.out.println("There are no guests.");
        }
    }

//    TASK 14-b
    public void deleteGuestById() {
        Guest foundGuest = findGuestById();

        if (foundGuest != null) {
            guestRepository.delete(foundGuest);
        }
    }
}
