import { Component, OnInit } from '@angular/core';
import { RentReport } from '../shared/rent-report-model';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {

  rentReport: RentReport[];
  constructor() { }

  ngOnInit(): void {
    this.rentReport = [
      new RentReport(3243,101,'Kodambakam', 'Chennai','2-BHK','Sathish Kumar',13400,'Pending'),
      new RentReport(5455,103,'Guindy', 'Chennai','3-BHK','Mani Raj',9500,'Declined'),
      new RentReport(8475,205,'V.V Nagar', 'Madurai','2-BHK','Vignesh',7500,'Pending'),
      new RentReport(2355,774,'Kamaraj Nagar', 'Trichy','3-BHK','Mathyalagan',6520,'Approved'),
      new RentReport(2545,101,'Kodambakam', 'Chennai','1-BHK','Sathish Kumar',7750,'Pending'),
      new RentReport(2387,101,'T.Nagar', 'Chennai','2-BHK','Dinesh kumar',18500,'Pending'),
      new RentReport(9586,107,'Annagar', 'Chennai','3-BHK','Francis John',19500,'Declined'),
    ]
  }

}
