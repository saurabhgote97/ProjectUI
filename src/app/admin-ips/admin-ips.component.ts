import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-admin-ips',
  templateUrl: './admin-ips.component.html',
  styleUrls: ['./admin-ips.component.css']
})
export class AdminIPSComponent implements OnInit {


  institutes:any;
  constructor(private service:DataService) { 
    this.service.GetAllIPs().subscribe((data)=>
    {
      this.institutes = data;
      console.log(data);
    })
  }
  ngOnInit() {
  }

}
