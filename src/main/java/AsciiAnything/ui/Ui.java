package AsciiAnything.ui;

import java.util.Scanner;

public class Ui {
    public static final Scanner inputScanner = new Scanner(System.in);

    public void printLine() {
        System.out.println("---------------------------------------------");
    }

    public void printWelcome() {
        String welcomeText = "Hello! I'm AsciiAnything" + System.lineSeparator() +
                "What can I do for you?";
        System.out.println(welcomeText);
    }

    public String nextLine() {
        return inputScanner.nextLine();
    }
}
