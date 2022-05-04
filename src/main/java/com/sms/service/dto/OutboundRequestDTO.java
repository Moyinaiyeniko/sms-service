package com.sms.service.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
public class OutboundRequestDTO {
    //@NotEmpty(message = "from field cannot be empty")
    @Size(min = 6, max = 16, message
            = "Field length should be between 6 and 16")
    private String from;

    @NotEmpty(message = "to field cannot be empty")
    @Size(min = 6, max = 16, message
            = "Field length should be between 6 and 16")
    private String to;

    @NotEmpty(message = "text field cannot be empty")
    @Size(min = 1, max = 120, message
            = "Field length should be between 1 and 120")
    private String text;
}
