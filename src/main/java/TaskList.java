import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> tasks = new ArrayList<Task>();
    private final static String WRONG_FORMAT_MESSAGE = "Your format is wrong, dumbass!";

    @Override
    public String toString() {
        String output = "";
        for(int i = 0; i < tasks.size(); i++) {
            output += (i + 1) + ": " + tasks.get(i).toString() + "\n";
        }
        return output;
    }

    public void handleInput(String input) {
        if(input.startsWith("Deadline ")) {
            addDeadline(input.substring("Deadline ".length()));
            return;
        }
        if(input.startsWith("Event ")) {
            addEvent(input.substring("Event ".length()));
            return;
        }
        if(input.startsWith("Todo ")) {
            addTodo(input.substring("Todo ".length()));
            return;
        }
        System.out.println(WRONG_FORMAT_MESSAGE);
    }

    public void addTodo(String taskDescription) {
        System.out.println("not another Todo...");
        Todo newTodo = new Todo(taskDescription);
        tasks.add(newTodo);
        System.out.println("Todo added.");
    }

    public void addDeadline(String taskDescription) {
        int index_of_by = taskDescription.indexOf("/by ");
        if(index_of_by == -1) {
            System.out.println(WRONG_FORMAT_MESSAGE);
            return;
        }
        System.out.println("not another Deadline...");
        String desc = taskDescription.substring(0, index_of_by);
        String by = taskDescription.substring(index_of_by + 3);
        Deadline newDeadline = new Deadline(desc, by);
        tasks.add(newDeadline);
        System.out.println("Deadline added.");
    }

    public void addEvent(String taskDescription) {
        int index_of_from = taskDescription.indexOf("/from ");
        int index_of_to = taskDescription.indexOf("/to ");
        if(index_of_from == -1 || index_of_to == -1 || index_of_from > index_of_to) {
            System.out.println(WRONG_FORMAT_MESSAGE);
            return;
        }
        System.out.println("not another Event...");
        String desc = taskDescription.substring(0, index_of_from);
        String from = taskDescription.substring(index_of_from + 5, index_of_to);
        String to = taskDescription.substring(index_of_to + 3);
        Event newEvent = new Event(desc, from, to);
        tasks.add(newEvent);
    }

    public void printTasks() {
        System.out.print(this.toString());
    }

    public void markTask(int index) {
        tasks.get(index).setDone(true);
    }
}
