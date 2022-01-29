package com.banksystem.controller;

import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.banksystem.model.Transfer;
import com.banksystem.model.User;
import com.banksystem.model.UserInput;
import com.banksystem.service.BSService;

@Controller
public class UserController {
	
	@Autowired
	BSService service;
	
	@Autowired
	HttpSession session;
	
	/*
	 ******************
	 **Deposit Method**
	 ******************
	 */
	@RequestMapping(value = "/deposit", method = RequestMethod.GET)
	public String toDeposit(Model model) {
		UserInput userInput = new UserInput();
		model.addAttribute("userInput", userInput);
		return "deposit";
	}
	@RequestMapping(value = "/deposit_p", method = RequestMethod.POST)
	public String deposit(Model model, UserInput userInput) {
		
		User user = new User();
		String inputNum_S;
		Integer amount;
		inputNum_S = userInput.getInputNum();
		Integer inputNum;
		try {
			inputNum = Integer.parseInt(inputNum_S);
		}catch(NumberFormatException e) {
			session.invalidate();
			model.addAttribute("message", "エラーが発生しました。もう一度最初からやり直してください。");
			return "end";
		}
		user = (User) session.getAttribute("User");
		amount = service.getAmount(user.getLoginId(), user.getLoginPass());
		//null
		if(inputNum_S == null) {
			model.addAttribute("message", "金額を入力してください");
			UserInput userInput1 = new UserInput();
			model.addAttribute("userInput", userInput1);
			return "deposit";
		}
		//初回利用時
		if(amount == null) {
			amount = 0;
		}
		amount = amount + inputNum;
		Integer id = user.getId();
		int numRow = service.deposit(amount, id);
		//failed
		if(numRow < 1) {
			session.invalidate();
			model.addAttribute("message", "エラーが発生しました。もう一度最初からやり直してください。");
			return "end";
		}
		model.addAttribute("message", "預け入れが完了しました");
		return "topMain";
	}
	
	/*
	 *******************
	 **Withdraw Method**
	 *******************
	 */
	@RequestMapping(value = "/withdraw", method = RequestMethod.GET)
	public String toWithdraw(Model model) {
		UserInput userInput = new UserInput();
		model.addAttribute("userInput", userInput);
		return "withdraw";
	}
	@RequestMapping(value = "withdraw_p", method = RequestMethod.POST)
	public String withdraw(Model model, UserInput userInput) {
		
		User user = new User();
		String inputNum_S;
		Integer amount;
		inputNum_S = userInput.getInputNum();
		Integer inputNum;
		try {
			inputNum = Integer.parseInt(inputNum_S);
		}catch(NumberFormatException e) {
			session.invalidate();
			model.addAttribute("message", "エラーが発生しました。もう一度最初からやり直してください。");
			return "end";
		}
		user = (User) session.getAttribute("User");
		amount = service.getAmount(user.getLoginId(), user.getLoginPass());
		//null
		if(inputNum_S == null) {
			model.addAttribute("message", "金額を入力してください");
			UserInput userInput1 = new UserInput();
			model.addAttribute("userInput", userInput1);
			return "withdraw";
		}
		//初回利用時
		if(amount == null) {
			amount = 0;
		}
		//be negative
		if(amount <= inputNum) {
			model.addAttribute("message", "残高が不足しています");
			UserInput userInput1 = new UserInput();
			model.addAttribute("userInput", userInput1);
			return "withdraw";
		}
		amount = amount - inputNum;
		Integer id = user.getId();
		int numRow = service.withdraw(id, amount);
		//failed
		if(numRow < 1) {
			session.invalidate();
			model.addAttribute("message", "エラーが発生しました。もう一度最初からやり直してください。");
			return "end";
		}
		model.addAttribute("message", "お引き出しが完了しました");
		return "topMain";
	}
	
