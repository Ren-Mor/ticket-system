package ren_mor.ticket_assistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ren_mor.ticket_assistance.entities.Ticket;


@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Ticket findById(String PublicId);
}
