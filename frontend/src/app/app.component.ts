import { Component } from '@angular/core';
import { RoomService } from './room.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  playerName: string = '';
  roomId: number = 0; // Add the roomId property
  userData: any;
  constructor(private roomService: RoomService) {}

  createRoom() {
    const roomData = {
      // Provide the necessary data for creating a room
    };
    this.roomService.createRoom(roomData).subscribe(
      (response: any) => {
        console.log('Room created:', response);
        this.roomId = response.id; // Assign the created room's ID to the roomId property
      },
      (error: any) => {
        console.error('Error creating room:', error);
      }
    );
  }

  joinRoom() { 
      const userData = {
        name: this.playerName, // Use the playerName variable
      };
      
      console.log('Trying to join,name: ' + userData.name)
      console.log('NAME PLAYER: '+ this.playerName , ' ID '+  this.roomId)
      this.roomService.joinRoom(this.roomId, this.playerName).subscribe(
        (response: any) => {
          console.log('Joined room:', response);
        },
        (error: any) => {
          console.error('Error joining room:', error);
        }
      );
  }
}







