package com.prakritikishore.a2zEcomm.common;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse {
    private final Boolean success;
    private final String message;

    public String getTimestamp(){
        return LocalDateTime.now().toString();
    }
}
