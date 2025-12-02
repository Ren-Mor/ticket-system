package ren_mor.ticket_assistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ren_mor.ticket_assistance.entities.User;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{
    User findByEmail(String email);
}
