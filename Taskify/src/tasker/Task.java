package tasker;

public class Task {
    private String title;
    private String description;
    private int priority;
    private String deadline;

    // Constructor
    public Task(String title, String description, int priority, String deadline) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.deadline = deadline;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public String getDeadline() {
        return deadline;
    }

    // ToString (For printing task details)
    @Override
    public String toString() {
        return "Task: " + title + " | Priority: " + priority + " | Deadline: " + deadline +
                "\nDescription: " + description;
    }
}
