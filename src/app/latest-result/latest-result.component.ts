import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-latest-result',
  templateUrl: './latest-result.component.html',
  styleUrls: ['./latest-result.component.css']
})
export class LatestResultComponent implements OnInit {

  sh:{
    "marksObtained":"",
    "noOfAnsweredQuestion":"",
    "noOfAttemptedQuestions":"",
    "noOfQuestions":"",
    "percentage":"",
    "remark":"",
    "tid":""
  };
  marks:any;
  attempedQuestions:any;
  noOfQuestion:any
  noOfNotAttemptedQu:any;
  percentage:any;
  remark:any;
  student;
  constructor(private service:DataService) {
    this.sh =
    {
      "marksObtained":"",
      "noOfAnsweredQuestion":"",
      "noOfAttemptedQuestions":"",
      "noOfQuestions":"",
      "percentage":"",
      "remark":"",
      "tid":""
    };
    this.student = JSON.parse(window.sessionStorage.getItem("currentUser"));
    console.log(this.student);
   }

  ngOnInit() {

    this.marks = sessionStorage.getItem("ObtainedMarks");
    this.attempedQuestions = sessionStorage.getItem("attempedQuestions");
    this.noOfQuestion = sessionStorage.getItem("noOfQuestion");
    this.noOfNotAttemptedQu = sessionStorage.getItem("noOfNotAttemptedQu");
    this.percentage = ((this.marks)/(this.noOfQuestion))*100;
    let passing = (this.noOfQuestion * 35)/100;
    if(this.marks >= passing)
    {
      this.remark = "PASS";
    }
    else
    {
      this.remark = "FAIL";
    }
    console.log(this.marks)
    
    this.sh.noOfAnsweredQuestion = this.attempedQuestions;
    this.sh.marksObtained = this.marks;
    this.sh.noOfAttemptedQuestions =  this.attempedQuestions;
    this.sh.noOfQuestions = this.noOfQuestion;
    this.sh.percentage = this.percentage;
    this.sh.remark = this.remark;
    this.sh.tid = JSON.parse(window.sessionStorage.getItem("testId"));
    console.log(this.sh);
    this.service.UpdateStudentTestHistory(this.sh,this.student.sid).subscribe((data=>{
      console.log(data);
    }))
  }

}
