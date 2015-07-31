package spring.tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.tests.other.OtherMessageService;

@Component
public class MessagePrinter {
	final private MessageService service;
	
	private OtherMessageService otherMessageService;
	
	
	public OtherMessageService getOtherMessageService() {
		return otherMessageService;
	}

	@Autowired(required=true)
	public void setOtherMessageService(OtherMessageService otherMessageService) {
		System.out.println("Passou por aqui");
		this.otherMessageService = otherMessageService;
	}

	@Autowired
	public MessagePrinter(MessageService service){
		this.service = service;
	}
	
	public void printMessage(){
		System.out.println(this.service.getMessage());
		this.otherMessageService.sayHello();
	}
	

}