	/*
	 *******************
	 **Transfer Method**
	 *******************
	 */
	@RequestMapping(value = "/transfer", method = RequestMethod.GET)
	public String toTransfer(Model model) {
		Transfer transfer = new Transfer();
		model.addAttribute("Transfer", transfer);
		return "transfer";
	}
	@RequestMapping(value = "/transfer_p", method = RequestMethod.POST)
	public String Transfer(Model model, Transfer transfer) {
		String phone = transfer.getPhone();
		String loginId = transfer.getLoginId();
		String amount_S = transfer.getAmount();
		User user = new User();
		user = (User) session.getAttribute("User");
		String userLoginId = user.getLoginId();
		String userLoginPass = user.getLoginPass();
		Integer amount;
		int id = user.getId();
		//trying convert to integer
		try {
			amount = Integer.parseInt(amount_S);
		}catch(NumberFormatException e) {
			session.invalidate();
			model.addAttribute("message", "エラーが発生しました。もう一度最初からやり直してください。");
			return "end";
		}
		//null
		if(phone == null || loginId == null || amount_S == null) {
			model.addAttribute("message", "全て記入してください");
			model.addAttribute("Transfer", new Transfer());
			return "transfer";
		}
		//negative
		else if(amount < 1) {
			model.addAttribute("message", "正しく入力してください");
			model.addAttribute("Transfer", new Transfer());
			return "transfer";
		}
		
		Integer userAmount = service.getAmount(userLoginId,  userLoginPass);
		userAmount -= amount;
		//be negative
		if(userAmount < 0) {
			model.addAttribute("message", "残高が足りません");
			model.addAttribute("Transfer", new Transfer());
			return "transfer";
		}
		Integer transferAmount = service.getAmountByPhone(phone);
		if(transferAmount == -1) {
			model.addAttribute("errorMessage", "送り先の情報が存在しません");
			model.addAttribute("Transfer", new Transfer());
			return "transfer";
		}
		transferAmount += amount;
		//transfer
		int numRow = service.transfer(phone, loginId, transferAmount);
		//failed
		if(numRow < 1) {
			session.invalidate();
			model.addAttribute("message", "エラーが発生しました。もう一度最初からやり直してください。");
			return "end";
		}else if(numRow == 9999) {
			model.addAttribute("errorMessage", "送り先の情報が存在しません");
			model.addAttribute("Transfer", new Transfer());
			return "transfer";
		}
		//user
		int numRow1 = service.withdraw(id, userAmount);
		//failed
		if(numRow1 < 1) {
			session.invalidate();
			model.addAttribute("message", "エラーが発生しました。もう一度最初からやり直してください。");
			return "end";
		}
		model.addAttribute("message", "送金が完了しました");
		return "topMain";
	}
	
	/*
	 *******************
	 **Customer Method**
	 *******************
	 */
	
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String toCustomer(Model model) {
		User user = new User();
		user = (User) session.getAttribute("user");
		model.addAttribute("User", user);
		return "customer";
	}
	//Done
	@RequestMapping(value = "/customer_p", params = "done", method = RequestMethod.POST)
	public String customer(Model model, User user) {
		return "topMain";
	}
	//Name
	@RequestMapping(value = "/customer_p", params = "changeName", method = RequestMethod.POST)
	public String changeName(Model model) {
		model.addAttribute("User", new User());
		model.addAttribute("message", "新しいお名前を入力してください");
		model.addAttribute("type", "name");
		model.addAttribute("button", "変更する");
		return "change";
	}
	//Phone
	@RequestMapping(value = "/customer_p", params = "changePhone", method = RequestMethod.POST)
	public String changePhone(Model model, User user) {
		model.addAttribute("User", new User());
		model.addAttribute("message", "新しい電話番号を入力してください");
		model.addAttribute("type", "phone");
		model.addAttribute("button", "変更する");
		return "change";
	}
	//Email
	@RequestMapping(value = "/customer_p", params = "changeEmail", method = RequestMethod.POST)
	public String changeEmail(Model model, User user) {
		model.addAttribute("User", new User());
		model.addAttribute("message", "新しいメールアドレスを入力してください");
		model.addAttribute("type", "email");
		model.addAttribute("button", "変更する");
		return "change";
	}
	//LoginId
	@RequestMapping(value = "/customer_p", params = "changeLoginId", method = RequestMethod.POST)
	public String changeLoginId(Model model, User user) {
		model.addAttribute("User", new User());
		model.addAttribute("message", "新しいログインIDを入力してください");
		model.addAttribute("type", "loginId");
		model.addAttribute("button", "変更する");
		return "change";
	}
	//LoginPass
	@RequestMapping(value = "/customer_p", params = "changeLoginPass", method = RequestMethod.POST)
	public String changeLoginPass(Model model, User user) {
		model.addAttribute("User", new User());
		model.addAttribute("message", "新しいログインパスワードを入力してください");
		model.addAttribute("type", "loginPass");
		model.addAttribute("button", "変更する");
		return "change";
	}
	
