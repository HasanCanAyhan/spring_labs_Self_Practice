package com.cydeo.account;

import com.cydeo.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter


@AllArgsConstructor
public class Saving {



    private Currency currency;
    private BigDecimal amount;
    private UUID accountId;

    public void initialize(){
        System.out.println("savings account " + "currency: "+ currency.getCode() + "amount: " + amount + "accountId" + accountId);
    }
}
