package spring.tests.other;

import org.springframework.stereotype.Component;

@Component
public class OtherMessageService {
	public void sayHello(){
		System.out.println("Hello");
	}
}
