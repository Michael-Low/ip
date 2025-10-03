public class Event extends Task{
    protected String from;
    protected String to;

    public Event(String desc, String from, String to) {
        super(desc);
        this.from = from;
        this.to = to;
    }

    public Event(String desc, String from, String to, boolean isDone) {
        super(desc, isDone);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() +
                "(from: " + from +
                "to: " + to + ")";
    }

    @Override
    public String toSaveFormat() {
        return "E|" + super.toSaveFormat() + "|" + this.from + "|" + this.to;
    }
}
