package com.sms.service.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@Entity
@Table(name = "phone_number")
public class PhoneNumber {

    @Id
    private int id;
    @Column(name = "number")
    private String number;
    @Column(name = "account_id")
    private int accountId;
}
