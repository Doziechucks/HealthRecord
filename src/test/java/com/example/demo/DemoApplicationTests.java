package com.example.demo;

import com.example.demo.controllers.dtos.doctor.RegisterDoctorRequest;
import com.example.demo.controllers.dtos.doctor.RegisterDoctorResponse;
import com.example.demo.controllers.dtos.patient.RegisterPatientRequest;
import com.example.demo.controllers.dtos.patient.RegisterPatientResponse;
import com.example.demo.data.model.Gender;
import com.example.demo.services.DoctorServices;
import com.example.demo.services.PatientServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.demo.data.model.BodyType.SLIM;
import static com.example.demo.data.model.Gender.FEMALE;
import static com.example.demo.data.model.Height.TALL;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	public DoctorServices services;
	@Autowired
	public PatientServices patientServices;

	@Test
	void testThatDoctorCanRegister() {
		RegisterDoctorResponse response = services.registerUser(request());
		assertEquals("Registered Doctor Successfully", response.toString());
	}

	public RegisterDoctorRequest request(){
		RegisterDoctorRequest request = new RegisterDoctorRequest();
		request.setFirstname("Ayomide");
		request.setLastname("Ibrahim");
		request.setEmail("DrAyomideqIbrahimk4@gmail.com");
		request.setUsername("Dr Ayo");
		request.setPassword("Ayomide");
		return request;
	}
	@Test
	void testThatRegisterTwoDoctor(){
		RegisterDoctorResponse firstResponse = services.registerUser(oneRequest());
		RegisterDoctorResponse secondRequest = services.registerUser(twoRequest());
		assertEquals("Registered Doctor Successfully",secondRequest.toString());


	}
	public RegisterDoctorRequest oneRequest(){
		RegisterDoctorRequest firstRequest = new RegisterDoctorRequest();
		firstRequest.setFirstname("Onyii");
		firstRequest.setLastname("ifin");
		firstRequest.setEmail("Onyinyeg12@gmail.com");
		firstRequest.setUsername("Dr Onyii");
		firstRequest.setPassword(1234);
		return firstRequest ;
		}
	public RegisterDoctorRequest twoRequest(){
		RegisterDoctorRequest secondRequest = new RegisterDoctorRequest();
		secondRequest.setFirstname("Chibuzo");
		secondRequest.setLastname("Sikiru");
		secondRequest.setEmail("sikiruk7@gmail.com");
		secondRequest.setUsername("Dr Sk");
		secondRequest.setPassword("shibuzo@132");
		return secondRequest;


    }
	@Test
 public void testThatPatientCanRegister(){
	 RegisterPatientResponse response = patientServices.registerPatient(patientRequest());
	 assertEquals("Registered Patient Successfully",response.toString());
 }
 public RegisterPatientRequest patientRequest(){
		RegisterPatientRequest patientRequest = new RegisterPatientRequest();
		patientRequest.setFirstname("ayo");
		patientRequest.setLastname("mide");
		patientRequest.setEmail("ayo.semicolon3@gmail.com");
		patientRequest.setUsername("ayomi@12");
		patientRequest.setPassword(12309);
		patientRequest.setId(112323534645L);
		patientRequest.setHeight(TALL);
		patientRequest.setBodyType(SLIM);
		patientRequest.setGender(FEMALE);
		return patientRequest;
 }

}
