package ren_mor.ticket_assistance.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class AdminRunner implements CommandLineRunner {

    @Autowired
    private AdminCreation adminCreation;
    @Override
    public void run(String... args) throws Exception {
        adminCreation.createAdminIfNotExists();
    }
}
