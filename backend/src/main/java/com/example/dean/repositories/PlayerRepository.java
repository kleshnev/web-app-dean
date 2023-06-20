package com.example.dean.repositories;
import com.example.dean.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    // You can define additional custom methods here if needed
}