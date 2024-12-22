package com.tpe.service;

import com.tpe.domain.Guest;
import com.tpe.domain.Reservation;
import com.tpe.domain.Room;
import com.tpe.exception.ReservationNotFoundException;
import com.tpe.repository.ReservationRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ReservationService {
    Scanner scanner = new Scanner(System.in);
    private final ReservationRepository reservationRepository;
    private final GuestService guestService;
    private final RoomService roomService;

    public ReservationService(ReservationRepository reservationRepository,
                              GuestService guestService, RoomService roomService) {
        this.reservationRepository = reservationRepository;
        this.guestService = guestService;
        this.roomService = roomService;
    }

    //    TASK 15-b
    public void createReservation() {
        Reservation reservation = new Reservation();

        System.out.println("Enter check-in Date (yyyy-MM-dd)");
        reservation.setCheckInDate(LocalDate.parse(scanner.nextLine()));
        System.out.println("Enter check-out Date (yyyy-MM-dd)");
        reservation.setCheckOutDate(LocalDate.parse(scanner.nextLine()));

        Room room = roomService.findRoomById();
        Guest guest = guestService.findGuestById();

        reservation.setRoom(room);
        reservation.setGuest(guest);

        reservationRepository.save(reservation);
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

//    TASK 12-b:
    public void findAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();

        if (!reservations.isEmpty()){
            System.out.println("========== ALL RESERVATION ==========");
            for (Reservation reservation : reservations){
                System.out.println(reservation);
            }
            System.out.println("================================");
        }else {
            System.out.println("There are no reservations.");
        }
    }

//    TASK 16-b:
    public void deleteReservationById() {
        Reservation reservation = findReservationByID();

        if (reservation != null) {
            reservationRepository.delete(reservation);
            System.out.println("Reservation cancelled!");
        } else {
            System.out.println("Deletion Cancelled!");
        }
    }
}
