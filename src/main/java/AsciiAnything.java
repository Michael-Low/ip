
import AsciiAnything.command.Command;
import AsciiAnything.parser.Parser;
import AsciiAnything.storage.Storage;
import AsciiAnything.task.TaskList;
import AsciiAnything.ui.Ui;

public class AsciiAnything {
    private final Ui ui;
    private final TaskList tasks;
    private final Storage storage;

    public AsciiAnything(String filename) {
        ui = new Ui();
        storage = new Storage(filename);
        tasks = storage.loadTaskList();
    }

    public void run() {
        ui.printWelcome();
        boolean exit = false;
        while(!exit) {
            try {
                ui.printLine();
                String input = ui.nextLine();
                Command c = Parser.parse(input);
                c.execute(tasks, storage, ui);
                exit = c.isExit();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        storage.saveToFile(tasks);
    }

    public static void main(String[] args) {
        new AsciiAnything("./data.txt").run();
    }
}
