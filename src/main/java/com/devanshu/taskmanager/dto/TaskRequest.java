package com.devanshu.taskmanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class TaskRequest {

    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    @NotBlank(message = "Status is required")
@Pattern(
        regexp = "PENDING|IN_PROGRESS|COMPLETED",
        message = "Status must be PENDING, IN_PROGRESS or COMPLETED"
)
private String status;

    @NotBlank(message = "Priority is required")
@Pattern(
        regexp = "LOW|MEDIUM|HIGH",
        message = "Priority must be LOW, MEDIUM or HIGH"
)
private String priority;

    private String dueDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}