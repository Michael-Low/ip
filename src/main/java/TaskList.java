import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> tasks = new ArrayList<Task>();

    @Override
    public String toString() {
        String output = "";
        for(int i = 0; i < tasks.size(); i++) {
            output += (i + 1) + ": " + tasks.get(i).toString() + "\n";
        }
        return output;
    }
    public void addTask(String taskDescription) {
        Task task = new Task(taskDescription);
        tasks.add(task);
    }
    public void printTasks() {
        System.out.println(this.toString());
    }

    public void markTask(int index) {
        tasks.get(index).setDone(true);
    }
}
