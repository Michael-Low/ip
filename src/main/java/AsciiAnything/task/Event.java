package AsciiAnything.task;

/**
 * Represents an Event task, which has a description, a start time ("from"),
 * an end time ("to"), and a completion status.
 */
public class Event extends Task {
    protected String from;
    protected String to;

    /**
     * Constructs an Event task with the specified description, start time, and end time.
     * The task is initially marked as not done.
     *
     * @param desc The description of the event.
     * @param from The start time of the event.
     * @param to   The end time of the event.
     */
    public Event(String desc, String from, String to) {
        super(desc);
        this.from = from;
        this.to = to;
    }

    /**
     * Constructs an Event task with the specified description, start time, end time,
     * and completion status.
     *
     * @param desc   The description of the event.
     * @param from   The start time of the event.
     * @param to     The end time of the event.
     * @param isDone The completion status of the task (true if done, false otherwise).
     */
    public Event(String desc, String from, String to, boolean isDone) {
        super(desc, isDone);
        this.from = from;
        this.to = to;
    }

    /**
     * Returns a string representation of the Event task,
     * including its type, status, description, and time range.
     *
     * @return A string representation of the Event task.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() +
                "(from: " + from +
                "to: " + to + ")";
    }

    /**
     * Returns a string formatted for saving to storage.
     *
     * @return A save-friendly string representation of the Event task.
     */
    @Override
    public String toSaveFormat() {
        return "E|" + super.toSaveFormat() + "|" + this.from + "|" + this.to;
    }
}