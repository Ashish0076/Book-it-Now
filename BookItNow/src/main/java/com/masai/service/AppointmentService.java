package com.masai.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.masai.entity.Appointment;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomeThingWentWrongException;

public interface AppointmentService {

	void openAppointmentSlot(Appointment appointment) throws SomeThingWentWrongException;

	List<Appointment> viewAppointmentSlots() throws SomeThingWentWrongException, NoRecordFoundException;

	void updateAppointSlot(Long appId, LocalDate date, LocalTime startTime, LocalTime endTime) throws SomeThingWentWrongException, NoRecordFoundException;

	boolean checkForAppointment(Long appId) throws SomeThingWentWrongException, NoRecordFoundException;

	void deleteAppointmentSlot(Long appId) throws SomeThingWentWrongException, NoRecordFoundException;

	void bookAppointment(Long appId) throws SomeThingWentWrongException, NoRecordFoundException;

	void cancelAppointment(Long appId) throws SomeThingWentWrongException, NoRecordFoundException;

	List<Appointment> viewBookedAppointments() throws SomeThingWentWrongException, NoRecordFoundException;

}
