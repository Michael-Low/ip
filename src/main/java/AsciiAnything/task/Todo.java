package AsciiAnything.task;

public class Todo extends Task {
    public Todo(String desc) {
        super(desc);
    }

    public Todo(String desc, boolean done) {
        super(desc, done);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public String toSaveFormat() {
        return "T|" + super.toSaveFormat();
    }
}
