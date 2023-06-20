package com.example.dean.models;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "room", schema = "main")
public class Room {
    //ID, room name, status, and any other necessary information.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long room_id;
    @Column(name = "room_name") // Update the column name here
    private String roomName; // Update the variable name here

    private Status status;

    @OneToMany(mappedBy = "room", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Player> players = new ArrayList<>();

    public List<Player> getPlayers() {
        return players;
    }
        public String showPlayers() {
            StringBuilder builder = new StringBuilder();
            for (Player player: players)
            {
                builder.append(player.getName()).append("\n");
            }
            return builder.toString();
        }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public String getRoomName() {
        return roomName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }


    public void setRoom_id(Long id) {
        this.room_id = id;
    }

    public Long getRoom_id() {
        return room_id;
    }
}

