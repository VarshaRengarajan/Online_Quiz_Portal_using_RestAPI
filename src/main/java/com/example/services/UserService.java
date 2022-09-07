package com.example.services;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Result;
import com.example.model.Test;
import com.example.model.User;
import com.example.repository.QuizRepository;
import com.example.repository.TestRepository;
import com.example.repository.UserRepository;



@Service
public class UserService {
	
	
	List<Result> finalList=new ArrayList<>();
	@Autowired
	UserRepository urepo;
	@Autowired
	QuizRepository qrepo;
	@Autowired
	TestRepository trepo;
	@Autowired
//	Resultrepo resrepo;
//	@Autowired
	User u;
	@Autowired
	Test t;

	Result r= new Result();
	
	public String userLogin(String email,String password)
	{
		u=urepo.findByEmailid(email);
		if(u!=null)
		{
			
		
		if(u.getEmailid().equals(email)&&u.getPassword().equals(password))
		{
			return "Logged in successfully";
		}
		else
		{
			return "invalid credentials";
		}
		
		
	}
	else
	{
		return "User not found";
	}
		

  }
	
	
	public String userRegister(User u)
	{
		if(urepo.findByEmailid(u.getEmailid())==null)
		{
			urepo.save(u);
			return "Registered";
		}
		else
		{
			return "User already exists";
		}
	}
	
	public List<Object> viewAllQuiz()
	{
		return qrepo.listOfQuiz();
	}
	
	public String takeTest(Test t)
	{
		if(t!=null)
		{
			trepo.save(t);
			return "Test is submitted";
		}
		
		else
		{
			return "submission failed";
		}
			
	}
	
	public List<Test> getTestList()
	{
		return trepo.findAll();
	}
	
	public List<Result> result()
	{	
		String email="";
		int mark=0;
		List<Test> obj=trepo.findAll();
		List<User> u= urepo.findAll();
		for (User user : u) {
			mark=0;
			email=user.getEmailid();
			System.out.println(user.getEmailid());
			
			for(Test ob :obj)
			{
				if(user.getUid()==ob.getUserid().getUid())
				{
					
					if(ob.getTestans()==ob.getQuestionid().getAnswer())
					{
						mark++;
					}
					System.out.println("inside"+mark);
					
				}
			}
			System.out.println("outside"+mark);
		
			
			finalList.add(new Result(email,mark));
			
			
			
		}
		System.out.println("final :"+mark);
		
		Collections.sort(finalList);
		System.out.println(finalList);
		return finalList;
		
	}
}
