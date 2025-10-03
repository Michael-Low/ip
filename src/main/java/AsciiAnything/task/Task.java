package AsciiAnything.task;

/**
 * Represents a generic task with a description and completion status.
 * This is the base class for more specific task types such as {@code Todo},
 * {@code Deadline}, and {@code Event}.
 */
public class Task {
    protected boolean isDone;
    protected String desc;

    /**
     * Constructs a new Task with the given description.
     * The task is initially marked as not done.
     *
     * @param desc The description of the task.
     */
    public Task(String desc) {
        this.desc = desc;
        this.isDone = false;
    }

    /**
     * Constructs a new Task with the given description and completion status.
     *
     * @param desc   The description of the task.
     * @param isDone The completion status of the task (true if done, false otherwise).
     */
    public Task(String desc, boolean isDone) {
        this.desc = desc;
        this.isDone = isDone;
    }

    /**
     * Returns a string representation of the task, including
     * its completion status and description.
     *
     * @return A string representation of the task.
     */
    @Override
    public String toString() {
        return "[" + (isDone ? "X" : " ") + "] " + this.desc;
    }

    /**
     * Returns the description of the task.
     *
     * @return The task's description.
     */
    public String getDesc() {
        return this.desc;
    }

    /**
     * Marks the task as done or not done.
     *
     * @param done {@code true} to mark the task as done, {@code false} to mark it as not done.
     */
    public void setDone(boolean done) {
        isDone = done;
    }

    /**
     * Returns a string formatted for saving the task to a file.
     *
     * @return A save-friendly string representation of the task.
     */
    public String toSaveFormat() {
        return (this.isDone ? "1" : "0") + "|" + this.desc;
    }
}