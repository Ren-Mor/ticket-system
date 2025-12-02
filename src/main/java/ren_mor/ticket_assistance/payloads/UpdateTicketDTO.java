package ren_mor.ticket_assistance.payloads;

public record UpdateTicketDTO(
        String TicketStatus,
        String assignedTo
) {
}
