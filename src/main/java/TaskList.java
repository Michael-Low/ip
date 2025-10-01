import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> tasks = new ArrayList<Task>();
    private final static String WRONG_FORMAT_MESSAGE = "Wrong format, dumbass!";

    @Override
    public String toString() {
        String output = "";
        for(int i = 0; i < tasks.size(); i++) {
            output += (i + 1) + ": " + tasks.get(i).toString() + "\n";
        }
        return output;
    }

    public void handleInput(String input) {
        try {
            if (input.toLowerCase().startsWith("deadline ")) {
                addDeadline(input.substring("deadline ".length()));
                return;
            }
            if (input.toLowerCase().startsWith("event ")) {
                addEvent(input.substring("event ".length()));
                return;
            }
            if (input.toLowerCase().startsWith("todo ")) {
                addTodo(input.substring("todo ".length()));
                return;
            }
            if(input.toLowerCase().startsWith("delete ")) {
                try {
                    deleteTask(Integer.parseInt(input.substring("delete ".length())));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input, give me the task's index.");
                }
                return;
            }
        } catch (WrongFormatException e) {
            System.out.println(WRONG_FORMAT_MESSAGE);
            return;
        }
        System.out.println(WRONG_FORMAT_MESSAGE);
    }

    public void addTodo(String taskDescription) throws WrongFormatException{
        System.out.println("Not another todo...");
        Todo newTodo = new Todo(taskDescription);
        tasks.add(newTodo);
        System.out.println("Todo added.");
    }

    public void addDeadline(String taskDescription) throws WrongFormatException{
        int indexOfBy = taskDescription.indexOf("/by ");
        if(indexOfBy == -1) {
            throw new WrongFormatException();
        }
        System.out.println("Not another deadline...");
        String desc = taskDescription.substring(0, indexOfBy);
        String by = taskDescription.substring(indexOfBy + 4);
        Deadline newDeadline = new Deadline(desc, by);
        tasks.add(newDeadline);
        System.out.println("Deadline added.");
    }

    public void addEvent(String taskDescription) throws WrongFormatException{
        int indexOfFrom = taskDescription.indexOf("/from ");
        int indexOfTo = taskDescription.indexOf("/to ");
        if(indexOfFrom == -1 || indexOfTo == -1 || indexOfFrom > indexOfTo) {
            throw new WrongFormatException();
        }
        System.out.println("Not another event...");
        String desc = taskDescription.substring(0, indexOfFrom);
        String from = taskDescription.substring(indexOfFrom + "/from ".length(), indexOfTo);
        String to = taskDescription.substring(indexOfTo + "/to ".length());
        Event newEvent = new Event(desc, from, to);
        tasks.add(newEvent);
    }

    public void printTasks() {
        System.out.print(this.toString());
    }

    public void markTask(int index) {
        tasks.get(index).setDone(true);
    }

    public void deleteTask(int index){
        try {
            tasks.remove(index - 1);
            System.out.println("Task deleted.");
            System.out.println("You now have " + tasks.size() + " tasks.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Bruh, this task doesn't even exist.");
        }
    }
}
