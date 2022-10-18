package info.example.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import info.example.beans.DataBean1;
import info.example.beans.DataBean2;
import info.example.beans.DataBean3;
import info.example.beans.DataBean4;

@Controller
public class TestController {
	
	@Autowired
	DataBean1 requestbean1;
	
	@GetMapping("/test1")
	public String test1() {
		
		requestbean1.setData1("문자열1");
		requestbean1.setData2("문자열2");
		
		return "forward:/result1";
	}
	
	@GetMapping("/result1")
	public String result1(Model model) {
		
		System.out.println("requestbean1.data1 : " + requestbean1.getData1());
		System.out.println("requestbean1.data2 : " + requestbean1.getData2());
		
		model.addAttribute("requestbean1", requestbean1);
		
		return "result1";
	}
	
	
	@Resource(name = "kimpossibal")
	DataBean2 requestbean2;
	
	
	@GetMapping("/test2")
	public String test2() {
		requestbean2.setData1("문자열3");
		requestbean2.setData2("문자열4");
		
		return "forward:/result2";
	}
	
	@GetMapping("/result2")
	public String result2(Model model) {
		System.out.println("requestBean2.data1 : " + (String) requestbean2.getData1());
		System.out.println("requestBean2.data2 : " + (String) requestbean2.getData2());
		
		model.addAttribute("requestbean2", requestbean2);
		
		return "result2";
	}
	
	
	@Autowired
	DataBean3 db3;
	
	@GetMapping("/test3")
	public String test3() {
		db3.setData1("테스트3 데이터1");
		db3.setData2("테스트3 데이터2");
		
		return "forward:/result3";		
	}
	
	@GetMapping("/result3")
	public String result3(Model model) {
		System.out.println("requestBean3.data1 : " + (String) db3.getData1());
		System.out.println("requestBean3.data2 : " + (String) db3.getData2());
		
		model.addAttribute("db", db3);
		
		return "result3";
	}
	
	@Resource(name = "db4")
	DataBean4 db4;
	
	@GetMapping("/test4")
	public String test4() {
		db4.setData1("db4 data1");
		db4.setData2("db4 data2");
		return "forward:/result4";
	}
	
	@GetMapping("/result4")
	public String result4(Model model) {
		System.out.println("db4 data1 : " + (String) db4.getData1());
		System.out.println("db4 data1 : " + (String) db4.getData2());
		
		model.addAttribute("db", db4);
		return "result4";
	}
	
	
}                  
	
