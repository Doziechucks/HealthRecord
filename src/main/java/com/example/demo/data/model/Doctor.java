package com.example.demo.data.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Doctor extends User{
    private List<Patients> patients;
    private List<Appointment> appointments;

  public Doctor(){
      this.patients = new ArrayList<>();
      this.appointments = new ArrayList<>();
  }
}
