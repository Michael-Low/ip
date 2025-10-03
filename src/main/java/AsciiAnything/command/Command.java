package AsciiAnything.command;

import AsciiAnything.exceptions.WrongFormatException;
import AsciiAnything.storage.Storage;
import AsciiAnything.task.TaskList;
import AsciiAnything.ui.Ui;

public interface Command {
    public void execute(TaskList tasks, Storage storage, Ui ui) throws Exception;
    public boolean isExit();
}
