package com.example.demo;

import com.example.demo.controllers.dtos.doctor.RegisterDoctorRequest;
import com.example.demo.controllers.dtos.doctor.RegisterDoctorResponse;
import com.example.demo.services.DoctorServices;
import com.example.demo.services.DoctorServicesInterface;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	public DoctorServices services;

	@Test
	void testThatDoctorCanRegister() {
		RegisterDoctorResponse response = services.registerUser(request());
		assertEquals("Registered Doctor Successfully", response.toString());
	}

	public RegisterDoctorRequest request(){
		RegisterDoctorRequest request = new RegisterDoctorRequest();
		request.setFirstname("Ayomide");
		request.setLastname("Ibrahim");
		request.setEmail("DrAyomideIbrahim@gmail.com");
		request.setUsername("Dr Ayo");
		request.setPassword("Ayomide");
		return request;
	}
}
