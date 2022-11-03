package com.cydeo;

import com.cydeo.account.Current;
import com.cydeo.account.Saving;
import com.cydeo.config.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        // That is @Bean solution wiring Solution

        // You can also use @AutoWired which is inside spring_lap

        ApplicationContext container = new AnnotationConfigApplicationContext(Config.class);

        Saving saving = container.getBean(Saving.class);
        Current current = container.getBean(Current.class);

        saving.initialize();
        current.initialize();


    }

}
