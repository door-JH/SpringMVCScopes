package info.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import info.example.beans.DataBean1;

@Controller
public class TestController {
	
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public String test1(HttpServletRequest request) {
		
		request.setAttribute("data1", "문자열1");
		
		return "forward:/result1";
	}
	
	@RequestMapping(value ="/result1", method = RequestMethod.GET)
	public String result1(HttpServletRequest request) {
		
		String temp = (String) request.getAttribute("data1");
		System.out.println("data1 : " + temp);
		
		return "result1";
	}
	
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
		public String test2(Model model) {
			
			model.addAttribute("data1", "테스트2");
			
			return "forward:/result2";
		}
	
	@RequestMapping(value = "/result2", method = RequestMethod.GET)
		public String result2(Model model) {
		
		String temp = (String) model.getAttribute("data1");
		System.out.println("data1 : " + temp);
		
		return "result2";
	}
	
	@RequestMapping(value = "/test3", method = RequestMethod.GET)
		public String test3(Model model) {
		
		model.addAttribute("data1","테스트12");
		
		return "forward:/result3";
	}
	
	@RequestMapping(value = "/result3", method = RequestMethod.GET)
		public String result3(HttpServletRequest request) {
		
		String temp = (String) request.getAttribute("data1");
		System.out.println("data1 : " + temp);
		
		return "result3";
	}
	
	
	@RequestMapping(value = "/test4", method = RequestMethod.GET)
		public String test4(Model model) {
		
		DataBean1 b1 = new DataBean1();
		b1.setData1("민성아");
		b1.setData2("뻉이쳐라");
		
		model.addAttribute("bean",b1);
		
		return "forward:/result4";
	}
	
	@RequestMapping(value = "/result4", method = RequestMethod.GET)
		public String result4(HttpServletRequest request) {
		//vo로 받을 수 있지 않을까?
		DataBean1 bean = (DataBean1) request.getAttribute("bean");
		
		System.out.println("data1 : " + (String) bean.getData1());
		System.out.println("data2 : " + (String) bean.getData2());
		
		return "result4";
	}
	
	@RequestMapping(value = "/test5", method = RequestMethod.GET)
		public ModelAndView test5(ModelAndView mv) {
		
			mv.addObject("data1", "데이터4");
			mv.setViewName("forward:/result5");
		
		return mv;
	}
	
	@RequestMapping(value = "/result5", method = RequestMethod.GET)
		public String result5(HttpServletRequest request) {
		
		String temp = (String) request.getAttribute("data1");
		System.out.println("temp :" + temp);
		return "result5";
	}
	
	//귀찮아 ㅅㅂ
	@GetMapping("/test6")
							//cibal로 불러와야함 
		public String test6(@ModelAttribute("cibal") DataBean1 bean1) {
		
		bean1.setData1("시험");
		bean1.setData2("줫같네");
		
		
		//차이점이 뭐야
		return "forward:/result6";
		//아마 바로 view로 넘어가지 않을까... 맞네 맞어 ㅅㅂ
//		return "result6";
	}
	
	@GetMapping("/result6")
		public String result6(HttpServletRequest request) {
		
		DataBean1 bean1 = (DataBean1) request.getAttribute("cibal");
		
		System.out.println("cibal.data1 = " + (String) bean1.getData1());
		System.out.println("cibal.data2 = " + (String) bean1.getData2());
		
		return "result6";
	}
	
}
	

