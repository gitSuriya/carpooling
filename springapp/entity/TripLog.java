package com.examly.springapp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TripLog {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY);
    private Long id;
    
    private Long tripId;
    private Long driverId;
    private Long passengerId;
    private String source;
    private String destination;
    private String routeTaken;
    private String locationCoordinates;
    private String conversationLogs;
    private LocalDateTime tripStartTime;
    private LocalDateTime tripEndTime;
    private Double fare;
    private String paymentStatus;
    private String route;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getRouteTaken() {
        return routeTaken;
    }

    public void setRouteTaken(String routeTaken) {
        this.routeTaken = routeTaken;
    }

    public String getLocationCoordinates() {
        return locationCoordinates;
    }

    public void setLocationCoordinates(String locationCoordinates) {
        this.locationCoordinates = locationCoordinates;
    }

    public String getConversationLogs() {
        return conversationLogs;
    }

    public void setConversationLogs(String conversationLogs) {
        this.conversationLogs = conversationLogs;
    }

    public LocalDateTime getTripStartTime() {
        return tripStartTime;
    }

    public void setTripStartTime(LocalDateTime tripStartTime) {
        this.tripStartTime = tripStartTime;
    }

    public LocalDateTime getTripEndTime() {
        return tripEndTime;
    }

    public void setTripEndTime(LocalDateTime tripEndTime) {
        this.tripEndTime = tripEndTime;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getroute()
    {
        return route;
    }
    public void setroute(String route){
        this.route=route;
    }
}

  