package AsciiAnything.command;

import AsciiAnything.exceptions.WrongFormatException;
import AsciiAnything.storage.Storage;
import AsciiAnything.task.TaskList;
import AsciiAnything.ui.Ui;

public class ExitCommand implements Command{
    @Override
    public void execute(TaskList tasks, Storage storage, Ui ui) throws Exception{
        System.out.println("Come back never.");
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
