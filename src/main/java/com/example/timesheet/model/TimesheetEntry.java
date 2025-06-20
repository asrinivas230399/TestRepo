package com.example.timesheet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Represents a single entry in a user's timesheet.
 * Each entry records the number of hours worked by a user on a specific date.
 */
@Entity
public class TimesheetEntry {

    /**
     * Unique identifier for the timesheet entry.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * Identifier of the user who made this timesheet entry.
     */
    private Long userId;
    
    /**
     * The date for which the timesheet entry is recorded.
     */
    private LocalDate date;
    
    /**
     * Number of hours worked by the user on the given date.
     */
    private int hoursWorked;

    /**
     * Gets the unique identifier for this timesheet entry.
     * @return the id of the timesheet entry
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier for this timesheet entry.
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the user ID associated with this timesheet entry.
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Sets the user ID for this timesheet entry.
     * @param userId the user ID to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Gets the date of this timesheet entry.
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets the date for this timesheet entry.
     * @param date the date to set
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Gets the number of hours worked for this entry.
     * @return the hours worked
     */
    public int getHoursWorked() {
        return hoursWorked;
    }

    /**
     * Sets the number of hours worked for this entry.
     * @param hoursWorked the hours worked to set
     */
    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}
