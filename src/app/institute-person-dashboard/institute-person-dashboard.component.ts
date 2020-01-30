import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-institute-person-dashboard',
  templateUrl: './institute-person-dashboard.component.html',
  styleUrls: ['./institute-person-dashboard.component.css']
})
export class InstitutePersonDashboardComponent implements OnInit {

  user : any = {id:'',age:'',contactNo:'',dob:'',email : '', gender:'',instituteName:'',personName:'',stuAddr:''};
  constructor(private service: DataService) 
  { 
    this.user  = JSON.parse(window.sessionStorage.getItem("currentUser"));
    console.log("user "+this.user.id);
  }

  ngOnInit() 
  {
    this.service.GetIpById(this.user.id).subscribe((data)=>{
    console.log(data);
    this.user=data;
    });

  }
}
