public class Task {
    protected boolean isDone;
    protected String desc;

    public Task(String desc) {
        this.desc = desc;
        this.isDone = false;
    }

    @Override
    public String toString() {
        return "[" + (isDone ? "X" : " ") + "] " + this.desc;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
