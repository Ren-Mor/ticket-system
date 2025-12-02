package ren_mor.ticket_assistance.exceptions;

import java.util.List;

public class ValidationException extends RuntimeException {
    private List<String> errorMessages;
    public ValidationException(List<String> errorMessages) {
        super("Errore di autenticazione");
        this.errorMessages = errorMessages;
    }

    //Getter
    public List<String> getErrorMessages() {
        return errorMessages;
    }
}
