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
  accountId = "e4b10ea0-99de-4d32-ab9d-b6be62fe5b05";
  constructor(private messagingService: MessagingService) { }
  
  ngOnInit() {
    this.messagingService.requestPermission(this.accountId);
    this.messagingService.receiveMessage();
  }
}
