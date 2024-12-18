package com.tpe.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String location;
    @OneToMany(mappedBy = "hotel")  // private Hotel hotel; -> in the room class
    private List<Room> rooms = new ArrayList<>();
}
