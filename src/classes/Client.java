package classes;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Client {
    private long id;
    private String fullName;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private BigDecimal money;

    public Client(long id, String fullName, LocalDate dateOfBirth, String phoneNumber, BigDecimal money) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.money = money;



    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return String.format("""
                Client id : %s
                Client full name : %s
                Client date of birth : %s
                Client phone number : %s
                Client money : %s
                """,id,fullName,dateOfBirth,phoneNumber,money);
    }
}

