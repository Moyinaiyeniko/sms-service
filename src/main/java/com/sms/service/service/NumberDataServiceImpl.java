package com.sms.service.service;

import com.sms.service.repository.NumberDataRepository;
import com.sms.service.dto.ResponseDTO;
import com.sms.service.entity.NumberData;
import com.sms.service.exception.CustomResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class NumberDataServiceImpl {

    @Autowired
    NumberDataRepository numberDataRepository;


    public void saveData(String to, String from){
        NumberData numberData = new NumberData(
                to,from);
        numberDataRepository.save(numberData);
    }

    public Object findData(String to, String from){
        ResponseDTO responseDTO = new ResponseDTO();
        NumberData numberData = numberDataRepository.findByToAndFrom(to, from);
        if(numberData!=null){
            responseDTO.setMessage("");
            responseDTO.setError("sms from" + from + " to" + to + " blocked by STOP request");
            return new CustomResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
        }

    return null;
    }
}
