package spring.tests;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;


@Configuration
@ComponentScan
public class ApplicationTest {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationTest.class);
		MessagePrinter printer = context.getBean(MessagePrinter.class);
		printer.printMessage();
	}
}

@Component
class MessageLogPrinter implements MessageService{

	@Override
	public String getMessage() {
		return "Hello World";
	}
	
}
