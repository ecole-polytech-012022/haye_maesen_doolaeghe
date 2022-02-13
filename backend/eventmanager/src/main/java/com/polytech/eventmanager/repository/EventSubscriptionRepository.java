package com.polytech.eventmanager.repository;

import com.polytech.eventmanager.model.EventSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventSubscriptionRepository extends JpaRepository<EventSubscription, Long> {

    @Query(value = "select s.event_id from user_event s WHERE s.user_username= :username", nativeQuery = true)
    List<Long> findOrderedEventsFromUser(@Param("username") String username);

    @Query(value = "select count(*) from user_event s WHERE s.event_id= :eventId", nativeQuery = true)
    Integer findNumberOfParticipantsForEvent(@Param("eventId") Long eventId);

}