package com.sms.service.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "account")
public class Account {
@Id
    private int id;

    @Column(name = "auth_id")
    private String authId;
    @Column(name = "username")
    private String username;
}
