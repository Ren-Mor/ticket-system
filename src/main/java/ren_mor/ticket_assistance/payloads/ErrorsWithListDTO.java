package ren_mor.ticket_assistance.payloads;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorsWithListDTO(String message, LocalDateTime timesstamp, List<String> errorsList) {
}
