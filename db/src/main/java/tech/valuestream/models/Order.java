package tech.valuestream.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Order {

    public final static String LOW_RISK = "low";
    public final static String HIGH_RISK = "high";
    public final static Double MAX_AMOUNT = 10000.00;

    @Id
    @GeneratedValue
    private Long id;
    private Double amount;
    private LocalDateTime whenDate;
    private String email;
    private String ip;
    private String risk;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getWhenDate() {
        return whenDate;
    }

    public void setWhenDate(LocalDateTime whenDate) {
        this.whenDate = whenDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }
}
