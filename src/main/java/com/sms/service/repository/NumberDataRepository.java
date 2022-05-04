package com.sms.service.repository;

import com.sms.service.entity.NumberData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberDataRepository extends CrudRepository<NumberData, String> {

    NumberData findByToAndFrom(String to, String from);
}
