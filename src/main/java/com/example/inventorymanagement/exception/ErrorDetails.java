package com.example.inventorymanagement.exception;

import java.time.LocalDate;

public class ErrorDetails {
    private String errorDetails;
    private String details;
    private LocalDate date;

    public ErrorDetails(String errorDetails, String details, LocalDate date) {
        this.errorDetails = errorDetails;
        this.details = details;
        this.date = date;
    }

    public String getErrorDetails() {
        return errorDetails;
    }

    public String getDetails() {
        return details;
    }

    public LocalDate getDate() {
        return date;
    }

}
