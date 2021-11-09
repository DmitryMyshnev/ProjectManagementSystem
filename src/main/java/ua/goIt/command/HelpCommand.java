package ua.goIt.command;

public class HelpCommand implements Command{
    @Override
    public void execute(String param) {
        System.out.println("migration - run migration\n" +
                "allSalary: - get all salary from project. After ':' you need write name of project\n" +
                "allDevFromPrj: -  get all developer from project. After ':' you need write name of project\n" +
                "devSkills: -  get all developer by skill. After ':' you need write name of skill from this variant: Java, C#, C++, JS\n" +
                "devLevel: -  get all developer by level. After ':' you need write name of level from this variant: Junior, Middle, Senior\n" +
                "allProjects - get all projects");
    }
}
