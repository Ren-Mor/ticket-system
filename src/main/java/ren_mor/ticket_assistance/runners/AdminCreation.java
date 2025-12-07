package ren_mor.ticket_assistance.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ren_mor.ticket_assistance.entities.User;
import ren_mor.ticket_assistance.enums.UserRole;
import ren_mor.ticket_assistance.repositories.UserRepository;

@Component
public class AdminCreation {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private final String adminEmail = "administrator@hotmail.it";

    public void createAdminIfNotExists() {
        if (userRepository.findByEmail(adminEmail) == null) {
            User admin = new User();
            admin.setEmail(adminEmail);
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole(UserRole.ADMIN);

            userRepository.save(admin);
            System.out.println("Admin creato con successo (email: " + adminEmail + ")");
        } else {
            System.out.println("L'admin esiste già nel database.");
        }
    }
}
