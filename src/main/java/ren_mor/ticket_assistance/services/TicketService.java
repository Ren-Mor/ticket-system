package ren_mor.ticket_assistance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ren_mor.ticket_assistance.entities.Ticket;
import ren_mor.ticket_assistance.enums.TicketStatus;
import ren_mor.ticket_assistance.enums.TicketType;
import ren_mor.ticket_assistance.exceptions.NotFoundException;
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

    public Ticket findById(Long id) {
        return ticketRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Ticket save(NewTicketDTO payload) {
        TicketType type = null;
        if (payload.TicketType() != null) {
            type = TicketType.valueOf(payload.TicketType());
        }
        Ticket ticket = new Ticket(
                payload.title(),
                payload.createdBy(),
                null, // assignedTo
                type,
                TicketStatus.OPEN,
                payload.description(),
                payload.attachment(),
                null // publicId
        );
        return ticketRepository.save(ticket);
    }

    public Ticket updateTicket(Long id, NewTicketDTO payload) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        if (payload.title() != null) ticket.setTitle(payload.title());
        if (payload.description() != null) ticket.setDescription(payload.description());
        if (payload.attachment() != null) ticket.setAttachment(payload.attachment());
        if (payload.TicketType() != null) {
            ticket.setType(TicketType.valueOf(payload.TicketType()));


    } return ticketRepository.save(ticket);
    }

    public void deleteTicket(Long id) {
        Ticket ticket = findById(id);
        ticketRepository.delete(ticket);
    }
}
