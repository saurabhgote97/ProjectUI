import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-design-test',
  templateUrl: './design-test.component.html',
  styleUrls: ['./design-test.component.css']
})
export class DesignTestComponent implements OnInit {
  student:any;
  tests:any;
  user1:any;

  constructor(private service: DataService) 
  {
    this.user1  = JSON.parse(window.sessionStorage.getItem("currentUser"));
      console.log("user1 ---- > -->  --> -->  "+this.user1.id);

    console.log("Inside Student Show test");

    this.service.GetTestByIpId(this.user1.id).subscribe((data)=>
    {
      this.tests = data;
      console.log(data);
    })
  }


  ngOnInit()
   {
    // this.service.GetTestById(this.user1.id).subscribe((data)=>
    // {
    //   this.tests = data;
    //   console.log(data);
    // })
  }

}
