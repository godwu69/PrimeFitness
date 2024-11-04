package com.example.userservice.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int feedbackId;

    private int accountId;

    private LocalDateTime feedbackDate = LocalDateTime.now();

    private String comments;

    @Column(nullable = false)
    private Integer rating;

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public LocalDateTime getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(LocalDateTime feedbackDate) {
        this.feedbackDate = feedbackDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "feedbackId=" + feedbackId +
                ", accountId=" + accountId +
                ", feedbackDate=" + feedbackDate +
                ", comments='" + comments + '\'' +
                ", rating=" + rating +
                '}';
    }

    public Feedback(int feedbackId, int accountId, LocalDateTime feedbackDate, String comments, Integer rating) {
        this.feedbackId = feedbackId;
        this.accountId = accountId;
        this.feedbackDate = feedbackDate;
        this.comments = comments;
        this.rating = rating;
    }

    public Feedback() {}
}
