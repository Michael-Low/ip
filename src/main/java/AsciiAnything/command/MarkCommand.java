package AsciiAnything.command;

import AsciiAnything.storage.Storage;
import AsciiAnything.task.TaskList;
import AsciiAnything.ui.Ui;

public class MarkCommand implements Command {
    private final int index;

    public MarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Storage storage, Ui ui) throws Exception{
        System.out.println("I have marked that task as done.");
        tasks.markTask(this.index);
        storage.saveToFile(tasks);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
