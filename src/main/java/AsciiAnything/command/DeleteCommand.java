package AsciiAnything.command;

import AsciiAnything.storage.Storage;
import AsciiAnything.task.TaskList;
import AsciiAnything.ui.Ui;

public class DeleteCommand implements Command {
    private final int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(TaskList tasks, Storage storage, Ui ui) throws Exception{
        System.out.println("Deleting task.");
        tasks.deleteTask(index);
        storage.saveToFile(tasks);
        System.out.println("You now have " + tasks.size() + " tasks.");
    }
}
