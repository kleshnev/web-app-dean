import { Injectable } from '@angular/core';
import { HttpClient,HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RoomService {
  private apiEndpoint  = 'http://localhost:8080'; // Replace with your backend API URL

  constructor(private http: HttpClient) { }

  createRoom(roomData: any) {
    const roomName = 'My Room';
    const userId = 123; // Replace with the actual user ID
    const url = 'http://localhost:8080/rooms' +
                `?roomName=${encodeURIComponent(roomName)}` +
                `&userId=${encodeURIComponent(userId)}`;
  
    return this.http.post(url, {});
  }

  joinRoom(roomId: number, playerName: string) {
    const url = `${this.apiEndpoint}/rooms/${roomId}/join`;
    const params = new HttpParams().set('playerName', playerName);
    
    console.log('Trying to join, TEST name: ' + playerName);
  
    return this.http.post(url, null, { params });
  }
}
