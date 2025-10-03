package AsciiAnything.task;

import java.util.ArrayList;
import AsciiAnything.exceptions.WrongFormatException;

/**
 * Represents a list of tasks that can be added, modified, searched, and removed.
 */
public class TaskList {
    private ArrayList<Task> tasks;
    private final static String WRONG_FORMAT_MESSAGE = "Wrong format, dumbass!";

    /**
     * Constructs an empty TaskList.
     */
    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    /**
     * Adds a task to the task list.
     *
     * @param task The task to add.
     */
    public void addTask(Task task) {
        this.tasks.add(task);
    }

    /**
     * Retrieves a task at the specified index.
     *
     * @param index Index of the task to retrieve.
     * @return The task at the given index.
     */
    public Task get(int index) {
        return this.tasks.get(index);
    }

    /**
     * Returns the number of tasks in the task list.
     *
     * @return The size of the task list.
     */
    public int size() {
        return this.tasks.size();
    }

    /**
     * Returns a string representation of the task list,
     * with each task numbered on a new line.
     *
     * @return The string representation of the task list.
     */
    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < tasks.size(); i++) {
            output += (i + 1) + ": " + tasks.get(i).toString() + "\n";
        }
        return output;
    }

    /**
     * Adds a Todo task to the list.
     *
     * @param taskDescription The description of the todo task.
     * @throws WrongFormatException If the format of the description is invalid.
     */
    public void addTodo(String taskDescription) throws WrongFormatException {
        Todo newTodo = new Todo(taskDescription);
        tasks.add(newTodo);
    }

    /**
     * Adds a Deadline task to the list. The format must include "/by ".
     *
     * @param taskDescription The full description including deadline using "/by ".
     * @throws WrongFormatException If the "/by " keyword is missing or the format is wrong.
     */
    public void addDeadline(String taskDescription) throws WrongFormatException {
        int indexOfBy = taskDescription.indexOf("/by ");
        if (indexOfBy == -1) {
            throw new WrongFormatException();
        }
        String desc = taskDescription.substring(0, indexOfBy);
        String by = taskDescription.substring(indexOfBy + 4);
        Deadline newDeadline = new Deadline(desc, by);
        tasks.add(newDeadline);
    }

    /**
     * Adds an Event task to the list. The format must include "/from " and "/to ".
     *
     * @param taskDescription The full description including time range using "/from " and "/to ".
     * @throws WrongFormatException If the time range is improperly formatted.
     */
    public void addEvent(String taskDescription) throws WrongFormatException {
        int indexOfFrom = taskDescription.indexOf("/from ");
        int indexOfTo = taskDescription.indexOf("/to ");
        if (indexOfFrom == -1 || indexOfTo == -1 || indexOfFrom > indexOfTo) {
            throw new WrongFormatException();
        }
        String desc = taskDescription.substring(0, indexOfFrom);
        String from = taskDescription.substring(indexOfFrom + "/from ".length(), indexOfTo);
        String to = taskDescription.substring(indexOfTo + "/to ".length());
        Event newEvent = new Event(desc, from, to);
        tasks.add(newEvent);
    }

    /**
     * Searches for tasks containing the given search term in their description.
     *
     * @param searchTerm The keyword or phrase to search for.
     * @return A string listing matching tasks with their index, or an empty string if none match.
     */
    public String searchTasks(String searchTerm) {
        StringBuilder returnString = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            Task currentTask = tasks.get(i);
            if (currentTask.getDesc().toLowerCase().contains(searchTerm.toLowerCase())) {
                returnString.append(String.valueOf(i + 1)).append(": ").append(tasks.get(i).toString());
            }
        }
        return returnString.toString();
    }

    /**
     * Prints all tasks in the task list to the console.
     */
    public void printTasks() {
        System.out.print(this.toString());
    }

    /**
     * Marks the task at the specified index as done.
     *
     * @param index The index of the task to mark as done.
     */
    public void markTask(int index) {
        tasks.get(index).setDone(true);
    }

    /**
     * Deletes the task at the given index.
     *
     * @param index The index of the task to delete.
     */
    public void deleteTask(int index) {
        try {
            tasks.remove(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Bruh, this task doesn't even exist.");
        }
    }
}
