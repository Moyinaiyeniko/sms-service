package com.sms.service.repository;

import com.sms.service.entity.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Integer> {

    @Query("select p from PhoneNumber p where p.number = :number and p.accountId = :accountId")
    PhoneNumber findNumber(@Param("number") String number, @Param("accountId") int accountId);



    }
