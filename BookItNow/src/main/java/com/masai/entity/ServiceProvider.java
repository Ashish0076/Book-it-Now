package com.masai.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "service_provider")
public class ServiceProvider {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "provider_id")
	private Long providerId;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "name")
	private String name;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "address")
	private String address;

	@Column(name = "description")
	private String description;

	public ServiceProvider() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceProvider(String username, String password, String name, String phoneNumber, String address,
			String description) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ServiceProvider [providerId=" + providerId + ", username=" + username + ", password=" + password
				+ ", name=" + name + ", phoneNumber=" + phoneNumber + ", address=" + address + ", description="
				+ description + "]";
	}

}
