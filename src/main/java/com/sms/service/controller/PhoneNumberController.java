package com.sms.service.controller;

import com.sms.service.exception.CustomException;
import com.sms.service.service.NumberDataServiceImpl;
import com.sms.service.dto.InboundRequestDTO;
import com.sms.service.dto.OutboundRequestDTO;
import com.sms.service.service.PhoneNumberServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@RestController
public class PhoneNumberController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());
    @Autowired
    PhoneNumberServiceImpl phoneNumberService;
    @Autowired
    NumberDataServiceImpl numberDataService;

    @PostMapping("/inbound/sms/")
    public Object inbound(@Valid @RequestBody InboundRequestDTO inboundRequestDTO, BindingResult result, @RequestHeader("auth_id") String authId, @RequestHeader("password") String password){

       if(result.hasErrors()){
           throw new CustomException(result.getFieldError().getDefaultMessage(),result.getFieldError().getField() + " is invalid", HttpStatus.BAD_REQUEST);
       }
       String text = inboundRequestDTO.getText();
       if(text.equals("STOP") || text.equals("STOP\n") || text.equals("STOP\r")|| text.equals("STOP\r\n")){
           numberDataService.saveData(inboundRequestDTO.getTo(),inboundRequestDTO.getFrom());
       }
        return phoneNumberService.inbound(authId,password,
                inboundRequestDTO);

    }

    @PostMapping("/outbound/sms/")
    public Object outbound(@Valid @RequestBody OutboundRequestDTO outboundRequestDTO, BindingResult result, @RequestHeader("auth_id") String authId, @RequestHeader("password") String password){

        if(result.hasErrors()){
            throw new CustomException(result.getFieldError().getDefaultMessage(),result.getFieldError().getField() + " is invalid", HttpStatus.BAD_REQUEST);
        }
        numberDataService.findData(outboundRequestDTO.getTo(),outboundRequestDTO.getFrom());
        return phoneNumberService.outbound(authId,password,
                outboundRequestDTO);

    }
}
