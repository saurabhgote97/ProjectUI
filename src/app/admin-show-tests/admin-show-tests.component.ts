import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-admin-show-tests',
  templateUrl: './admin-show-tests.component.html',
  styleUrls: ['./admin-show-tests.component.css']
})
export class AdminShowTestsComponent implements OnInit {

  tests:any;
  constructor(private service:DataService) { 
    this.service.GetAllTests().subscribe((data)=>
    {
      this.tests = data;
      console.log(data);
    })
  }

  ngOnInit() {
  }

}
