import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-add-question-to-test',
  templateUrl: './add-question-to-test.component.html',
  styleUrls: ['./add-question-to-test.component.css']
})
export class AddQuestionToTestComponent implements OnInit {

  id: any;
  tests:any
  constructor(private service: DataService, private router: Router,private route:ActivatedRoute)
   {
    this.service.GetAllQuestions().subscribe((data)=>
    {
      this.tests = data;
      console.log(data);
    })
    }

  ngOnInit() 
  {
   this.route.paramMap.subscribe((result)=>
   {
     this.id=result.get("id");
     console.log("id = >>>>>>"+this.id);
    })
  }

  AddQue(entireData)
  {
    console.log("in add que"+entireData);
    console.log("id ="+this.id);
    this.service.addQuestToTest(this.id,entireData).subscribe((result)=>
    {
      console.log(result);
    })

  }
  Nav()
  {
    this.router.navigate(['/home/institutePersonDashboard']);

  }
  //  UpdateIp(entireData)
  // {
  //   let empObj = entireData.form.value;
  //   console.log(empObj);

  //   let observableResult=
  //       this.service.updateIp(empObj);

  //   observableResult.subscribe((result: any)=>{
  //   console.log(result+"updated");
  //   this.router.navigate(["/home/show-all-ip"]);
  
  //     //In case of error print result
  //     //console.log(result.name);
  //   });
  
  // }

}
