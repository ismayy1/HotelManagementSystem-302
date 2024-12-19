package com.tpe.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String number;
    @Column(nullable = false)
    private Integer capacity;

    @ManyToOne
    @JoinColumn(name = "hotel_id")  // hotel_id -> is the name that we give to the column on the DB
    private Hotel hotel;    // hotel -> is a name we will declare in the Hotel class
    @OneToMany(mappedBy = "room")
    private List<Reservation> reservations = new ArrayList<>();

    public Room() {
    }

    public Room(Long id, String number, Integer capacity, Hotel hotel) {
        this.id = id;
        this.number = number;
        this.capacity = capacity;
        this.hotel = hotel;
    }
}
