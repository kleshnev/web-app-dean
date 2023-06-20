package com.example.dean.controllers;

import com.example.dean.models.Room;
import com.example.dean.repositories.PlayerRepository;
import com.example.dean.repositories.RoomRepository;
import com.example.dean.services.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RoomController {

    private final RoomService roomService;
    private final PlayerRepository playerRepository;
    private final RoomRepository roomRepository; // Add this line


    public RoomController(RoomService roomService, PlayerRepository playerRepository, RoomRepository roomRepository) {
        this.roomService = roomService;
        this.playerRepository = playerRepository;
        this.roomRepository = roomRepository; // Add this line

    }

    @PostMapping("/rooms")
    public ResponseEntity<Room> createRoom(@RequestParam String roomName, @RequestParam Long userId) {
        Room createdRoom = roomService.createRoom(roomName, userId);
        System.out.println("Created room!");
        System.out.println("Players in room: " + createdRoom.showPlayers());
        return ResponseEntity.ok(createdRoom);

    }

    @PostMapping("/rooms/{roomId}/join")
    //TODO receive not string playerName but the obj of player
    public ResponseEntity<Room> joinRoom(@PathVariable Long roomId, @RequestParam String playerName) {
        System.out.println("Received Player Name: " + playerName);
        Room joinedRoom = roomService.joinRoom(roomId, playerName);
        if (joinedRoom != null) {
            // Player successfully joined the room
            System.out.println("Player joined room: " + playerName);
            System.out.println("Players in room: " + joinedRoom.showPlayers());
            return ResponseEntity.ok(joinedRoom);
        } else {
            // Room not found or unable to join
            System.out.println("unable to join");
            return ResponseEntity.notFound().build();
        }
    }
}