	/*
	 *****************
	 **Change Method**
	 *****************
	 */
	//name = 1, phone = 2, email = 3, loginId = 4, loginPass = 5
	@RequestMapping(value = "/change", params = "name", method = RequestMethod.POST)
	public String changeName2(Model model, User user) {
		String name = user.getName();
		User sessionUser = new User();
		sessionUser = (User) session.getAttribute("User");
		int id = sessionUser.getId();
		int numRow;
		//empty
		if(name.isEmpty()) {
			model.addAttribute("User", new User());
			model.addAttribute("message", "新しいお名前を入力してください");
			model.addAttribute("errorMessage", "もう一度入力してください");
			model.addAttribute("type", "name");
			model.addAttribute("button", "変更する");
			return "change";
		}
		numRow = service.changeInfo(name, 1, id);
		if(numRow < 1) {
			session.invalidate();
			model.addAttribute("message", "エラーが発生しました。もう一度最初からやり直してください。");
			return "end";
		}
		model.addAttribute("message", "名前の変更が完了しました");
		return "topMain";
	}
	@RequestMapping(value = "/change", params = "phone", method = RequestMethod.POST)
	public String changePhone2(Model model, User user) {
		String phone = user.getPhone();
		User sessionUser = new User();
		sessionUser = (User) session.getAttribute("User");
		int id = sessionUser.getId();
		int numRow;
		Pattern p = Pattern.compile("^[0-9]{8,11}$");
		boolean checkFormat = p.matcher(phone).matches();
		//check
		if(checkFormat == false) {
			model.addAttribute("User", new User());
			model.addAttribute("message", "新しい電話番号を入力してください");
			model.addAttribute("errorMessage", "入力された電話番号のフォーマットが正しくありません");
			model.addAttribute("type", "phone");
			model.addAttribute("button", "変更する");
			return "change";
		}
		int checkPhone = service.checkAccount(phone);
		//already used
		if(checkPhone > 0) {
			model.addAttribute("User", new User());
			model.addAttribute("message", "新しい電話番号を入力してください");
			model.addAttribute("errorMessage", "入力された電話番号は既に使われています");
			model.addAttribute("type", "phone");
			model.addAttribute("button", "変更する");
			return "change";
		}
		//empty
		if(phone.isEmpty()) {
			model.addAttribute("User", new User());
			model.addAttribute("message", "新しい電話番号を入力してください");
			model.addAttribute("errorMessage", "もう一度入力してください");
			model.addAttribute("type", "phone");
			model.addAttribute("button", "変更する");
			return "change";
		}
		numRow = service.changeInfo(phone, 2, id);
		if(numRow < 1) {
			session.invalidate();
			model.addAttribute("message", "エラーが発生しました。もう一度最初からやり直してください。");
			return "end";
		}
		model.addAttribute("message", "電話番号の変更が完了しました");
		return "topMain";
	}
	@RequestMapping(value = "/change", params = "email", method = RequestMethod.POST)
	public String changeEmail2(Model model, User user) {
		String email = user.getEmail();
		User sessionUser = new User();
		sessionUser = (User) session.getAttribute("User");
		int id = sessionUser.getId();
		int numRow;
		//empty
		if(email.isEmpty()) {
			model.addAttribute("User", new User());
			model.addAttribute("message", "新しいメールアドレスを入力してください");
			model.addAttribute("errorMessage", "もう一度入力してください");
			model.addAttribute("type", "email");
			model.addAttribute("button", "変更する");
			return "change";
		}
		numRow = service.changeInfo(email, 3, id);
		if(numRow < 1) {
			session.invalidate();
			model.addAttribute("message", "エラーが発生しました。もう一度最初からやり直してください。");
			return "end";
		}
		model.addAttribute("message", "メールアドレスの変更が完了しました");
		return "topMain";
	}
	@RequestMapping(value = "/change", params = "loginId", method = RequestMethod.POST)
	public String changeLoginId2(Model model, User user) {
		String loginId = user.getLoginId();
		User sessionUser = new User();
		sessionUser = (User) session.getAttribute("User");
		int id = sessionUser.getId();
		int numRow;
		//empty
		if(loginId.isEmpty()) {
			model.addAttribute("User", new User());
			model.addAttribute("message", "新しいログインIDを入力してください");
			model.addAttribute("errorMessage", "もう一度入力してください");
			model.addAttribute("type", "loginId");
			model.addAttribute("button", "変更する");
			return "change";
		}
		numRow = service.changeInfo(loginId, 4, id);
		if(numRow < 1) {
			session.invalidate();
			model.addAttribute("message", "エラーが発生しました。もう一度最初からやり直してください。");
			return "end";
		}
		model.addAttribute("message", "ログインIDの変更が完了しました");
		return "topMain";
	}
	@RequestMapping(value = "/change", params = "loginPass", method = RequestMethod.POST)
	public String changeLoginPass2(Model model, User user) {
		String loginPass = user.getLoginPass();
		User sessionUser = new User();
		sessionUser = (User) session.getAttribute("User");
		int id = sessionUser.getId();
		int numRow;
		//empty
		if(loginPass.isEmpty()) {
			model.addAttribute("User", new User());
			model.addAttribute("message", "新しいログインパスワードを入力してください");
			model.addAttribute("errorMessage", "もう一度入力してください");
			model.addAttribute("type", "name");
			model.addAttribute("button", "変更する");
			return "change";
		}
		numRow = service.changeInfo(loginPass, 5, id);
		if(numRow < 1) {
			session.invalidate();
			model.addAttribute("message", "エラーが発生しました。もう一度最初からやり直してください。");
			return "end";
		}
		model.addAttribute("message", "ログインパスワードの変更が完了しました");
		return "topMain";
	}
	
	/*
	 *****************
	 **Logout Method**
	 *****************
	 * */
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String toLogout(Model model) {
		session.invalidate();
		model.addAttribute("message", "ご利用ありがとうございました");
		return "end";
	}
}
