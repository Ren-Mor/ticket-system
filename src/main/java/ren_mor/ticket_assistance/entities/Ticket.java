package ren_mor.ticket_assistance.entities;

import ren_mor.ticket_assistance.enums.TicketStatus;
import ren_mor.ticket_assistance.enums.TicketType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String createdBy;
    private String assignedTo;
    @Enumerated(EnumType.STRING)
    private TicketType type;
    @Enumerated(EnumType.STRING)
    private TicketStatus status;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private String assignedDate;
    private String closedDate;
    private String description;
    private String attachment;
    private String publicId;

    public Ticket() {}

    public Ticket(String title,String createdBy, String assignedTo, TicketType type, TicketStatus status, String description, String attachment, String publicId) {
        this.title=title;
        this.createdBy = createdBy;
        this.assignedTo = assignedTo;
        this.type = type;
        this.status = status;
        this.description = description;
        this.attachment = attachment;
        this.publicId = publicId;
    }

    // Getter
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public TicketType getType() {
        return type;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getAssignedDate() {
        return assignedDate;
    }

    public String getClosedDate() {
        return closedDate;
    }

    public String getDescription() {
        return description;
    }

    public String getAttachment() {
        return attachment;
    }

    public String getPublicId() {
        return publicId;
    }

    // Setter


    public void setTitle(String title) {
        this.title = title;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setAssignedDate(String assignedDate) {
        this.assignedDate = assignedDate;
    }

    public void setClosedDate(String closedDate) {
        this.closedDate = closedDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }
}