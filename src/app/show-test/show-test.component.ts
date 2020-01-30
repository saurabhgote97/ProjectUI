import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-show-test',
  templateUrl: './show-test.component.html',
  styleUrls: ['./show-test.component.css']
})
export class ShowTestComponent implements OnInit {

  student:any;
  tests:any
  constructor(private service: DataService) 
  {
    console.log("Inside Student Show test");
    this.student = JSON.parse(window.sessionStorage.getItem("currentUser"));
    console.log("Id is : "+this.student.sid);
    this.service.GetAllTests().subscribe((data)=>
    {
      this.tests = data;
      console.log(data);
    })
  }


  ngOnInit() {
  //  console.log("Inside Student Show test");
  //  this.student = JSON.parse(window.sessionStorage.getItem("currentUser"));
  //  console.log("Id is : "+this.student.sid);
  
  }

}
