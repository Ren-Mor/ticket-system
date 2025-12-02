package ren_mor.ticket_assistance.payloads;

import ren_mor.ticket_assistance.enums.UserRole;

public record NewUserResponseDTO(
        Long id,
        String username,
        String email,
        UserRole role
) {}
