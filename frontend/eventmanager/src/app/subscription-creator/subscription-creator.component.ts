import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

import { SubscriptionService } from '../subscription.service';
import { Subscription } from '../subscription';

@Component({
  selector: 'app-subscription-creator',
  templateUrl: './subscription-creator.component.html',
  styleUrls: ['./subscription-creator.component.css']
})
export class SubscriptionCreatorComponent implements OnInit {

  subscriptionForm = this.fb.group({
    username: ['', Validators.required],
    eventId: ['', Validators.required]
  });
  error = "";

  constructor(private fb: FormBuilder, private service: SubscriptionService) { }

  ngOnInit(): void {
  }

  addSubscription() {
    this.service.addSubscription(this.subscriptionForm.value as Subscription).subscribe(
      _ => this.service.sendUpdate("update from SubscriptionCreatorComponent"),
      err => this.error = err.message,
      () => {
        this.subscriptionForm.reset();
        this.error = "Successfully added subscription.";
      }
    );
  }

}
