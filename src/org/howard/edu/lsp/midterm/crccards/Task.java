package org.howard.edu.lsp.midterm.crccards;

/**
 * Represents a single task with an identifier, description, and workflow status.
 * Responsibilities include storing task information, updating status, and exposing details.
 *
 * @author Anthony Tucker
 */
public class Task {

    private static final String STATUS_OPEN = "OPEN";
    private static final String STATUS_IN_PROGRESS = "IN_PROGRESS";
    private static final String STATUS_COMPLETE = "COMPLETE";
    private static final String STATUS_UNKNOWN = "UNKNOWN";

    private final String taskId;
    private final String description;
    private String status;

    /**
     * Constructs a task with the given identifier and description.
     * The initial status is {@code OPEN}.
     *
     * @param taskId      the unique identifier for this task
     * @param description a human-readable description of the work
     */
    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = STATUS_OPEN;
    }

    /**
     * Returns this task's identifier.
     *
     * @return the task ID
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * Returns the task description.
     *
     * @return the description text
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the current status (e.g., OPEN, IN_PROGRESS, COMPLETE, or UNKNOWN).
     *
     * @return the status string
     */
    public String getStatus() {
        return status;
    }

    /**
     * Updates the task status if {@code status} is one of OPEN, IN_PROGRESS, or COMPLETE
     * (case-sensitive); otherwise sets the status to UNKNOWN.
     *
     * @param status the new status value
     */
    public void setStatus(String status) {
        if (STATUS_OPEN.equals(status)
                || STATUS_IN_PROGRESS.equals(status)
                || STATUS_COMPLETE.equals(status)) {
            this.status = status;
        } else {
            this.status = STATUS_UNKNOWN;
        }
    }

    /**
     * Returns a string in the form {@code taskId description [status]}.
     *
     * @return formatted representation of this task
     */
    @Override
    public String toString() {
        return taskId + " " + description + " [" + status + "]";
    }
}
