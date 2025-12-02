package ren_mor.ticket_assistance.payloads;

import jakarta.validation.constraints.NotEmpty;

public record LoginDTO(
        @NotEmpty(message = "username obbligatorio")
        String username,
        @NotEmpty(message = "password obbligatoria")
        String password
) {
}
