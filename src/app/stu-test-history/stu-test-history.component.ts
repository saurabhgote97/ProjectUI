import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-stu-test-history',
  templateUrl: './stu-test-history.component.html',
  styleUrls: ['./stu-test-history.component.css']
})
export class StuTestHistoryComponent implements OnInit {

  student:any;
  testHistorys:any;
  constructor(private service:DataService) 
  {
    
    this.student = JSON.parse(window.sessionStorage.getItem("currentUser"));
    console.log(this.student);
    console.log("id is "+this.student.sid);
    this.service.GetStudentHistoryById(this.student.sid).subscribe((data)=>{
      console.log("Data innside Subscribe"+ data);  
      this.testHistorys = data;
      this.testHistorys.forEach(element => {
        console.log(element);
      });
    });
    console.log("Data "+ this.testHistorys);
  }

  ngOnInit() 
  {
 
  }

}
