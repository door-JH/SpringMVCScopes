package info.example.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import info.example.beans.DataBean1;
import info.example.beans.DataBean2;
import info.example.beans.DataBean3;
import info.example.beans.DataBean4;

@Controller
public class TestController {
	
	@Resource(name = "db4")
	DataBean4 db4;
	
	@GetMapping("/test4")
	public String test4() {
		db4.setData1("문자열1");
		db4.setData2("문자열2");
		
		return "test4";
	}
	
	@GetMapping("/result4")
	public String result4(Model model) {
		System.out.println(db4.getData1());
		System.out.println(db4.getData2());
		model.addAttribute("db4", db4);
		return "result4";
	}
	
}                  
	
