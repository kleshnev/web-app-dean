package com.example.dean.services;

import com.example.dean.models.Player;
import com.example.dean.models.Room;
import com.example.dean.repositories.PlayerRepository;
import com.example.dean.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final PlayerRepository playerRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository, PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
        this.roomRepository = roomRepository;
    }

    public Room createRoom(String roomName, Long userId) {
        Room room = new Room();
        room.setRoomName("My Room");
        return roomRepository.save(room);
    }
    public Room joinRoom(Long roomId, String playerName) {
        Room room = roomRepository.findById(roomId).orElse(null);
        if (room != null) {
            Player player = new Player();
            player.setName(playerName);
            roomRepository.save(room);
            player.setRoom(room);  // Set the room for the player
            room.getPlayers().add(player);
            playerRepository.save(player);
            System.out.println("PLAYERS NOW:" +room.showPlayers());
            room = roomRepository.save(room); // Save the room and update the reference

            if (room != null) {
                // Room successfully saved
                System.out.println("Room saved: " + room.getRoom_id());
                System.out.println("Players in room: " + room.showPlayers());
            } else {
                // Failed to save room
                System.out.println("Failed to save room");
            }
        }
        return room;
    }
    public void deleteRoom(Long roomId) {
        roomRepository.deleteById(roomId);
    }

    public Room getRoomById(Long roomId) {
        return roomRepository.findById(roomId).orElse(null);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
}
