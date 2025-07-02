package com.digvijay.sbeans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"default","diesel"})
public class DieselEngine implements Engine {

	@Override
	public void start() {
		System.out.println("Diesel Engine has been started...");
	}

	@Override
	public void stop() {
		System.out.println("Diesel Engine has been stopped");
	}

}
