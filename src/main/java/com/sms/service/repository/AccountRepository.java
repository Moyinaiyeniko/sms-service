package com.sms.service.repository;

import com.sms.service.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<Account, Integer> {

        @Query("select p from Account p where p.username = :username and p.authId = :authId" )
        Account verifyUser(@Param("authId") String authId, @Param("username") String username);


    }
