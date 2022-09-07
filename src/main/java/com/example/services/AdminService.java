package com.example.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Admin;
import com.example.model.Question;
import com.example.model.Quiz;
import com.example.model.Statistics;
import com.example.repository.AdminRepository;
import com.example.repository.QuestionRepository;
import com.example.repository.QuizRepository;
import com.example.repository.UserRepository;


@Service
public class AdminService {
	@Autowired
	QuestionRepository qrepo;
	@Autowired
	QuizRepository qurepo;
	@Autowired
	UserRepository urepo;
	@Autowired
	Statistics stat;
	@Autowired
	AdminRepository adrepo;
	
	
	
	public String adminLogin(Admin u)
	{
		Admin ad= adrepo.findById(1).get();
		if(u.getUsername().equals(ad.getUsername())&&u.getPassword().equals(ad.getPassword()))
		{
			return "Hello! admin";
		}
		else
		{
			return "invalid Credentials";
		}
	}
	public String adminupdate(Admin a)
	{
		Admin admin= adrepo.findById(1).get();
		admin.setUsername(a.getUsername());
		admin.setPassword(a.getUsername());
		adrepo.saveAndFlush(admin);
			return "Updated";
	

	}
	
	public String addQuestion(Question q)
	{
		if(q!=null)
		{
			qrepo.save(q);
			return "Entered question is added";
		}
		else
		{
			return "Failed to add";
		}
		
	}
	
	public String addQuiz(Quiz q)
	{
		
		if(q!=null)
		{
			qurepo.save(q);
			return "Entered quiz is added";
		}
		else
		{
			return "Failed to add";
		}
	}
	
	public List<Quiz> viewAllQuiz()
	{
		return qurepo.findAll();
	}
	
	public Statistics quizInfo()
	{
		stat.setUsers(urepo.findAll().size());
		stat.setQuestions(qrepo.findAll().size());
		stat.setQuiz(qurepo.listOfQuiz());
		
		return stat;

	}
	
	

}