package edu.utn.calls.callsender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CallSenderApplication implements CommandLineRunner {

    @Autowired
    CallService callService;

    public static void main(String[] args) {
        SpringApplication.run(CallSenderApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        this.callService.sendCalls();
    }
}
