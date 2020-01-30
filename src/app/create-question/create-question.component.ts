import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-create-question',
  templateUrl: './create-question.component.html',
  styleUrls: ['./create-question.component.css']
})
export class CreateQuestionComponent implements OnInit {
  user:any = {"id":"",  "answer":"",  "op1":"", "op2":"",  "op3":"",  "op4":"", "question":""}
  constructor(private service: DataService, private router: Router) { }

  ngOnInit() {
  }

  SubmitQuestion(entireData)
  {
    console.log("in stuRegForm....");
    let stuObj=entireData.form.value;
     console.log(stuObj);
     console.log("stu object printed ...");
     let res=this.service.InsertQuestion(stuObj).subscribe((result)=>{
console.log(result);
this.router.navigate(["/home/institutePersonDashbo"]);

     })
       
     console.log(res);

  }

}
