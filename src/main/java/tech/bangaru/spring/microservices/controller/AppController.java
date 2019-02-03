package tech.bangaru.spring.microservices.controller;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tech.bangaru.spring.microservices.domain.Users;
import tech.bangaru.spring.microservices.repository.UserRepository;

@RestController
public class AppController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(value="/")
	@ResponseStatus(HttpStatus.OK)
	public String defaultMethod() {
		return "success";
		
	}	
	
	@RequestMapping(value="/api/v1/todaysDate",produces="application/json")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public String todaysDate() {
		Date todaysDate = Calendar.getInstance().getTime();
		String pattern = "E, dd MMM yyyy HH:mm:ss z";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(todaysDate);
	}
	
	@RequestMapping(value="/api/v1/insertUser")
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public String insertUser() {
		Users u = new Users();
		u.setId(1);
		u.setName("Ivaan");
		userRepository.save(u);
		return "/insertUser executed";
	}
	
	@RequestMapping(value="/api/v1/getUsers")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public String getUsers() {
		List<Users> userList = null;
		userList = userRepository.findAll();
		for (Users users : userList) {
			System.out.println("\n"+users.getId()+"\t"+users.getName());
		}
		
		return "Found "+userList.size()+" users";
	}
	
	@RequestMapping(value="/api/v1/insertManyUsers")
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public String insertManyUsers() {
		
		Users u1 = new Users();
		u1.setId(1);
		u1.setName("Ivaan");
		userRepository.save(u1);
		
		Users u2 = new Users();
		u2.setId(2);
		u2.setName("Raja");
		userRepository.save(u2);
		
		Users u3 = new Users();
		u3.setId(3);
		u3.setName("Shobha");
		userRepository.save(u3);
		
		Users u4 = new Users();
		u4.setId(4);
		u4.setName("Camy");
		userRepository.save(u4);
		
		Users u5 = new Users();
		u5.setId(5);
		u5.setName("Nobody");
		userRepository.save(u5);
		
		return "/insertManyUsers executed";
	}
}
