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

	@Column(name = "comment")
	private String comment;

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Feedback(Appointment appointment, int rating, String comment) {
		super();
		this.appointment = appointment;
		this.rating = rating;
		this.comment = comment;
	}

	public Long getFeedbackId() {
		return feedbackId;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", appointment=" + appointment + ", rating=" + rating
				+ ", comment=" + comment + "]";
	}

}
