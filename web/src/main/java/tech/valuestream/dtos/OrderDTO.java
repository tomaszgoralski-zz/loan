package tech.valuestream.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;

public class OrderDTO {

    private String ip;
    private Double amount;
    private LocalDateTime whenDate;
    private String message;

    public LocalDateTime getWhenDate() {
        return whenDate;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Double getAmount() {
        return amount;
    }

    public String getMessage(){
       return this.message;
    }

    public void setMessage(String message){
        this.message = message;
    }

}
