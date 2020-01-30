import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-create-test',
  templateUrl: './create-test.component.html',
  styleUrls: ['./create-test.component.css']
})
export class CreateTestComponent implements OnInit {
  user1:any;
 
  user:
  {
    "id":"", 
    "assignStatus":"", 
    "completionStatus":"PENDING",
      "name":"" , 
      "noOfStudents":"" , 
      "testDate":"",
      "InstitutePerson":"",
  };

  constructor(private service: DataService, 
    private router: Router) 
    { 
      this.user1  = JSON.parse(window.sessionStorage.getItem("currentUser"));
      console.log("user1 ---- > -->  --> -->  "+this.user1.id);

      this.user=
         {"id":"", 
          "assignStatus":"", 
          "completionStatus":"PENDING", 
          "name":"" , 
          "noOfStudents":"" , 
          "testDate":"",
          "InstitutePerson":""
      };
    }
    
     
  ngOnInit() {
  }

  TestSubmit(entireData)
  {


    console.log("in stuRegForm....");
    let tObj=entireData.form.value;
     console.log(tObj);
     console.log("t object printed ...");
     let res=this.service.InsertTest(tObj,this.user1.id).subscribe((result)=>{
      console.log(result);
this.router.navigate(["/home/institutePersonDashboard"]);

     })
       
     console.log(res);

  }

}
