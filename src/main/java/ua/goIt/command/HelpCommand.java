package ua.goIt.command;

public class HelpCommand implements Command {
    @Override
    public void execute(String... param) {
        System.out.println("""
                migration - run migration
                all_salary: - get all salary from project. After ':' you need write name of project
                all_devFromPrj: -  get all developer from project. After ':' you need write name of project
                dev_skills: -  get all developer by skill. After ':' you need write name of skill.
                dev_level: -  get all developer by level. After ':' you need write name of level from this variant: Junior, Middle, Senior
                all_projects - get all projects
                create developer - add new developer. After ':' you need write data of developer in this format: name,age,(male of female),salary
                update developer - update developer. After ':' you need write new data of developer  in this format: name,age,gender,salary,id
                delete developer - remove developer. After ':' you need write id of developer
                read developer - find developer. After ':' you need write id of developer

                create project - add new project. After ':' you need write data of developer in this format: name,description,cost
                update project - update project. After ':' you need write new data of developer  in this format: name,description,cost,id
                delete project - remove project. After ':' you need write id of project
                read project - find project. After ':' you need write id of project

                create customer - add new customer. After ':' you need write data of customer in this format: first_name,last_name
                update customer - update customer. After ':' you need write new data of customer  in this format: first_name,last_name,id
                delete customer - remove customer. After ':' you need write id of customer
                read customer - find customer. After ':' you need write id of customer

                create company - add new company. After ':' you need write data of company in this format: name,quantity_employee
                update company - update company. After ':' you need write new data of company  in this format: name,quantity_employee,id
                delete company - remove company. After ':' you need write id of company
                read company - find company. After ':' you need write id of company

                create skills - add new skills. After ':' you need write data of skills in this format: language
                update skills - update skills. After ':' you need write new data of skills  in this format: language,id
                delete skills - remove skills. After ':' you need write id of skills
                read skills - find skills. After ':' you need write id of skills

                """);
    }
}
