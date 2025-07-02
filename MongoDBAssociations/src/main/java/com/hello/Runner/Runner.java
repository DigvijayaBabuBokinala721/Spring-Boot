package com.hello.Runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hello.document.License;
import com.hello.document.Person;
import com.hello.service.IService;


@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private IService is;
	
	@Override
	public void run(String... args) throws Exception {

		
		Person per1 = new Person();
		per1.setName("chinnu");
		License l1 = new License();
		l1.setType("2 wheeler");
		per1.setLicense(l1);
//		is.register(per1);
		
//		is.getPersonInfo().forEach(System.out::println);
		
//		is.getPersonOnName("chinnu").forEach(obj->{
//			
//			for(Object o:obj) {
//				System.out.println(o);
//			}
//		});
		
//		is.getPersonOnNameAllProperties("chinnu").forEach(System.out::println);;
		is.template();
	}

}
