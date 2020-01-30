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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.ILogin;
import com.app.dao.IStudentDao;
import com.app.pojos.QuestionDatabase;
import com.app.pojos.Student;
import com.app.pojos.StudentHistory;
import com.app.service.ICommon;

@CrossOrigin
@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private IStudentDao studao;
	
	
	@GetMapping("/listQuestion/{id}")
	private ResponseEntity<?> getList(@PathVariable int id)
	{
		Set<QuestionDatabase> questions = studao.getQuestionList(id);
		if(questions != null)
			return new ResponseEntity<Set<QuestionDatabase>>(questions,HttpStatus.OK);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/updateHistory/{id}")
	private ResponseEntity<?> upDateTestHistory(@RequestBody StudentHistory sh,@PathVariable int id)
	{
		System.out.println("Inside Update");
		System.out.println(sh);
		studao.insertStudentHistory(sh,id);
		//if(id != 0)
			//return new ResponseEntity<Integer>(persistedId,HttpStatus.OK);
		return new ResponseEntity<String>("Updated",HttpStatus.NO_CONTENT);
	}
	

	@GetMapping("/listOfHistory/{id}")
	private ResponseEntity<?> getSHList(@PathVariable int id)
	{
		List<StudentHistory> history = studao.listOfStudentHistory(id);
		System.out.println("List :"+history);
		if(history.size() != 0)
			return new ResponseEntity<List<StudentHistory>>(history,HttpStatus.OK);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
}