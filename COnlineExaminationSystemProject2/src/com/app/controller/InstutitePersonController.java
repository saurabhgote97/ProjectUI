package com.app.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.app.dao.IStudentDao;

import com.app.pojos.Admin;
import com.app.pojos.CompletionStatus;
import com.app.pojos.InstitutePerson;
import com.app.pojos.QuestionDatabase;
import com.app.pojos.Test;
import com.app.service.ICommon;

@CrossOrigin
@RestController
@RequestMapping("/institutePerson")
public class InstutitePersonController 
{
	
	@Autowired 
	private ICommon commonService;
	@Autowired
	private IStudentDao studao;
	
	@PostMapping("/login")
	private ResponseEntity<?> login(@RequestBody InstitutePerson details)
	{
		InstitutePerson ip = commonService.institutePersonLogin(details.getEmail(),details.getPassword());
		if(ip != null)
			return new ResponseEntity<InstitutePerson>(ip,HttpStatus.OK);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping
	private ResponseEntity<?> getTestList()
	{
		System.out.println("Inside GetTestList adya/////");
		List<Test> ip = studao.getAllTestById();
		System.out.println("  ");
		System.out.println(ip);
		if(ip.size() != 0)
			return new ResponseEntity<List<Test>>(ip,HttpStatus.OK);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	

	@GetMapping("/getInstpById/{iid}")
	private ResponseEntity<?> getInstpById(@PathVariable int iid)
	{
		System.out.println("Inside Student Controller/list");
		InstitutePerson list1 = studao.getIpById(iid);
		
		if(list1 != null)
		{
			System.out.println(list1.toString());
			return new ResponseEntity<InstitutePerson>(list1,HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}



	@PutMapping("/updateIp")
	private ResponseEntity<?> updateIp(@RequestBody InstitutePerson details)
	{
		System.out.println("Student --> "+details);
		System.out.println("Student --> "+details.getPassword());
		System.out.println("Inside Student Controller");
		 this.studao.updateIp(details);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping("/registerQue")
	private ResponseEntity<?> registerQuestion(@RequestBody QuestionDatabase que)
	{
		System.out.println("Inside Student Controller/list");
		 studao.registerQuestion(que);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping("/registerTest/{iid}")
	private ResponseEntity<?> registerTest(@RequestBody Test t,@PathVariable int iid)
	{
		System.out.println("question id ======> "+iid);
		t.setCompletionStatus(CompletionStatus.PENDING);
		System.out.println("Inside Student Controller/list");
		System.out.println(t.toString());
		 studao.registerTest(t,iid);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/testList/{iid}")
	private ResponseEntity<?> getTestList(@PathVariable int iid)
	{
		System.out.println("Inside Student Controller/Testlist");
		List<Test> st = studao.ipTestList(iid);
		if(st != null)
		{
			System.out.println(st);
			return new ResponseEntity<List<Test>>(st,HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	


//	@GetMapping("/addQuestToTest/{tid}/{qid}")
//	private ResponseEntity<?> addQuestToTest(@PathVariable int tid,@PathVariable int qid)
//	{
//		System.out.println("Inside Student Controller/list");
//		 studao.addQuestionToTest(tid, qid);
//		
//		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//	}
	
//	\
	@GetMapping("addQuestion/{tid}/{qid}")
	private ResponseEntity<?> addQuestionToTest(@PathVariable int tid,@PathVariable int qid)
	{
		System.out.println("Inside AddQuestion t :"+" "+tid+" "+qid);
		
		studao.addquestion(tid,qid);
		return new ResponseEntity<String>("Added",HttpStatus.OK);
		
	}

	@GetMapping("/listAllQuestions")
	private ResponseEntity<?> getAllQuestions()
	{
		System.out.println("Inside Student Controller/list");
		List<QuestionDatabase> list1 = studao.getAllQuestions();
		
		if(list1 != null)
		{
			System.out.println(list1.toString());
			return new ResponseEntity<List<QuestionDatabase>>(list1,HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	
	
}
