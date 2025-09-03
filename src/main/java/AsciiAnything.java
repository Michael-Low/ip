import java.util.Scanner;

public class AsciiAnything {
    public static void main(String[] args) {
        String welcomeText = "Hello! I'm AsciiAnything\n" +
                "What can I do for you?\n";
        System.out.println(welcomeText);
        TaskList taskList = new TaskList();
        boolean exit = false;
        Scanner inputScanner = new Scanner(System.in);
        while(!exit) {
            String input = inputScanner.nextLine();
            if(input.startsWith("mark")) {
                String taskToMark = input.split(" ")[1];
                int taskNumber = Integer.parseInt(taskToMark) - 1;
                taskList.markTask(taskNumber);
                System.out.println("Sure! I have marked that task as done.");
                continue;
            }
            switch (input) {
                case "list":
                    System.out.println("Sure! Here is your list of tasks:");
                    taskList.printTasks();
                    break;
                case "exit":
                    System.out.println("Bye!");
                    exit = true;
                    break;
                default:
                    System.out.println("I have added this task to your list.");
                    taskList.addTask(input);
            }
        }
    }
}
