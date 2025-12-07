package ren_mor.ticket_assistance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ren_mor.ticket_assistance.entities.User;
import ren_mor.ticket_assistance.enums.UserRole;
import ren_mor.ticket_assistance.exceptions.BadRequestException;
import ren_mor.ticket_assistance.payloads.NewUserDTO;
import ren_mor.ticket_assistance.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Page<User> findAll(int page, int size, String sortBy){
        return userRepository.findAll(PageRequest.of(page, size, Sort.by(sortBy)));
    }

    public User findById(Long userId){
        return userRepository.findById(userId).orElseThrow(() -> new BadRequestException("Utente non trovato"));
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User findByIdAndUpdate(Long userId, NewUserDTO payload){
        User found = this.findById(userId);
        if (!found.getEmail().equals(payload.email())) {
            User existing = userRepository.findByEmail(payload.email());
            if (existing != null) {
                throw new BadRequestException("Email già in uso");
            }
        }
        found.setEmail(payload.email());
        found.setUsername(payload.username());
        found.setPassword(passwordEncoder.encode(payload.password()));

        User updatedUser = userRepository.save(found);
        return updatedUser;
    }

    public User save(NewUserDTO payload) {
        User existing = userRepository.findByEmail(payload.email());
        if (existing != null) {
            throw new BadRequestException("L'email " + payload.email() + " è già in uso");
        }
        User newUser = new User(
                payload.username(),
                passwordEncoder.encode(payload.password()),
                payload.email(),
                UserRole.USER
        );
        return userRepository.save(newUser);
    }

    public void delete(Long userId) {
        User user = findById(userId);
        userRepository.delete(user);
    }
}
