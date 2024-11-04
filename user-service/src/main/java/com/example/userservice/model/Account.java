package com.example.userservice.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;

    @Column(unique = true, nullable = false)
    private String email;

    private String phone;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate dob;

    private String address;

    @Enumerated(EnumType.STRING)
    private Role role = Role.Member;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt;

    private LocalDateTime lastCheckedIn = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private Status status = Status.Active;

    public enum Gender {
        M, F
    }

    public enum Role {
        Member, Trainer, Admin
    }

    public enum Status {
        Active, Inactive
    }

    public int getAccountId() {
        return accountId;
    }

    public void setUserId(int accountId) {
        this.accountId = accountId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getLastCheckedIn() {
        return lastCheckedIn;
    }

    public void setLastCheckedIn(LocalDateTime lastCheckedIn) {
        this.lastCheckedIn = lastCheckedIn;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                ", role=" + role +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", lastCheckedIn=" + lastCheckedIn +
                ", status=" + status +
                '}';
    }

    public Account(int accountId, String email, String phone, String password, String name, Gender gender, LocalDate dob, String address, Role role, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime lastCheckedIn, Status status) {
        this.accountId = accountId;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.lastCheckedIn = lastCheckedIn;
        this.status = status;
    }

    public Account() {}
}
