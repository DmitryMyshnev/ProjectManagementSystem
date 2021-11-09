package ua.goIt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.goIt.command.CommandContainer;

import java.util.Scanner;

public class App {

    private static final Logger LOGGER = LogManager.getLogger(App.class);
    private static final CommandContainer commandContainer = new CommandContainer();
    private static final DbStatement db = new DbStatement();

    public static void main(String[] args) {
        System.out.println("Use command 'help' for get name of commands.");
        runMainApp();
    }

    public static void runMainApp() {
        Scanner scanner = new Scanner(System.in);
        String arg;
        String command;
        while (scanner.hasNext()) {
            String[] data = scanner.nextLine().split(":");
            command = data[0];
            if (data.length > 1) {
                arg = data[1];
            } else {
                arg = "";
            }
            commandContainer.retrieveCommand(command).execute(arg);
        }
    }
}
