package AsciiAnything.storage;

import AsciiAnything.task.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Storage {
    private final String filename;

    public Storage(String filename) {
        this.filename = filename;
    }

    public TaskList loadTaskList() {
        TaskList tasks = new TaskList();
        File file = new File(this.filename);
        if (file.exists()) {
            try {
                Scanner s = new Scanner(file);
                while (s.hasNextLine()) {
                    String line = s.nextLine();
                    String[] params = line.split("\\|");
                    String taskDesc = params[2];
                    boolean isDone = params[1].equals("1");
                    switch (params[0]) {
                        case "E":
                            String from = params[3];
                            String to = params[4];
                            tasks.addTask(new Event(taskDesc, from, to, isDone));
                            break;
                        case "D":
                            String by = params[3];
                            tasks.addTask(new Deadline(taskDesc, by, isDone));
                            break;
                        case "T":
                            tasks.addTask(new Todo(taskDesc, isDone));
                            break;
                    }
                }
            } catch (Exception e) {
                System.out.println("File could not be read: " + e.getMessage());
            }
        }
        return tasks;
    }

    public void saveToFile(TaskList tasks) {
        try {
            FileWriter fw = new FileWriter(filename);
            for(int i = 0; i < tasks.size(); i++) {
                if(i != 0) {
                    fw.append(System.lineSeparator());
                }
                fw.write(tasks.get(i).toSaveFormat());
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
