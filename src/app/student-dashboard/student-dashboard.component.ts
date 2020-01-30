import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-student-dashboard',
  templateUrl: './student-dashboard.component.html',
  styleUrls: ['./student-dashboard.component.css']
})
export class StudentDashboardComponent implements OnInit {

  user:any;
  student:any;
  constructor(private service:DataService) 
  {
    this.student;
    this.student = JSON.parse(window.sessionStorage.getItem("currentUser"));
    console.log("user "+this.student.sid);

  }

  ngOnInit() {
    this.service.GetStudentById(this.student.sid).subscribe((data)=>{
      this.student = data;
    })

  }

}
