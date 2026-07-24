import { Injectable } from '@angular/core';

@Injectable()
export class NotificationService {
  private count = 0;

  notify(message: string): void {
    this.count++;
    console.log(`[Notification #${this.count}]: ${message}`);
  }
}
