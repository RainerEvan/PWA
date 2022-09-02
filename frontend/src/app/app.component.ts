import { Component } from '@angular/core';
import { FcmTokens } from './model/fcmtokens';
import { MessagingService } from './service/messaging/messaging.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend';
  message: any;
  constructor(private messagingService: MessagingService) { }
  
  ngOnInit() {
    this.messagingService.requestPermission();
    this.messagingService.receiveMessage();
    this.message = this.messagingService.currentMessage;
  }
}
