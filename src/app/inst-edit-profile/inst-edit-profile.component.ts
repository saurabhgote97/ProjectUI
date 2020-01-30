import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-inst-edit-profile',
  templateUrl: './inst-edit-profile.component.html',
  styleUrls: ['./inst-edit-profile.component.css']
})
export class InstEditProfileComponent implements OnInit {

  id:any;
  ip:any
  user : any = {id:'',age:'',contactNo:'',dob:'',email : '', gender:'',instituteName:'',personName:'',password:'',stuAddr:''};
  
    constructor(private service: DataService, private router: Router,private route:ActivatedRoute)
     { 
      this.user  = JSON.parse(window.sessionStorage.getItem("currentUser"));
      console.log("user "+this.user.id);
     }
  
    ngOnInit() 
    {
      console.log(this.service.GetIpById(this.id));
  
      this.service.GetIpById(this.user.id).subscribe((data)=>{
        console.log(data);
         this.user=data;
      })
  
    }
  
     UpdateIp(entireData)
    {
      let empObj = entireData.form.value;
      console.log(empObj);
  
      let observableResult=
          this.service.updateIp(empObj);
  
      observableResult.subscribe((result: any)=>{
      console.log(result+"updated");
      this.router.navigate(["/home/institutePersonDashboard"]);
    
        //In case of error print result
        //console.log(result.name);
      });
    
    }
  

}
