package com.polytech.eventmanager.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_event")
public class EventSubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_number")
    private Long id;

    @Column(name = "user_username")
    private String username;

    @Column(name = "event_id")
    private Long eventId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id", insertable = false, updatable = false)
    private Event event;

    @Column(name = "date_of_order", nullable = false)
    private Date dateOfOrder;

}