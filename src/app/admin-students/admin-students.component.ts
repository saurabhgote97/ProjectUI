import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-admin-students',
  templateUrl: './admin-students.component.html',
  styleUrls: ['./admin-students.component.css']
})
export class AdminStudentsComponent implements OnInit {
  Students:any;
  ngOnInit()
   {
    
  }
  

 
  constructor(private service:DataService) { 
    this.service.GetAllStudents().subscribe((data)=>
    {
      this.Students = data;
      console.log(data);
    })
  }

}

