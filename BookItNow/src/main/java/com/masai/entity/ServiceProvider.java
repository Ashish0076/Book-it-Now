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

	@Column(name = "service_name")
	private String ServiceName;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "service_description")
	private String description;

	@OneToMany(mappedBy = "serviceProvider", fetch = FetchType.EAGER)
	Set<Appointment> appointments = new HashSet<>();

	public ServiceProvider() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceProvider(String ServiceName, String username, String password, String phoneNumber,
			String description) {
		super();
		this.ServiceName = ServiceName;
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.description = description;
	}

	public Long getProviderId() {
		return providerId;
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

	public String getServiceName() {
		return ServiceName;
	}

	public void setServiceName(String serviceName) {
		ServiceName = serviceName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}

	@Override
	public String toString() {
		return "ServiceProvider [providerId=" + providerId + ", ServiceName=" + ServiceName + ", username=" + username
				+ ", password=" + password + ", phoneNumber=" + phoneNumber + ", description=" + description + "]";
	}

}
