package com.criss.wang.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.criss.wang.annotation.User;

@Controller
public class InterceptorController {

	@GetMapping("/login1")
	public String login1() {
		return "login";
	}

	@User
	@PostMapping("/login")
    public String login(@RequestParam(value="userName", required=false) String userName,
    		@RequestParam(value = "password", required = false) String password, HttpServletRequest request){
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
		HttpSession session = request.getSession();
		session.setAttribute("userName", userName);
		session.setAttribute("password", password);
		System.out.println("userName:" + userName);

		HashMap<String, String> map = new HashMap<>();
		map.put("a", "b");
		String str = map.put("a", "c");
		System.out.println(map.get("a"));
		System.out.println(str);
        return "success";
    }

	@RequestMapping(value = "/success", method = RequestMethod.POST)
	public String hello() {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
		System.out.println("实力肯定放假");
		return "hello";
	}

}
