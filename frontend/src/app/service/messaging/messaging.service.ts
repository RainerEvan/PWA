import { Injectable } from '@angular/core';
import { AngularFireMessaging } from '@angular/fire/compat/messaging';
import { BehaviorSubject } from 'rxjs';
import { FcmtokenService } from '../fcmtoken/fcmtoken.service';

@Injectable({
  providedIn: 'root'
})
export class MessagingService {

  currentMessage = new BehaviorSubject(null);
  accountTokens = [];

  constructor(private afMessaging: AngularFireMessaging, private fcmTokenService:FcmtokenService) {}

  requestPermission(accountId:string) {
    this.afMessaging.requestToken.subscribe({
      next: (token:any) => {
        this.saveToken(accountId, token)
        console.log("Notification permission granted!", token);
      },
      error: (error) => {
        console.error('Unable to get permission',error);
      }
    });
  }

  receiveMessage(){
    this.afMessaging.messages.subscribe({
      next:(payload:any) => {
        console.log("New message received ", payload);
        this.currentMessage.next(payload);
      }
    })
  }

  private saveToken(accountId:string, token:any): void {
    this.fcmTokenService.addFcmToken(accountId,token).subscribe({
      next:(response:any) => {
        console.log("Fcm token saved successfully", response);
      }
    })
      
  }
}
