package com.banksystem.controller;

import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.banksystem.model.Contact;
import com.banksystem.model.User;
import com.banksystem.service.BSService;


@Controller
public class TopController {
	
	@Autowired
	private BSService service;
	
	@Autowired
	HttpSession session;
	
	/*
	 *******
	 **TOP**
	 *******
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String top() {
		return "top";
	}
	
	/*
	 ****************
	 **Login Method**
	 *****************
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String toLogin(Model model) {
		User user = new User();
		model.addAttribute("User", user);
		return "login";
	}
	@RequestMapping(value = "/login_p", method = RequestMethod.POST)
	public String login(Model model,  User user) {
		String loginId = user.getLoginId();
		String loginPass = user.getLoginPass();
		user = service.login(loginId, loginPass);
		//error
		if(user.getId() == null) {
			model.addAttribute("message", "もう一度やり直してください");
			User user1 = new User();
			model.addAttribute("User", user1);
			return "login";
		}
		model.addAttribute("User", user);
		//Session
		session.setAttribute("User", user);
		return "topMain";
	}
	
	/*
	 *******************
	 **Register Method**
	 *******************
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String toRegister(Model model) {
		User user = new User();
		model.addAttribute("User", user);
		return "register";
	}
	@RequestMapping(value = "/register_p", method = RequestMethod.POST)
	public String register(Model model, User user) {
		String name = user.getName();
		String loginId = user.getLoginId();
		String loginPass = user.getLoginPass();
		String phone = user.getPhone();
		Pattern p = Pattern.compile("^[0-9]{8,11}$");
		boolean checkFormat = p.matcher(phone).matches();
		//check
		if(checkFormat == false) {
			model.addAttribute("User", new User());
			model.addAttribute("message", "入力された電話番号のフォーマットが正しくありません");
			return "register";
		}
		//not enough
		if(name.isEmpty() || loginId.isEmpty() || loginPass.isEmpty() || phone.isEmpty()) {
			model.addAttribute("User", new User());
			model.addAttribute("message", "もう一度やり直してください");
			return "register";
		}
		int id = service.checkAccount(phone);
		if(id > 0) {
			model.addAttribute("message", "入力された電話番号は既に使われています");
			model.addAttribute("User", new User());
			return "register";
		}
		int rowNum = service.register(user);
		//failed
		if(rowNum < 1) {
			model.addAttribute("message", "登録に失敗しました");
			return "end";
		}
		model.addAttribute("message", "登録が完了しました");
		
		return "end";
	}
	
	/*
	 ******************
	 **Contact Method**
	 ******************
	 */
	@RequestMapping(value="/contact", method=RequestMethod.GET)
	public String toContact(Model model) {
		Contact contact = new Contact();
		model.addAttribute("Contact", contact);
		return "contact";
	}
	@RequestMapping(value="/contact_p" ,method=RequestMethod.POST)
	public String contact(Model model, Contact contact) {
		String email = contact.getEmail();
		String message = contact.getMessage();
		
		//not enough
		if(email.isEmpty() || message.isEmpty()) {
			Contact contact1 = new Contact();
			model.addAttribute("Contact", contact1);
			model.addAttribute("message", "もう一度やり直してください");
			return "contact";
		}
		int rowNum = service.contact(contact);
		//failed
		if(rowNum < 1) {
			model.addAttribute("message", "送信に失敗しました");
			return "end";
		}
		
		model.addAttribute("message", "お問い合わせ内容を送信しました");
		return "end";
	}
}
