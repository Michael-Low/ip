package AsciiAnything.command;

import AsciiAnything.storage.Storage;
import AsciiAnything.task.TaskList;
import AsciiAnything.ui.Ui;

public class ListCommand implements Command {
    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(TaskList tasks, Storage storage, Ui ui) throws Exception {
        System.out.println("Here is your list of tasks:");
        tasks.printTasks();
    }
}
