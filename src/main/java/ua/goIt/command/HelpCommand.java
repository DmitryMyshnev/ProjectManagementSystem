package ua.goIt.command;

public class HelpCommand implements Command {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    @Override
    public void execute(String... param) {
        System.out.print(ANSI_GREEN+ "migration" );
        System.out.println(ANSI_RESET+ "- run migration" );
        System.out.print(ANSI_GREEN+ "all_salary:" );
        System.out.println(ANSI_RESET+ " - get all salary from project. After ':' you need write name of project" );
        System.out.print(ANSI_GREEN+ "all_devFromPrj:");
        System.out.println(ANSI_RESET+ " -  get all developer from project. After ':' you need write name of project");
        System.out.print(ANSI_GREEN+ "dev_skills:" );
        System.out.println(ANSI_RESET+ "  -  get all developer by skill. After ':' you need write name of skill");
        System.out.print(ANSI_GREEN+ "dev_level:" );
        System.out.println(ANSI_RESET +" -  get all developer by level. After ':' you need write name of level from this variant: Junior, Middle, Senior");
        System.out.print(ANSI_GREEN+ "all_projects" );
        System.out.println(ANSI_RESET +" - get all projects\n");
        System.out.print(ANSI_GREEN+ "create developer:" );
        System.out.println(ANSI_RESET +"  write data of developer in this format: name,age,(male or female),salary");
        System.out.print(ANSI_GREEN+ "update developer:" );
        System.out.println(ANSI_RESET +"  write new data of developer  in this format: name,age,(male or female),salary,id");
        System.out.print(ANSI_GREEN+ "delete developer:" );
        System.out.println(ANSI_RESET +" write id of developer");
        System.out.print(ANSI_GREEN+ "read developer:");
        System.out.println(ANSI_RESET +" write id of developer\n");
        System.out.print(ANSI_GREEN+ "create project:" );
        System.out.println(ANSI_RESET +" write data of developer in this format: name,description,cost");
        System.out.print(ANSI_GREEN+ "update project:" );
        System.out.println(ANSI_RESET +" write new data of developer  in this format: name,description,cost,id");
        System.out.print(ANSI_GREEN+ "delete project:" );
        System.out.println(ANSI_RESET +" write id of project");
        System.out.print(ANSI_GREEN+ "read project:" );
        System.out.println(ANSI_RESET +" write id of project\n");
        System.out.print(ANSI_GREEN+ "create customer:" );
        System.out.println(ANSI_RESET +" write data of customer in this format: first_name,last_name");
        System.out.print(ANSI_GREEN+ "update customer:" );
        System.out.println(ANSI_RESET +" write new data of customer  in this format: first_name,last_name,id");
        System.out.print(ANSI_GREEN+ "delete customer:" );
        System.out.println(ANSI_RESET +" write id of customer");
        System.out.print(ANSI_GREEN+ "read customer:" );
        System.out.println(ANSI_RESET +" write id of customer\n");
        System.out.print(ANSI_GREEN+ "create company:" );
        System.out.println(ANSI_RESET +" write data of company in this format: name,quantity_employee");
        System.out.print(ANSI_GREEN+ "update company:" );
        System.out.println(ANSI_RESET +" write new data of company  in this format: name,quantity_employee,id");
        System.out.print(ANSI_GREEN+ "delete company:" );
        System.out.println(ANSI_RESET +" write id of company");
        System.out.print(ANSI_GREEN+ "read company:" );
        System.out.println(ANSI_RESET +" write id of company\n");
        System.out.print(ANSI_GREEN+ "create skills:" );
        System.out.println(ANSI_RESET +" write data of skills in this format: language");
        System.out.print(ANSI_GREEN+ "update skills:" );
        System.out.println(ANSI_RESET +" write new data of skills  in this format: language,id");
        System.out.print(ANSI_GREEN+ "delete skills:" );
        System.out.println(ANSI_RESET +" write id of skills");
        System.out.print(ANSI_GREEN+ "read skills :" );
        System.out.println(ANSI_RESET +" write id of skills");

    }
}
