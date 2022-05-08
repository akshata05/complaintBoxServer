package com.example.ComplaintSytem.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
@Data
public class NotfoundException {
    private String message;
    private HttpStatus httpStatus;
    private ZonedDateTime zonedDateTime;

    public NotfoundException(String message, HttpStatus httpStatus, ZonedDateTime zonedDateTime) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.zonedDateTime = zonedDateTime;
    }
}
