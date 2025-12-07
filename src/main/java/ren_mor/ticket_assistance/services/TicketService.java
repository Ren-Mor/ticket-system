package ren_mor.ticket_assistance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ren_mor.ticket_assistance.entities.Ticket;
import ren_mor.ticket_assistance.payloads.NewTicketDTO;
import ren_mor.ticket_assistance.repositories.TicketRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> findAll() {
        List<Ticket> tickets = ticketRepository.findAll();
        List<NewTicketDTO> results = new ArrayList<>();
        for (Ticket ticket : tickets) {
            NewTicketDTO dto = new NewTicketDTO(
                    ticket.getTitle(),
                    ticket.getDescription(),
                    ticket.getCreatedBy(),
                    ticket.getAttachment(),
                    ticket.getType() != null ? ticket.getType().name() : null
            );
            results.add(dto);
        }
        return tickets;
    }
}
