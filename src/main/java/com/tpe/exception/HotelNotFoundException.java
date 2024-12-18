package com.tpe.exception;

public class HotelNotFoundException extends RuntimeException {
    public HotelNotFoundException(String message) {
        super(message);
    }
}


//Homework: create exceptions
    // RoomNotFoundException
    // ReservationNotFoundException
    // GuestNotFoundException