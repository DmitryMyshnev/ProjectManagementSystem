package ua.goIt.command;

import ua.goIt.services.DeveloperService;

public class AllSalaryCommand implements Command {

    @Override
    public void execute(String param) {
        Integer total = DeveloperService.getAllSalary(param);
        if(total == 0){
            System.out.println("No such  project '" + param + "'. Or '" + param + "' does not have developers.");
        }else
        System.out.println("Total: " + total);
    }
}
