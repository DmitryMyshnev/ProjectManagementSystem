package ua.goIt.command;

public class HelpCommand implements Command{
    @Override
    public void execute(String... param) {
        System.out.println("migration - run migration\n" +
                "all_salary: - get all salary from project. After ':' you need write name of project\n" +
                "all_devFromPrj: -  get all developer from project. After ':' you need write name of project\n" +
                "dev_skills: -  get all developer by skill. After ':' you need write name of skill from this variant: Java, C#, C++, JS\n" +
                "dev_level: -  get all developer by level. After ':' you need write name of level from this variant: Junior, Middle, Senior\n" +
                "all_projects - get all projects\n" +
                "create developer - add new developer. After ':' you need write data of developer in this format: name,age,gender,salary\n" +
                "update developer - remove developer. After ':' you need write name of developer" +
                "delete developer - remove developer. After ':' you need write id of developer");
    }
}
