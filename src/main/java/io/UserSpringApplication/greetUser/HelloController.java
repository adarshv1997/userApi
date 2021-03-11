package io.UserSpringApplication.greetUser;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(path = "/helloworld") 
	public String helloWorldInternalization(@RequestParam  String userName) {
		return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale()) + " "+ userName;
	}

}
