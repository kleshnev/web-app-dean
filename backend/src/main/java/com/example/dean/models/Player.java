package com.example.dean.models;

import jakarta.persistence.*;

@Entity
@Table(name = "player", schema = "main")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specify the generation strategy
    @Column(name = "player_id")
    private Long player_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;
    @Column(name = "name")
    private String name;
//test

    public void setRoom(Room room) {
        if (this.room == room) {
            return; // If the room is already set, no need to make changes
        }

        if (this.room != null) {
            this.room.getPlayers().remove(this); // Remove player from the current room
            this.room = null;
        }

        this.room = room;

        if (room != null) {
            room.getPlayers().add(this); // Add player to the new room
        }
    }
    public Long getPlayer_id() {
        return player_id;

    }

    public void setPlayer_id(Long id) {
        this.player_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    // Getters and setters
}