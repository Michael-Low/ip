package AsciiAnything.command;

import AsciiAnything.exceptions.EmptyInputException;
import AsciiAnything.exceptions.WrongFormatException;
import AsciiAnything.storage.Storage;
import AsciiAnything.task.TaskList;
import AsciiAnything.ui.Ui;

public class AddCommand implements Command {
    String taskType;
    String taskString;

    public AddCommand(String taskType,String taskString) {
        this.taskType = taskType;
        this.taskString = taskString;
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(TaskList tasks, Storage storage, Ui ui) throws Exception {
        System.out.println("Adding task: " + taskType);
        if (taskString.isEmpty()) {
            throw new EmptyInputException();
        }
        switch(this.taskType) {
            case "todo":
                tasks.addTodo(taskString);
                break;
            case "deadline":
                tasks.addDeadline(taskString);
                break;
            case "event":
                tasks.addEvent(taskString);
        }
        storage.saveToFile(tasks);
        System.out.println("Added task.");
    }
}
