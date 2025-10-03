package AsciiAnything.task;

/**
 * Represents a Deadline task, which includes a description,
 * a due date/time ("by"), and a completion status.
 */
public class Deadline extends Task {
    protected String by = "";

    /**
     * Constructs a Deadline task with the given description and due date/time.
     * The task is initially marked as not done.
     *
     * @param description The description of the deadline task.
     * @param by          The due date or time for the task.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Constructs a Deadline task with the given description, due date/time,
     * and completion status.
     *
     * @param description The description of the deadline task.
     * @param by          The due date or time for the task.
     * @param isDone      The completion status of the task (true if done, false otherwise).
     */
    public Deadline(String description, String by, boolean isDone) {
        super(description, isDone);
        this.by = by;
    }

    /**
     * Returns a string representation of the Deadline task,
     * including its type, completion status, description, and due date/time.
     *
     * @return A string representation of the Deadline task.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() +
                "(by: " + by + ")";
    }

    /**
     * Returns a string formatted for saving to storage.
     * Format: D|&lt;done&gt;|&lt;description&gt;|&lt;by&gt;
     *
     * @return A save-friendly string representation of the Deadline task.
     */
    @Override
    public String toSaveFormat() {
        return "D|" + super.toSaveFormat() + "|" + this.by;
    }
}