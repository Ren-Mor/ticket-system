package ren_mor.ticket_assistance.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record NewUserDTO(
        @NotBlank (message = "Lo username non può essere vuoto")
        String username,
        @NotBlank (message = "La password è obbligatoria")
        @Size(min = 8, message = "La password deve essere lunga almeno 8 caratteri")
        String password,
        @NotBlank (message = "L'email non può essere vuota")
        String email
) {}
