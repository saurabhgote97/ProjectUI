import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-stu-edit-profile',
  templateUrl: './stu-edit-profile.component.html',
  styleUrls: ['./stu-edit-profile.component.css']
})
export class StuEditProfileComponent implements OnInit {

  user1:any;
  id1:any;
  user : any = {sid:'',age:'',contactNo:'',dob:'',educationType:'',email : '', gender:'',gpa:'',password : '',stuAddr:'',stuName:'',year:''};
  res: string;
  message = "";
  constructor(private service: DataService, private router: Router,private route:ActivatedRoute)
   { 
    this.user1 = JSON.parse(window.sessionStorage.getItem("currentUser"));
    console.log("Id is : "+this.user1.sid);
    this.service.GetStudentById(this.user1.sid).subscribe((data)=>{
      this.user = data;
    })
   }

  ngOnInit() 
  {
    // this.service.GetStudentById(this.user.id).subscribe((data)=>{
    //   console.log(data);
    //    this.user=data;
    // })
  
}

   UpdateStu(entireData)
  {
    let empObj = entireData.form.value;
    console.log("Inside Update"+empObj);

    let observableResult=
        this.service.updateStudent(empObj);

    observableResult.subscribe((result: any)=>{
    console.log(result+"updated");
    this.router.navigate(["/home/studentDashboard"]);
  
      //In case of error print result
      //console.log(result.name);
    });
  }


}
