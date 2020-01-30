import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register-student',
  templateUrl: './register-student.component.html',
  styleUrls: ['./register-student.component.css']
})
export class RegisterStudentComponent implements OnInit {


  user : any = {age:'',contactNo:'',dob:'',edu_type:'',email : '', gender:'',gpa:'',password : '',stuAddr:'',stuName:'',year:''};

  
  constructor(private service: DataService, private router: Router) 
  { }



message = "";
ngOnInit() {
}

OnAddCallMe(entireData)
{
let empObj = entireData.form.value;
console.log(empObj);

let observableResult=
this.service.InsertStu(empObj);

observableResult.subscribe((result: any)=>{
console.log(result);
alert("Your Id is "+result);
this.router.navigate(["/login"]);


//In case of error print result
//console.log(result.name);
});

}
GoBackHome()
{
this.router.navigate(['/home']);
}

}
