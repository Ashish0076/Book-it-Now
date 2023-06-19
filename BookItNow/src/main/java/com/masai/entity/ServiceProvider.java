package com.masai.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "service_provider")
public class ServiceProvider {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "provider_id")
	private Long providerId;

	@Column(name = "name")
	private String name;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "address")
	private String address;

	@OneToMany(mappedBy = "serviceProvider", fetch = FetchType.EAGER)
	Set<Appointment> appointments = new HashSet<>();

	public ServiceProvider() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceProvider(String name, String username, String password, String phoneNumber, String address) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public Long getProviderId() {
		return providerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}

	@Override
	public String toString() {
		return "ServiceProvider [providerId=" + providerId + ", name=" + name + ", username=" + username + ", password="
				+ password + ", phoneNumber=" + phoneNumber + ", address=" + address + ", appointments=" + appointments
				+ "]";
	}

}
