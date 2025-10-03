package AsciiAnything.parser;

import AsciiAnything.command.*;
import AsciiAnything.exceptions.WrongFormatException;

public class Parser {
    public static Command parse(String input) throws Exception{
        if (input.startsWith("mark ")) {
            String taskToMark = input.split(" ")[1];
            int taskNumber = Integer.parseInt(taskToMark) - 1;
            return new MarkCommand(taskNumber);
        }
        if (input.toLowerCase().startsWith("deadline ")) {
            return new AddCommand("deadline", input.substring("deadline ".length()));
        }
        if (input.toLowerCase().startsWith("event ")) {
            return new AddCommand("event",input.substring("event ".length()));
        }
        if (input.toLowerCase().startsWith("todo ")) {
            return new AddCommand("todo",input.substring("todo ".length()));
        }
        if(input.toLowerCase().startsWith("delete ")) {
            int index = Integer.parseInt(input.substring("delete ".length())) - 1;
            return new DeleteCommand(index);
        }
        if(input.toLowerCase().startsWith("find ")) {
            String search = input.substring("find ".length());
            return new FindCommand(search);
        }
        return switch (input) {
            case "list" -> new ListCommand();
            case "exit" -> new ExitCommand();
            default -> throw new WrongFormatException();
        };
    }
}
