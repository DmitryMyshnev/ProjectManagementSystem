package ua.goIt.command;

import ua.goIt.model.Developer;
import ua.goIt.services.DeveloperService;

import java.util.List;

public class DeveloperLevelCommand implements Command{


    @Override
    public void execute(String param) {
        List<Developer> devList = DeveloperService.getDeveloperLevel(param.split(" ")[0]);
        if (devList.isEmpty()) {
            System.out.println("No such  level '" + param + "'. Or developers does not have level '" + param + "'.");
        } else {
            devList.forEach(dev -> {
                System.out.println(dev.toString());
            });
        }
    }
}
