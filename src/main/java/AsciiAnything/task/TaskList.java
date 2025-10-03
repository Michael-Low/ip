package AsciiAnything.task;

import java.util.ArrayList;
import AsciiAnything.exceptions.WrongFormatException;

public class TaskList {
    private ArrayList<Task> tasks;
    private final static String WRONG_FORMAT_MESSAGE = "Wrong format, dumbass!";

    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public Task get(int index) {
        return this.tasks.get(index);
    }

    public int size() {
        return this.tasks.size();
    }

    @Override
    public String toString() {
        String output = "";
        for(int i = 0; i < tasks.size(); i++) {
            output += (i + 1) + ": " + tasks.get(i).toString() + "\n";
        }
        return output;
    }

    public void addTodo(String taskDescription) throws WrongFormatException {
        Todo newTodo = new Todo(taskDescription);
        tasks.add(newTodo);
    }

    public void addDeadline(String taskDescription) throws WrongFormatException {
        int indexOfBy = taskDescription.indexOf("/by ");
        if(indexOfBy == -1) {
            throw new WrongFormatException();
        }
        String desc = taskDescription.substring(0, indexOfBy);
        String by = taskDescription.substring(indexOfBy + 4);
        Deadline newDeadline = new Deadline(desc, by);
        tasks.add(newDeadline);
    }

    public void addEvent(String taskDescription) throws WrongFormatException {
        int indexOfFrom = taskDescription.indexOf("/from ");
        int indexOfTo = taskDescription.indexOf("/to ");
        if(indexOfFrom == -1 || indexOfTo == -1 || indexOfFrom > indexOfTo) {
            throw new WrongFormatException();
        }
        String desc = taskDescription.substring(0, indexOfFrom);
        String from = taskDescription.substring(indexOfFrom + "/from ".length(), indexOfTo);
        String to = taskDescription.substring(indexOfTo + "/to ".length());
        Event newEvent = new Event(desc, from, to);
        tasks.add(newEvent);
    }

    public String searchTasks(String searchTerm) {
        StringBuilder returnString = new StringBuilder();
        for(int i = 0; i < tasks.size(); i++) {
            Task currentTask = tasks.get(i);
            if(currentTask.getDesc().toLowerCase().contains(searchTerm.toLowerCase())) {
                returnString.append(String.valueOf(i + 1)).append(": ").append(tasks.get(i).toString());
            }
        }
        return returnString.toString();
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
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Bruh, this task doesn't even exist.");
        }
    }
}
