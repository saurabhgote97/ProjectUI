import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataService 
{

  credentialsDetails:any;

  //constructor(private helper: HttpClient) 
  constructor(private helper: HttpClient) 
  { 
    console.log("Data Service Object Created");
  }


  GetAllTests()
  {
   return this.helper.get("http://localhost:7070/AOnlineExaminationSystemProject/admin/showTestList");

  }
  GetTests()
  {
    return this.helper.get("http://localhost:7070/AOnlineExaminationSystemProject/student/showTestList");

  }

  GetAllStudents()
  {
   return this.helper.get("http://localhost:7070/AOnlineExaminationSystemProject/admin/showStudentList");
  }

  GetAllIPs()
  {
    console.log("in getAllIp function");
   return this.helper.get("http://localhost:7070/AOnlineExaminationSystemProject/admin/showIPList");
  }


  GetAllQuestions()
  {
    console.log("in get all ques");
    //listAllQuestions
    return  this.helper.get("http://localhost:7070/AOnlineExaminationSystemProject/institutePerson/listAllQuestions");
  }

  addQuestToTest(No1,No2)
    {
    console.log("in add que to test");
        return  this.helper.get("http://localhost:7070/AOnlineExaminationSystemProject/institutePerson/addQuestion/"+No1+"/"+No2 );    
  
    }
  
  InsertTest(tObj,No)
  {
    console.log("insidde insert test function"+tObj+No);
    return  this.helper.post("http://localhost:7070/AOnlineExaminationSystemProject/institutePerson/registerTest/"+No,tObj);
  }

  GetInstituteTestById(No)
  {
    return this.helper.get("http://localhost:7070/AOnlineExaminationSystemProject/student/listAssignedTests/"+No);
  }

  InsertQuestion(queObj)
  {
    console.log("insidde insert question function");
    return  this.helper.post("http://localhost:7070/AOnlineExaminationSystemProject/institutePerson/registerQue",queObj);
  }

  InsertStu(empObj)
  {
    return  this.helper.post("http://localhost:7070/AOnlineExaminationSystemProject/student/register",empObj);
  }

  InsertIp(empObj)
  {
    console.log("insidde insert ip function");
    return  this.helper.post("http://localhost:7070/AOnlineExaminationSystemProject/admin/registerInstPerson",empObj);
  }

  GetTestById(No)
  {
    return this.helper.get("http://localhost:7070/AOnlineExaminationSystemProject/student/testList/"+No);
  }

  GetTestByIpId(No)
  {
    return this.helper.get("http://localhost:7070/AOnlineExaminationSystemProject/institutePerson/testList/"+No);
  }

  GetQuestions(No)
  {
    return  this.helper.get("http://localhost:7070/AOnlineExaminationSystemProject/test/listQuestion/"+No );
  }
  UpdateStudentTestHistory(obj,id)
  {
    return this.helper.post("http://localhost:7070/AOnlineExaminationSystemProject/test/updateHistory/"+id,obj);
  }
  GetStudentHistoryById(id)
  {
    console.log("Inside Service "+id);
    return this.helper.get("http://localhost:7070/AOnlineExaminationSystemProject/test/listOfHistory/"+id);
  }

  updateStudent(empObj)
  {
   return this.helper.put("http://localhost:7070/AOnlineExaminationSystemProject/student/updateStudent" ,empObj);
  }

  updateIp(empObj)
  {
   return this.helper.put("http://localhost:7070/AOnlineExaminationSystemProject/institutePerson/updateIp" ,empObj);
  }
  GetIpById(No)
  {
    console.log("in get ip by id");
    return this.helper.get("http://localhost:7070/AOnlineExaminationSystemProject/institutePerson/getInstpById/"+No);
  }
  GetStudentById(No)
  {
    console.log("in get Stu byId");
   // console.log("http://localhost:9091/AOnlineExaminationSystemProject/student/getStuById/"+No);
    return this.helper.get("http://localhost:7070/AOnlineExaminationSystemProject/student/getStuById/"+No);
  }


}




