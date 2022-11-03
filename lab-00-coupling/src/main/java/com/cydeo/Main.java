package com.cydeo;
import com.cydeo.loosely.Balance;
import com.cydeo.loosely.BalanceManager;
import com.cydeo.tightly.BalanceService;

import java.math.BigDecimal;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        UUID user = UUID.randomUUID();



        Balance customerBalance = new CustomerBalance(user, BigDecimal.ZERO);
        Balance giftCardBalance = new GiftCardBalance(user, BigDecimal.ZERO);


        customerBalance.addBalance(new BigDecimal(150));
        giftCardBalance.addBalance(new BigDecimal(120));

        /*
        BalanceService balanceService =
                new BalanceService(customerBalance, giftCardBalance);
         */


        //System.out.println(balanceService.checkoutFromCustomerBalance(new BigDecimal(80)));
        //System.out.println(balanceService.checkoutFromGiftBalance(new BigDecimal(80)));



        BalanceManager balanceManager = new BalanceManager();
        boolean checkout = balanceManager.checkout(customerBalance, new BigDecimal(80));
        boolean checkout1 = balanceManager.checkout(giftCardBalance, new BigDecimal(130));
        System.out.println(checkout);
        System.out.println(checkout1);

    }

}
