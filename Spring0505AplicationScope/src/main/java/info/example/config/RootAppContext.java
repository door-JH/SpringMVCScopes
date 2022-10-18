package info.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import info.example.beans.DataBean1;
import info.example.beans.DataBean2;

// 프로젝트 작업시 사용할 bean을 정의하는 클래스
@Configuration
public class RootAppContext {
	
	
	@Bean
	@RequestScope // 요청 발생할 때 마다 빈 객체 생성, request X, model O
	public DataBean1 test1() {
		return new DataBean1();
	}
	
	@Bean(name = "kimpossibal")
	@RequestScope
	public DataBean2 test2() {
		return new DataBean2();
	}
	
}