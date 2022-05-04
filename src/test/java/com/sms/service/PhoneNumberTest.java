package com.sms.service;

import com.sms.service.dto.InboundRequestDTO;
import com.sms.service.entity.Account;
import com.sms.service.entity.PhoneNumber;
import com.sms.service.repository.AccountRepository;
import com.sms.service.repository.PhoneNumberRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;



@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PhoneNumberTest {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PhoneNumberRepository phoneNumberRepository;

    @Test
    public void verifyUserAccount(){
        Account account = accountRepository.verifyUser("20S0KPNOIM", "azr1");
        Assertions.assertThat(account.getUsername()).isEqualTo("azr1");

    }

    @Test
    public void check_to_number_belongs_to_user(){
        PhoneNumber phoneNumber = phoneNumberRepository.findNumber("4924195509192",1);
        Assertions.assertThat(phoneNumber.getNumber()).isEqualTo("4924195509192");
    }
@Test
    public void check_to_field_not_empty(){
    InboundRequestDTO inboundRequestDTO = InboundRequestDTO.builder()
                    .to("4924195509192").build();
    Assertions.assertThat(inboundRequestDTO.getTo()).isNotEmpty();
    }

    @Test
    public void check_from_field_not_empty(){
        InboundRequestDTO inboundRequestDTO = InboundRequestDTO.builder()
                .from("1234567").build();
        Assertions.assertThat(inboundRequestDTO.getFrom()).isNotEmpty();
    }


}
