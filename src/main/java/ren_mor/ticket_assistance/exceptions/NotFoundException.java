package ren_mor.ticket_assistance.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Long id) {super("L'elemento con id " + id + "non è stato trovato");
    }
    public NotFoundException(Integer id) {
        super ("L'elemento con id " + id + " non è stato trovato");
    }
}
