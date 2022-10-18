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
@SessionAttributes({"sb1", "sb2"})
public class TestController {
	
	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {
		HttpSession se = request.getSession();
		se.setAttribute("data1", "문자열");
		
		return "test1";
	}
	
	@GetMapping("/result1")
	public String test2(HttpServletRequest request) {
		HttpSession se = request.getSession();
		String data1 = (String) se.getAttribute("data1");
		System.out.println("data1 : " + data1);
		return "redirect:/result6";
	}
	
//	@GetMapping("/result6")
//	public String test3(HttpSession se) {
//		String data1 = (String) se.getAttribute("data1");
//		System.out.println("data1 : " + data1);
//		
//		return "result1";
//	}
	
	
	//-----------------------------------
	
	
	
	@GetMapping("/test4")
	public String test4(HttpSession se) {
		DataBean1 db1 = new DataBean1();
		db1.setData1("문자열1");
		db1.setData2("문자열2");
		
		se.setAttribute("db", db1);
		return "result4";
	}
	
	@GetMapping("/result4")
	public String result4(HttpSession se) {
		
		return "result4";
	}
	
	@ModelAttribute("sb1")
	public DataBean3 sb1() {
		return new DataBean3();
	}
	
	@ModelAttribute("sb2")
	public DataBean3 sb2() {
		return new DataBean3();
	}
	
	@GetMapping("/test5")
	public String test5(@ModelAttribute("sb1") DataBean3 sb1, @ModelAttribute("sb2") DataBean3 sb2) {
		
		sb1.setData1("문자열11");
		sb1.setData2("문자열12");
		sb2.setData1("문자열21");
		sb2.setData2("문자열22");
		
		return "test5";
	}
	
	@GetMapping("/result5")
	public String result5(@ModelAttribute("sb1") DataBean3 sb1, @ModelAttribute("sb2") DataBean3 sb2) {
		
		System.out.println(sb1.getData1());
		System.out.println(sb1.getData2());
		System.out.println(sb2.getData1());
		System.out.println(sb2.getData2());
		
		return "result5";
	}
	
	
}                  
	
