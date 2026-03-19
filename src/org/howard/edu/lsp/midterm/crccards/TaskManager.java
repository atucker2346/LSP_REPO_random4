package org.howard.edu.lsp.midterm.crccards;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages a collection of {@link Task} objects: storage, lookup by ID,
 * duplicate prevention, and filtering by status.
 *
 * @author Anthony Tucker
 */
public class TaskManager {

    private final Map<String, Task> tasksById;

    /**
     * Creates an empty task manager using an internal map keyed by task ID.
     */
    public TaskManager() {
        this.tasksById = new LinkedHashMap<>();
    }

    /**
     * Adds a task to this manager. The task ID must not already exist.
     *
     * @param task the task to store
     * @throws IllegalArgumentException if a task with the same ID is already stored
     */
    public void addTask(Task task) {
        String id = task.getTaskId();
        if (tasksById.containsKey(id)) {
            throw new IllegalArgumentException("Duplicate task ID: " + id);
        }
        tasksById.put(id, task);
    }

    /**
     * Looks up a task by its identifier.
     *
     * @param taskId the task ID to find
     * @return the matching task, or {@code null} if none exists
     */
    public Task findTask(String taskId) {
        return tasksById.get(taskId);
    }

    /**
     * Returns all tasks whose {@link Task#getStatus() status} equals the given value
     * (comparison is case-sensitive, consistent with {@link Task}).
     *
     * @param status the status filter (e.g., OPEN)
     * @return a list of matching tasks; may be empty but not null
     */
    public List<Task> getTasksByStatus(String status) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasksById.values()) {
            if (task.getStatus().equals(status)) {
                result.add(task);
            }
        }
        return result;
    }
}
