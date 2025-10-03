package AsciiAnything.task;

/**
 * Represents a Todo task.
 * A Todo is a simple task that only has a description and completion status.
 */
public class Todo extends Task {

    /**
     * Constructs a Todo task with the specified description.
     * The task is initially marked as not done.
     *
     * @param desc The description of the todo task.
     */
    public Todo(String desc) {
        super(desc);
    }

    /**
     * Constructs a Todo task with the specified description and completion status.
     *
     * @param desc The description of the todo task.
     * @param done The completion status of the task (true if done, false otherwise).
     */
    public Todo(String desc, boolean done) {
        super(desc, done);
    }

    /**
     * Returns a string representation of the Todo task,
     * prefixed with "[T]" to indicate its type.
     *
     * @return A string representation of the Todo task.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * Returns a string formatted for saving to storage.
     *
     * @return A save-friendly string representation of the Todo task.
     */
    @Override
    public String toSaveFormat() {
        return "T|" + super.toSaveFormat();
    }
}
