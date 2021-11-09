package ua.goIt.command;


import java.util.Map;

public class CommandContainer {
    private final Map<String, Command> commandMap;
    private final UnknownCommand unknownCommand;

    public CommandContainer() {
        this.commandMap = Map.of(
                "migration", new MigrationCommand(),
                "allSalary", new AllSalaryCommand(),
                "allDevFromPrj", new AllUseDeveloperCommand(),
                "devSkills", new DeveloperSkillsCommand(),
                "devLevel", new DeveloperLevelCommand(),
                "allProjects", new AllProjectsCommand(),
                "help", new HelpCommand());
        unknownCommand = new UnknownCommand();
    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}
