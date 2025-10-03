package AsciiAnything.command;

import AsciiAnything.exceptions.EmptyInputException;
import AsciiAnything.storage.Storage;
import AsciiAnything.task.TaskList;
import AsciiAnything.ui.Ui;

public class FindCommand implements Command{
    private final String searchString;

    public FindCommand(String searchString) {
        this.searchString = searchString;
    }

    @Override
    public void execute(TaskList tasks, Storage storage, Ui ui) throws Exception {
        if(this.searchString.isEmpty()) {
            throw new EmptyInputException();
        }
        System.out.println("The tasks with that description is/are:");
        System.out.println(tasks.searchTasks(searchString));
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
