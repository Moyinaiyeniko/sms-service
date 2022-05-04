package com.sms.service.entity;

import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.io.Serializable;

@RedisHash(value = "NumberData", timeToLive = 14400)
public class NumberData implements Serializable {
@Id
private String  id;

    private String to;

    private String from;

    public NumberData() {
    }

    public NumberData(String to, String from) {
        this.to = to;
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @Override
    public String toString() {
        return "NumberData{" +
                "to='" + to + '\'' +
                ", from='" + from + '\'' +
                '}';
    }
}
