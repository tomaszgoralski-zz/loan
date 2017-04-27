package tech.valuestream.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class OrderDTO {

    private String email;
    private String amount;
    private String whenDate;
    private String message;

    public String getWhenDate() {
        return whenDate;
    }

    public String getEmail() {
        return email;
    }

    public String getAmount() {
        return amount;
    }

    public void getMessage(String message){
        this.message = message;
    }

    public void setMessage(String message){
        this.message = message;
    }

}
