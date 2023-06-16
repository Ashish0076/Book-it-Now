package com.masai.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "service")
public class Service {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "service_id")
	private Long serviceId;

	@ManyToOne
	@JoinColumn(name = "provider_id")
	private ServiceProvider serviceProvider;

	@Column(name = "service_name")
	private String serviceName;

	@Column(name = "description")
	private String description;

	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Service(ServiceProvider serviceProvider, String serviceName, String description) {
		super();
		this.serviceProvider = serviceProvider;
		this.serviceName = serviceName;
		this.description = description;
	}

	public Long getServiceId() {
		return serviceId;
	}

	public ServiceProvider getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(ServiceProvider serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Service [serviceId=" + serviceId + ", serviceProvider=" + serviceProvider + ", serviceName="
				+ serviceName + ", description=" + description + "]";
	}

}
