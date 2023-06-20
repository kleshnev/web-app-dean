package com.example.dean.repositories;

import com.example.dean.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    // Custom query methods or additional repository-specific methods can be defined here if needed

    Optional<Room> findById(Long roomId);

    List<Room> findAll();

}