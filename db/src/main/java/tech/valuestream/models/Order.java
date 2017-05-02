package tech.valuestream.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "SUBMISSION")
public class Order {

    public Order(Double amount, LocalDateTime when, String ip) {
        this.amount = amount;
        this.when = when;
        this.ip = ip;
    }

    public Order() {
    }

    public final static String LOW_RISK = "low";
    public final static String HIGH_RISK = "high";
    public final static String ACCEPTED = "accepted";
    public final static String REJECTED = "rejected";
    public final static Double MAX_AMOUNT = 10000.00;

    @Id
    @GeneratedValue
    private Long id;
    private Double amount;
    private LocalDateTime when;
    private String ip;
    private String risk;
    private String status;

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
        return when;
    }

    public void setWhenDate(LocalDateTime whenDate) {
        this.when = whenDate;
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

    public boolean isLowRisk() {
        return LOW_RISK.equals(this.risk);
    }

    public void resolveStatus() {
        this.status = isLowRisk() ? ACCEPTED : REJECTED;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Order: Id-" + getId() + ", amount-" + getAmount() + ", when-" + getWhenDate() + ", risk-" + getRisk() + ", status-" + getStatus();
    }
}
