import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-register-ip',
  templateUrl: './register-ip.component.html',
  styleUrls: ['./register-ip.component.css']
})
export class RegisterIpComponent implements OnInit {

  user : any = {id:'',age:'',contactNo:'',dob:'',email : '', gender:'',instituteName:'',password : '',personName:'',stuAddr:''};

  constructor(private service: DataService, private router: Router) 
  {

  }

  ngOnInit() 
  {

  }
  
  RegisterIP(entireData)
  {
    console.log("in stuRegForm....");
    let stuObj=entireData.form.value;
     console.log(stuObj);
     console.log("stu object printed ...");
     let res=this.service.InsertIp(stuObj).subscribe((result)=>{
     console.log(result);
     alert("Your Id is "+result);
     })
       
     console.log(res);
     //register-ip
     this.router.navigate(["/login"]);
  }


}
