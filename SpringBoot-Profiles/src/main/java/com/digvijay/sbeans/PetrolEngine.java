package com.digvijay.sbeans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"petrol"})
public class PetrolEngine implements Engine {

	@Override
	public void start() {
		System.out.println("Petrol Engine has been started...");
	}

	@Override
	public void stop() {
		System.out.println("Petrol Engine has been stopped!");
	}

}
