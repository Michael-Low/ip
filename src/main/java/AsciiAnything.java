
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
            ui.printLine();
            String input = ui.nextLine();
            if (input.startsWith("mark")) {
                String taskToMark = input.split(" ")[1];
                int taskNumber = Integer.parseInt(taskToMark) - 1;
                tasks.markTask(taskNumber);
                System.out.println("Finally it's over... I have marked that task as done.");
                continue;
            }
            switch (input) {
                case "list":
                    System.out.println("Fine.... Here is your list of tasks:");
                    tasks.printTasks();
                    break;
                case "exit":
                    storage.saveToFile(tasks);
                    System.out.println("Come back never.");
                    exit = true;
                    break;
                default:
                    tasks.handleInput(input);
            }
        }
    }
    public static void main(String[] args) {
        new AsciiAnything("./data.txt").run();
    }
}
