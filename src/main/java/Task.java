public class Task {
    private boolean isDone;
    private String task;
    public Task(String task) {
        this.task = task;
        this.isDone = false;
    }
    public String toString() {
        return "[" + (isDone ? "X" : " ") + "] " + this.task;
    }
    public String getTask() {
        return this.task;
    }
    public void setDone(boolean done) {
        isDone = done;
    }
}
