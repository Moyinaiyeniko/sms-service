package com.sms.service.service;

import com.sms.service.dto.InboundRequestDTO;
import com.sms.service.dto.OutboundRequestDTO;
import com.sms.service.dto.ResponseDTO;
import com.sms.service.entity.Account;
import com.sms.service.entity.PhoneNumber;
import com.sms.service.exception.CustomResponseEntity;
import com.sms.service.repository.AccountRepository;
import com.sms.service.repository.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PhoneNumberServiceImpl {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PhoneNumberRepository phoneNumberRepository;

    public Object inbound(String auth, String password, InboundRequestDTO inboundRequestDTO){
        ResponseDTO responseDTO = new ResponseDTO();
      try {

          Account account = accountRepository.verifyUser(auth, password);
          if (account == null) {
              responseDTO.setMessage("");
              responseDTO.setError("auth_id/password is incorrect");
              return new CustomResponseEntity(responseDTO, HttpStatus.FORBIDDEN);
          } else {
              PhoneNumber phoneNumber = phoneNumberRepository.findNumber(inboundRequestDTO.getTo(), account.getId());
              if (phoneNumber == null) {
                  responseDTO.setMessage("");
                  responseDTO.setError("to parameter not found");
                  return new CustomResponseEntity(responseDTO, HttpStatus.NOT_FOUND);
              }
          }
          responseDTO.setMessage("inbound sms ok");
          responseDTO.setError("");
          return new CustomResponseEntity(responseDTO, HttpStatus.OK);
      }
      catch (Exception ex){
          responseDTO.setMessage("unknown failure");
          responseDTO.setError("");
          return new CustomResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }


    public Object outbound(String auth, String password, OutboundRequestDTO outboundRequestDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            Account account = accountRepository.verifyUser(auth, password);
            if (account == null) {
                responseDTO.setMessage("");
                responseDTO.setError("auth_id/password is incorrect");
                return new CustomResponseEntity(responseDTO, HttpStatus.FORBIDDEN);
            } else {
                PhoneNumber phoneNumber = phoneNumberRepository.findNumber(outboundRequestDTO.getFrom(), account.getId());
                if (phoneNumber == null) {
                    responseDTO.setMessage("");
                    responseDTO.setError("from parameter not found");
                    return new CustomResponseEntity(responseDTO, HttpStatus.NOT_FOUND);
                }
            }
            responseDTO.setMessage("inbound sms ok");
            responseDTO.setError("");
            return new CustomResponseEntity(responseDTO, HttpStatus.OK);

        } catch (Exception ex) {
            responseDTO.setMessage("unknown failure");
            responseDTO.setError("");
            return new CustomResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
