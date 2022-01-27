package com.polytech.eventmanager.model;

import lombok.*;
import javax.persistence.*; // import persistance library
import java.util.Date;

@Entity // mark class as a database entity
@Getter // specify separatly lombok annotation instead of @Data to avoid some problems
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "event") // name of database table
public class Event {

    @Id // annotation for ID column
    @GeneratedValue(strategy = GenerationType.IDENTITY) // strategy for ID, here it well be ID++
    @Column(length = 11) // column size on database side definition
    private Integer id;

    @Column(name = "name", nullable = false, length = 45) // database definiton => will launch SQL exception
    // NB: words in name should be linked by underscore => name_of_column
    private String name;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "date")
    private Date date;

}