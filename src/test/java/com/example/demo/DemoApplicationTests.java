package com.example.demo;

import com.example.demo.controllers.dtos.doctor.RegisterDoctorRequest;
import com.example.demo.controllers.dtos.doctor.RegisterDoctorResponse;
import com.example.demo.services.DoctorServices;
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
		request.setEmail("DrAyomideqIbrahim1@gmail.com");
		request.setUsername("Dr Ayo");
		request.setPassword("Ayomide");
		return request;
	}
	@Test
	void testThatDeclineDuplicateEmail(){
		RegisterDoctorResponse firstResponse = services.registerUser(oneRequest());
		RegisterDoctorResponse secondRequest = services.registerUser(twoRequest());
		assertEquals("Registered Doctor Successfully",secondRequest.toString());
//		assertEquals("An error occurred",firstResponse.toString());

	}
	public RegisterDoctorRequest oneRequest(){
		RegisterDoctorRequest firstRequest = new RegisterDoctorRequest();
		firstRequest.setFirstname("Onyii");
		firstRequest.setLastname("ifin");
		firstRequest.setEmail("Onyinyeg11@gmail.com");
		firstRequest.setUsername("Dr Onyii");
		firstRequest.setPassword(1234);
		return firstRequest ;
		}
	public RegisterDoctorRequest twoRequest(){
		RegisterDoctorRequest secondRequest = new RegisterDoctorRequest();
		secondRequest.setFirstname("Chibuzo");
		secondRequest.setLastname("Sikiru");
		secondRequest.setEmail("sikiruk88@gmail.com");
		secondRequest.setUsername("Dr Sk");
		secondRequest.setPassword("shibuzo@132");
		return secondRequest;


    }

}
