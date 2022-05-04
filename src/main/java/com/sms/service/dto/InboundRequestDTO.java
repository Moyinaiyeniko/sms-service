package com.sms.service.dto;

import lombok.Builder;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@Data
@Builder
//@Cacheable(cacheNames="pair", condition = "#root.targetClass.text==STOP")

public class InboundRequestDTO {
    private final Logger LOG = LoggerFactory.getLogger(getClass());
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
    public String text;
}
