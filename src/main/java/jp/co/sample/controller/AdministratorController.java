package jp.co.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.form.LoginForm;
import jp.co.sample.service.AdministratorService;

@Controller
@RequestMapping("/")
public class AdministratorController {
	
	@Autowired
	private AdministratorService administratorService;
	
	@Autowired
	private HttpSession session;
	
	@ModelAttribute
	public InsertAdministratorForm setUpInsertAdministratorForm() {
		return new InsertAdministratorForm();
	}
	
	@ModelAttribute
	public LoginForm setUpLoginForm() {
		return new LoginForm();
	}
	
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "administrator/insert";
	}
	
	@RequestMapping("/insert")
	public String insert(@Validated InsertAdministratorForm form, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println(result);
			return toInsert();
		}
		
		Administrator administrator = new Administrator();
		BeanUtils.copyProperties(form, administrator);
		administratorService.insert(administrator);
		return "redirect:/";
	}
	/**
	 * ログイン画面に遷移
	 * @return
	 */
	@RequestMapping("/")
	public String toLogin() {
		return "administrator/login";
	}
	
	@RequestMapping("/login")
	public String login(LoginForm form, Model model) {
		Administrator administrator = administratorService.login(form.getMailAddress(), form.getPassword());
		if(administrator == null) {
			model.addAttribute("errors", "メールアドレスまたはパスワードが不正です。");
			return toLogin();
		} else {
			session.setAttribute("administratorName", administrator.getName());
		}
		
		return "forward:employee/showList";
	}
	/**
	 * ログアウトをする。
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}

}
