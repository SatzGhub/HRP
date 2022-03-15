import { Component, OnInit } from '@angular/core';
import { RentRequest } from '../shared/rent-request-model';
import { RentRequestService } from '../shared/rent-request.service';

@Component({
  selector: 'app-rent-rquests',
  templateUrl: './rent-rquests.component.html',
  styleUrls: ['./rent-rquests.component.css']
})
export class RentRquestsComponent implements OnInit {

  rentRequest: RentRequest[];

  constructor(public rentRquestService: RentRequestService) { }

  ngOnInit(): void {
    this.rentRequest = this.rentRquestService.getRequests();
  }

}
