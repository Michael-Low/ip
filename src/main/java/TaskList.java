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
        int indexOfBy = taskDescription.indexOf("/by ");
        if(indexOfBy == -1) {
            System.out.println(WRONG_FORMAT_MESSAGE);
            return;
        }
        System.out.println("not another Deadline...");
        String desc = taskDescription.substring(0, indexOfBy);
        String by = taskDescription.substring(indexOfBy + 3);
        Deadline newDeadline = new Deadline(desc, by);
        tasks.add(newDeadline);
        System.out.println("Deadline added.");
    }

    public void addEvent(String taskDescription) {
        int indexOfFrom = taskDescription.indexOf("/from ");
        int indexOfTo = taskDescription.indexOf("/to ");
        if(indexOfFrom == -1 || indexOfTo == -1 || indexOfFrom > indexOfTo) {
            System.out.println(WRONG_FORMAT_MESSAGE);
            return;
        }
        System.out.println("not another Event...");
        String desc = taskDescription.substring(0, indexOfFrom);
        String from = taskDescription.substring(indexOfFrom + 5, indexOfTo);
        String to = taskDescription.substring(indexOfTo + 3);
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
