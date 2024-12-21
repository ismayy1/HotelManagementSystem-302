package com.tpe.service;

import com.tpe.domain.Reservation;
import com.tpe.exception.GuestNotFoundException;
import com.tpe.exception.ReservationNotFoundException;
import com.tpe.exception.RoomNotFoundException;
import com.tpe.repository.ReservationRepository;

import java.util.Scanner;

public class ReservationService {

    Scanner scanner = new Scanner(System.in);

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

//    TASK 11-b:
    public Reservation findReservationByID() {

        System.out.println("Enter Reservation ID:");
        Long id = scanner.nextLong();
        scanner.nextLine();


        Reservation reservation = reservationRepository.findByID(id);
        try{
            if (reservation != null) {
                System.out.println("======================================");
                System.out.println(reservation);
                System.out.println("======================================");
            }else {
                throw new ReservationNotFoundException("Reservation not found by the ID: " + id);
            }
        } catch (ReservationNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return reservation;
    }
}
