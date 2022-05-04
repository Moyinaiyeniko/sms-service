package com.sms.service.dto;

import lombok.Builder;
import lombok.Data;

@Data

public class ResponseDTO {

    private String message;

    private String error;

    public ResponseDTO() {

    }

    public ResponseDTO(String message, String error) {
        this.message = message;
        this.error = error;
    }
}
