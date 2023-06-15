package com.masai.utility;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "feedback_id")
	private Long feedbackId;

	@ManyToOne
	@JoinColumn(name = "appointment_id")
	private Appointment appointment;

	@Column(name = "rating")
	private int rating;

	@Column(name = "comments")
	private String comments;

	// Constructors, getters, and setters
}
