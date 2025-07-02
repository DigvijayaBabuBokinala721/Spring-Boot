package com.hello.runner;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hello.document.Cricketer;
import com.hello.service.IServiceCricketerImpl;


@Component
public class Runner implements CommandLineRunner {

	
	@Autowired
	private IServiceCricketerImpl iscr;
	
	@Override
	public void run(String... args) throws Exception {

//		System.out.println(iscr.register(new Cricketer(18,"virat","batsman")));
//		System.out.println(iscr.register(new Cricketer(17,"ABD","batsman")));
//		System.out.println(iscr.register(new Cricketer(15,"Bhuvi","bowler")));
//		System.out.println(iscr.register(new Cricketer(33,"hardick","allrounder")));

		Cricketer cktr = new Cricketer(45,"rohit","batsman",Map.of("indian","mi","india","mumbai"),List.of("india","mumbai"));
		cktr.setId(UUID.randomUUID().toString());
		iscr.register(cktr);
		
	}

}
