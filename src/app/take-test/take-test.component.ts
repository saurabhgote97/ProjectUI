import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-take-test',
  templateUrl: './take-test.component.html',
  styleUrls: ['./take-test.component.css']
})
export class TakeTestComponent implements OnInit {

  marks:any;
  attempedQuestions:any;
  noOfQuestion:any
  noOfNotAttemptedQu:any;
  /////////////////////////////////////////////
  answerKey:any;
  flag:number;
  questions:any;
  student:any;
  questionNo:any;
  options:any[];
  public init2:number =3600;
  public counter:number = 0;
  public seconds:number = 0;
   


  constructor(private service:DataService,private route: ActivatedRoute,private router:Router) 
  {
    console.log("Inside Take Test");
    this.student = JSON.parse(window.sessionStorage.getItem("currentUser"));
    console.log("Id is : "+this.student.sid);
    this.questionNo = 0;
    this.flag=0;
  }

  ngOnInit() {
    this.startCoundown();
    
    this.route.paramMap.subscribe((result)=>
    {
      let no = result.get("No");
      window.sessionStorage.setItem("testId",no);
      this.service.GetQuestions(no).subscribe((data)=>{
        console.log("questions"+data);
        this.questions = data;
        this.questions = data;
        console.log("questions"+this.questions);
       // sessionStorage.setItem("qus",JSON.stringify(this.questions))
      })
    })

    //console.log("After Subscribe "+this.questions)
  }
  Evaluate(myForm)
  {
 
    
    console.log("Inside Evaluate"); 
   //this.seconds = 0; 
    this.flag = 1;
    console.log(myForm);
    console.log(myForm.form.value);
    this.answerKey = myForm.form.value;
    console.log(this.questions);


    // this.questions.forEach(element => {
    // if(element.answer == this.answerKey[0])
    // {
      
    // }

    //});
    this.marks = 0;
    this.attempedQuestions=0;
    this.noOfQuestion = this.questions.length;
    for (let index = 0; index < this.questions.length; index++) 
    {
      if(this.answerKey[index] != null && this.answerKey[index] != "")
      {
        this.attempedQuestions++;
        if(this.answerKey[index] == this.questions[index].answer)
        {
          this.marks++
        }
      }
    }
    console.log("Marks Obtained"+this.marks);
    sessionStorage.setItem("ObtainedMarks",this.marks);
    sessionStorage.setItem("attempedQuestions",this.attempedQuestions);
    sessionStorage.setItem("noOfQuestion",this.noOfQuestion);
    this.noOfNotAttemptedQu = this.noOfQuestion - this.attempedQuestions;
    sessionStorage.setItem("noOfNotAttemptedQu",this.noOfNotAttemptedQu);
    this.router.navigate(["/home/latestResult"]);






    //console.log("questions : "+JSON.parse(sessionStorage.getItem("qus"))[0]);
    // this.route.paramMap.subscribe((result)=>
    // {
    //   let no = result.get("No");
    //   this.service.GetQuestions(no).subscribe((data)=>{
    //   this.questions = data;
    //   console.log(this.questions);
    //   })
    // })

    

  }


  ///////////////////////////////////////////////////////////////////////////////////////////
  startCoundown()
  {
    if(this.init2 && this.init2 >0)
    {
      //this.counter = this.init;
      this.seconds = this.init2;
      console.log(this.displayTimeElapsed());
      this.doCountdown();
    }
  }
  doCountdown(){
    setTimeout(()=>{
       // this.counter = this.counter-1;
        this.seconds = this.seconds-1;
        this.processCountDown();
    },1000);
  }
  processCountDown()
  {
    //console.log(this.counter)
    if( this.seconds == 0)
    {
      if(this.flag == 0)
      {
        alert("Exam Submitted!!");
        this.router.navigate(["/home/studentDashboard"]);



      }
    
    }
    else
    {
       
      this.displayTimeElapsed();
      this.doCountdown();
    }
  }

  displayTimeElapsed() {
    return Math.floor(this.seconds / 3600) + ':' + Math.floor(this.seconds / 60) + ':' + Math.floor(this.seconds % 60);
  }

  Answer(value)
  {
      console.log("Value is "+value);
  }


}
