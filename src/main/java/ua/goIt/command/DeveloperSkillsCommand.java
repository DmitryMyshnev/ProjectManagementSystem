package ua.goIt.command;

import ua.goIt.model.Developer;
import ua.goIt.services.DeveloperService;

import java.util.List;

public class DeveloperSkillsCommand implements Command {

    @Override
    public void execute(String param) {
        List<Developer> devList = DeveloperService.getDeveloperSkill(param.split(" ")[0]);
        if (devList.isEmpty()) {
            System.out.println("No such data!");
        } else {
            devList.forEach(dev -> {
                System.out.println(dev.toString());
            });
        }
    }
}
