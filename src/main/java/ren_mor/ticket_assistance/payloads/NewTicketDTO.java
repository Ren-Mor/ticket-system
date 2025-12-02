package ren_mor.ticket_assistance.payloads;

public record NewTicketDTO(
        String title,
        String description,
        String createdBy,
        String attachment,
        String TicketType
) {}
