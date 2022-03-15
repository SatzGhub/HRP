import { Injectable } from '@angular/core';
import { Subject } from 'rxjs/Subject';
import { RentRequest } from './rent-request-model';

@Injectable()
export class RentRequestService {
  postAdded = new Subject<RentRequest[]>();

private rentRequest: RentRequest[] = [
    new RentRequest(101,'Kodambakam', 'Chennai','Sathish Kumar','985745855',''),
    new RentRequest(102,'Guindy', 'Chennai','Sathish Kumar','985745855',''),
    new RentRequest(105,'Meenapakam', 'Chennai','Raja','754855855','Approved'),
    new RentRequest(101,'Kodambakam', 'Chennai','Vinoth Kumar','8596985654',''),
    new RentRequest(102,'Guindy', 'Chennai','Vimal raj','8965874585','')
  ];

  constructor() {}

  getRequests() {
    return this.rentRequest.slice();
  }
  
  addRequest(rentRequet: RentRequest) {
      this.rentRequest.push(rentRequet);
  }

}
